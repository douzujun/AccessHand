package com.douzi.accesshand.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import com.douzi.accesshand.R;

public class search_Activity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton search_Left;
    private TextView icondescribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        WebView webView = (WebView)findViewById(R.id.web_view);
        search_Left = (ImageButton)findViewById(R.id.btn_search_left);
        icondescribe = (TextView)findViewById(R.id.icon_describ);
        search_Left.setOnClickListener(this);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        Intent intent = getIntent();
        String icon = intent.getStringExtra("item");
        switch (icon){
            case "1":
                icondescribe.setText("快递员奖惩制度");
                webView.loadUrl("http://www.doc88.com/p-5844405367991.html");
                break;
            case "2":
                icondescribe.setText("快递员服务规范");
                webView.loadUrl("http://www.wxphp.com/wxd_36d4081dzc4m0xd0pdy0_1.html");
                break;
            case "3":
                icondescribe.setText("线上支付赢大奖");
                webView.loadUrl("https://fun.alipay.com/zfdm/index.htm?_bdType=aibhbbafbgjefbcjaica&src=fuchu1009");
                break;
            case "4":
                icondescribe.setText("平台费用纠纷小贴士");
                webView.loadUrl("http://www.66law.cn/fangan/anli_353/");
                break;
            case "5":
                icondescribe.setText("平台通知");
                webView.loadUrl("http://baike.baidu.com/link?url=g-eWGsN9ZKKhXU-hhWleEbUXpldCihpTeiObklJ9f23D_IWOHiTaSZoa4xPRVazeF-LqjOJ4XluLGfyOw3wVVOEZQlTN35SRBy1YK3j-2UERvjDWRwtpHw1car_Enmtkyly9Hjl4KMyLP59NudHsb9q0B31ZtHcobLgbwDP70o__Gat9xbGzFtBGfzeDSrcD");
                break;
            case "6":
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_search_left:
                finish();
                break;
            default:
                break;
        }
    }
}
