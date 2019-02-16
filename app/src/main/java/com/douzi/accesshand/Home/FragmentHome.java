package com.douzi.accesshand.Home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.douzi.accesshand.R;
import com.douzi.accesshand.RegionSelectActivity;
import com.douzi.accesshand.region_DB.*;
import com.google.gson.Gson;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import java.util.ArrayList;

/**
 * Created by quan on 2017/3/22.
 */

public class FragmentHome extends Fragment implements ViewPager.OnPageChangeListener,View.OnClickListener{
    private static final int REGION_REQUEST_CODE = 001;

    private TextView tv_result;        //保存得到的地区
    private LinearLayout linearLayout; //存放小白点
    private ViewPager viewPager;       //获取viewPager
    private TextView textView;         //获取文本描述的TextView
    private int[] imageResIds;         //保存图片资源ID数组
    private String[] imageText;        //图片描述数组
    private Intent search_info;

    ViewPagerAdapter viewpagerAdapter = new ViewPagerAdapter();
    private boolean isRunning = true;

    //事物处理代码
    private Button icon_1;

    private LinearLayout pic_1;
    private LinearLayout pic_2;
    private LinearLayout pic_3;
    private LinearLayout pic_4;

    private RelativeLayout tongzhi_1;
    private RelativeLayout tongzhi_2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);

        SpeechUtility.createUtility(getContext(), SpeechConstant.APPID +"=590e964a");

        //初始化视图
        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        textView = (TextView)view.findViewById(R.id.home_image_desc);
        viewPager.setOnPageChangeListener((ViewPager.OnPageChangeListener) this);
        linearLayout = (LinearLayout) view.findViewById(R.id.home_point_container);
        //初始化地图选择器
        tv_result = (TextView) view.findViewById(R.id.region_text);

        icon_1 = (Button) view.findViewById(R.id.quick_recive);
        pic_1 = (LinearLayout)view.findViewById(R.id.show_text_1);
        pic_2 = (LinearLayout)view.findViewById(R.id.show_text_2);
        pic_3 = (LinearLayout)view.findViewById(R.id.show_text_3);
        pic_4 = (LinearLayout)view.findViewById(R.id.show_text_4);
        icon_1.setOnClickListener(this);
        pic_1.setOnClickListener(this);
        pic_2.setOnClickListener(this);
        pic_3.setOnClickListener(this);
        pic_4.setOnClickListener(this);


        tongzhi_1 = (RelativeLayout)view.findViewById(R.id.tongzhi_1);
        tongzhi_2 = (RelativeLayout)view.findViewById(R.id.tongzhi_2);
        tongzhi_2.setOnClickListener(this);
        tongzhi_1.setOnClickListener(this);
        view.findViewById(R.id.region_select).setOnClickListener(this);
        view.findViewById(R.id.ic_voice).setOnClickListener(this);
        //初始化数据
        initData();
        //初始化适配器
        initAdapter();
        // 开启轮询
        isRunning = true;
        new Thread(){
            public void run() {
                while(isRunning){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 往下跳一位
                    Activity activity = (Activity)getContext();
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                        }
                    });
                }
            };
        }.start();
        return view;
    }

    @Override
    public void onDestroyView() {
        isRunning = false;
        super.onDestroyView();
    }

    private void initData() {

        // 图片资源id数组
        imageResIds = new int[]{R.drawable.home_viewpager_image1, R.drawable.home_viewpager_image2,
                R.drawable.home_viewpager_image3, R.drawable.home_viewpager_image4, R.drawable.home_viewpager_image5};
        // 文本描述
        imageText = new String[]{
                "找快递，用人人快递!",
                "做自由快递人,接件自由,工作时间自由！",
                "想要……懒得动? 没有空?",
                "充实生活!利用空余时间赚取外快!",
                "只要你一声令下,我为你一触即发"
        };

        // 初始化要展示的5个ImageView
        viewpagerAdapter.imageViewList = new ArrayList<ImageView>();

        ImageView imageView;
        View pointView;
        LinearLayout.LayoutParams layoutParams;
        for (int i = 0; i < imageResIds.length; i++) {
            // 初始化要显示的图片对象
            imageView = new ImageView(getContext());
            imageView.setBackgroundResource(imageResIds[i]);
            viewpagerAdapter.imageViewList.add(imageView);

            // 加小白点, 指示器
            pointView = new View(getContext());
            pointView.setBackgroundResource(R.drawable.pointer_selector);
            layoutParams = new LinearLayout.LayoutParams(15, 15);
            if(i != 0)
                layoutParams.leftMargin = 20;
            // 设置默认所有都不可用
            pointView.setEnabled(false);
            linearLayout.addView(pointView,layoutParams);
        }

    }

    private void initAdapter() {
        //将第一张图片的状态设置为true
        linearLayout.getChildAt(0).setEnabled(true);
        textView.setText(imageText[0]);
        // 设置适配器
        viewPager.setAdapter(viewpagerAdapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //滚动时调用
    }

    @Override
    public void onPageSelected(int position) {
        //新条目被选中时调用
        int newPosition = position % viewpagerAdapter.imageViewList.size();
        textView.setText(imageText[newPosition]);
        for(int i=0;i<5;i++){
            if(i==newPosition){
                linearLayout.getChildAt(i).setEnabled(true);
            }else{
                linearLayout.getChildAt(i).setEnabled(false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //滚动状态变化时调用
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.region_select:
                DBCopyUtil.copyDataBaseFromAssets(getContext(), "region.db");
                startActivityForResult(new Intent(getContext(), RegionSelectActivity.class), REGION_REQUEST_CODE);
                break;
            case R.id.quick_recive:
                //Toast.makeText(getContext(),"快速接单",Toast.LENGTH_SHORT).show();
                if(icon_1.getText().equals("快速接单"))
                {
                    Toast.makeText(getContext(),"开启快速接单模式",Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("通知");
                    builder.setMessage("您有新的快递订单，请及时查收!");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                    icon_1.setText("关闭快速接单");
                }else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("通知");
                    builder.setMessage("将取消快速接单模式 !");

                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            icon_1.setText("快速接单");

                        }
                    });

                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
                break;
            case R.id.show_text_1:
                search_info = new Intent(getContext(),search_Activity.class);
                search_info.putExtra("item","1");
                startActivity(search_info);
                break;
            case R.id.show_text_2:
                search_info = new Intent(getContext(),search_Activity.class);
                search_info.putExtra("item","2");
                startActivity(search_info);
                break;
            case R.id.show_text_3:
                search_info = new Intent(getContext(),search_Activity.class);
                search_info.putExtra("item","3");
                startActivity(search_info);
                break;
            case R.id.show_text_4:
                search_info = new Intent(getContext(),search_Activity.class);
                search_info.putExtra("item","4");
                startActivity(search_info);
                break;

            case R.id.tongzhi_1:
                search_info = new Intent(getContext(),search_Activity.class);
                search_info.putExtra("item","5");
                startActivity(search_info);
                break;
            case R.id.tongzhi_2:
                search_info = new Intent(getContext(),search_Activity.class);
                search_info.putExtra("item","6");
                startActivity(search_info);
                break;
            case R.id.ic_voice:
                initSpeech(getContext());
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REGION_REQUEST_CODE && resultCode == 200) {
            String province = data.getStringExtra(RegionSelectActivity.REGION_PROVINCE);
            String city = data.getStringExtra(RegionSelectActivity.REGION_CITY);
            String area = data.getStringExtra(RegionSelectActivity.REGION_AREA);

            tv_result.setText(city);
        }
    }

    @Override
    public void onDestroy() {
        isRunning = false;
        super.onDestroy();
    }


    /**
     * 初始化语音识别
     */
    public void initSpeech(final Context context) {
        //1.创建RecognizerDialog对象
        RecognizerDialog mDialog = new RecognizerDialog(context, null);
        //2.设置accent、language等参数
        mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");
        //3.设置回调接口
        mDialog.setListener(new RecognizerDialogListener() {
            @Override
            public void onResult(RecognizerResult recognizerResult, boolean isLast) {
                if (!isLast) {
                    //解析语音
                    String result = parseVoice(recognizerResult.getResultString());
                    if(result.equals("打电话给刘洋")) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:18206295929"));
                        startActivity(intent);
                    }else {
                        Toast.makeText(getContext(),result,Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onError(SpeechError speechError) {

            }
        });
        //4.显示dialog，接收语音输入
        mDialog.show();
    }

    /**
     * 解析语音json
     */
    public String parseVoice(String resultString) {
        Gson gson = new Gson();
        Voice voiceBean = gson.fromJson(resultString, Voice.class);

        StringBuffer sb = new StringBuffer();
        ArrayList<Voice.WSBean> ws = voiceBean.ws;
        for (Voice.WSBean wsBean : ws) {
            String word = wsBean.cw.get(0).w;
            sb.append(word);
        }
        return sb.toString();
    }

    /**
     * 语音对象封装
     */
    public class Voice {

        public ArrayList<WSBean> ws;

        public class WSBean {
            public ArrayList<CWBean> cw;
        }

        public class CWBean {
            public String w;
        }
    }
}
