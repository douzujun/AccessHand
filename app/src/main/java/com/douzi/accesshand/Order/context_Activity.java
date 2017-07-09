package com.douzi.accesshand.Order;

/**
 * Created by Douzi on 2017/7/1.
 */

import com.douzi.accesshand.MainActivity;
import com.douzi.accesshand.Me.pingjia_Activity;
import com.douzi.accesshand.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class context_Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView add_Pic;
    private ImageView add_pic2;
    private ImageView add_pic3;

    private Uri imageUri;
    private ImageView close_pic1;
    private ImageView close_pic2;
    private ScrollView mLie;
    private Button ramark_Commit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);

        //添加图片
        add_Pic = (ImageView)findViewById(R.id.m_menmian1_icon);
        add_Pic.setOnClickListener(this);

        //关闭图标
        close_pic1 = (ImageView) findViewById(R.id.m_image_one);
        close_pic2 = (ImageView) findViewById(R.id.m_image_two);

        //添加图片2
        add_pic2 = (ImageView) findViewById(R.id.m_menmian2_icon);
        add_pic2.setOnClickListener(this);

        //添加图片3
        add_pic3 = (ImageView) findViewById(R.id.m_menmian3_icon);

        //
        mLie = (ScrollView)findViewById(R.id.m_lie);
        //提交评价
        ramark_Commit = (Button)findViewById(R.id.m_commit);
        ramark_Commit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.m_menmian1_icon:            //添加图片
                new PopupWindows(context_Activity.this);
                break;
            case R.id.m_menmian2_icon:            //添加图片
                new PopupWindows(context_Activity.this);
                break;
            case R.id.m_commit:                   //提交评价
                Toast.makeText(getBaseContext(), "评价成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context_Activity.this, pingjia_Activity.class);
                startActivity(intent);
                finish();
            default:
                break;
        }
    }

    public class PopupWindows extends PopupWindow {

        public PopupWindows(Context mContext) {

            View view = View
                    .inflate(mContext, R.layout.activity_pop_window, null);
            view.startAnimation(AnimationUtils.loadAnimation(mContext,
                    R.anim.fade_ins));
            LinearLayout ll_popup = (LinearLayout) view
                    .findViewById(R.id.ll_popup);
            ll_popup.startAnimation(AnimationUtils.loadAnimation(mContext,
                    R.anim.push_bottom_in_2));

            setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            setBackgroundDrawable(new BitmapDrawable());
            setFocusable(true);
            setOutsideTouchable(true);
            setContentView(view);
            showAtLocation(mLie, Gravity.BOTTOM, 0, 0);
            update();

            View cView = view.findViewById(R.id.item_popupwindows_view);
            TextView bt1 = (TextView) view
                    .findViewById(R.id.item_popupwindows_camera);
            TextView bt2 = (TextView) view
                    .findViewById(R.id.item_popupwindows_Photo);
            TextView bt3 = (TextView) view
                    .findViewById(R.id.item_popupwindows_cancel);

            cView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    dismiss();
                }
            });
            bt1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //创建File对象，用于存储拍照后的图片
                    File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
                    try {
                        if (outputImage.exists()) {
                            outputImage.delete();
                        }
                        outputImage.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        imageUri = FileProvider.getUriForFile(context_Activity.this,
                                "com.douzi.accesshand.fileprovider", outputImage);
                    } else {
                        imageUri = Uri.fromFile(outputImage);
                    }
                    //启动相机程序
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, 1);
                    dismiss();
                }
            });
            bt2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(),"本地相册",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Complete action using"), 2);
                    dismiss();
                }
            });
            bt3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dismiss();
                }
            });
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            //设置图片的内容
            switch (requestCode) {
                case 1:
                    try {
                        //将拍摄的照片显示出来
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(imageUri));
                        add_Pic.setImageBitmap(bitmap);
                        add_pic2.setVisibility(View.VISIBLE);
                        close_pic1.setVisibility(View.VISIBLE);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
//                    add_Pic.setImageURI(data.getData());
//                    add_pic2.setVisibility(View.VISIBLE);
//                    close_pic1.setVisibility(View.VISIBLE);
                    add_pic2.setImageURI(data.getData());
                    add_pic3.setVisibility(View.VISIBLE);
                    close_pic2.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

