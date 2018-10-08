package com.aaa.test.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aaa.test.myapplication.recyclerview.RecyclerViewActivity;
import com.aaa.test.myapplication.utils.LoadingDialogUtils;
import com.xiasuhuei321.loadingdialog.view.LoadingDialog;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView channel_info_tv,sha1_info_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        channel_info_tv = findViewById(R.id.channel_info_tv_id);
        sha1_info_tv = findViewById(R.id.sha1_info_tv_id);

    }

    public void showChannelSignClick(View view) {
        Toast.makeText(this, "come on!", Toast.LENGTH_SHORT).show();
        
        
        ApplicationInfo appInfo = null;
        try {
            appInfo = this.getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String msg= appInfo.metaData.getString("ZW");
        System.out.println("app mate info is :" + msg);

        channel_info_tv.setText(msg);

//        MD5: 30:52:A2:7B:C3:92:E0:D8:1F:67:4B:5F:BC:3E:F3:51
//        SHA1: C4:C5:C8:05:3D:D7:E7:44:07:A7:8E:A1:C3:E9:72:86:8F:8C:6D:C2

        //loan
        //MD5: 8C:10:F2:43:74:DD:AF:7F:DD:19:C6:8A:12:39:D7:D9
        //SHA1: 03:54:66:91:1F:BA:04:6A:D1:91:19:07:A8:BA:78:8D:36:25:3F:F5
        String signal = AppInfoUtils.getSingInfo(getApplicationContext(), getPackageName(), AppInfoUtils.SHA1);
        System.out.println("sign info is " + signal);
        sha1_info_tv.setText(signal);
    }

    public void judgeJsonElementIsExistClick(View view) {
        try {
            String respone = "{\"code\":200,\"msg\":\"ok\"}";
            JSONObject responseJson = new JSONObject(respone);
            if (responseJson.has("code")){
                System.out.println("当前存在code字段！");
            }
            if (responseJson.has("zw")){
                System.out.println("当前存在zw字段！");
            }else{
                System.out.println("当前不存在zw字段！");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //------------------------------------------------

        boolean isDebug = AppInfoUtils.isApkInDebug(this);
        System.out.println("App is debug state =" + isDebug);

        Toast.makeText(this, "当前的apk的安装模式为：" + (isDebug?"debug":"release"), Toast.LENGTH_SHORT).show();
    }

    /*
     * 主体配置成功和错误的参数后，在取消对话框的时候，去动态判断具体应该显示正确的提示还是错误的提示！
     */
    public void loadingSuccessDialogClick(View view) {
        final LoadingDialog ld = new LoadingDialog(this);
        ld.setLoadingText("加载中...")
                .setSuccessText("加载成功啦啦啦！")
                .setFailedText("加载失败啦啦啦！")
                .setInterceptBack(true)
                .closeSuccessAnim()
                .closeFailedAnim()
                .show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ld.loadSuccess();
            }
        },1000) ;
    }

    public void loadingFaildDialogClick(View view) {
        final LoadingDialog ld = new LoadingDialog(this);
        ld.setLoadingText("加载中...")
                //.setSuccessText("加载成功啦啦啦！")//对应ld.loadSuccess();方法调用，会在加载完毕显示的成功提示信息
                //.setFailedText("加载失败啦啦啦！")//对应ld.loadFailed();方法调用，会在加载完毕显示的失败提示信息
                .setInterceptBack(true)
                .closeSuccessAnim()
                .closeFailedAnim()
                .show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //ld.loadFailed();//这种情况是伴有动画效果的

                ld.close();//不伴有动画的关闭方式
            }
        },1000) ;
    }

    /** 手机上的第三方app包名 **/
    public static final String[] TENCENT_QQ = {"com.tencent.qqlite","com.tencent.mobileqq"};
    public static final String[] WECHAT = {"com.tencent.mm"};
    public static final String[] JING_DONG = {"com.jingdong.app.mall"};
    public static final String[] PING_DUODUO = {"com.xunmeng.pinduoduo"};
    public static final String[] TAO_BAO = {"com.taobao.taobao"};


    public void judyAppInstallStateClick(View view) {
        /** 增加第三方应用安装判定 **/
        int tencentQQVaild = AppInfoUtils.isInstallClientApp(this,TENCENT_QQ) ? 1 : 0;
        int jingDongVaild = AppInfoUtils.isInstallClientApp(this,JING_DONG) ? 1 : 0;
        int taoBaoVaild = AppInfoUtils.isInstallClientApp(this,TAO_BAO) ?1 : 0;
        int pingDuoDuoVaild = AppInfoUtils.isInstallClientApp(this,PING_DUODUO) ?1 : 0;
        int weChatVaild = AppInfoUtils.isInstallClientApp(this,WECHAT)? 1 : 0;
        
    }

    public void databindingRecyclerViewClick(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
}
