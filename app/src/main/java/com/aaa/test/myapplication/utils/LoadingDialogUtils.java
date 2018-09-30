package com.aaa.test.myapplication.utils;

import android.content.Context;

import com.xiasuhuei321.loadingdialog.view.LoadingDialog;

/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2017/5/31 9:51
 * <p/>
 * Description:
 */
public class LoadingDialogUtils {
    public LoadingDialog show(Context context) {
        LoadingDialog loadingDialog = new LoadingDialog(context);
        loadingDialog.setLoadingText("loading")
                .closeSuccessAnim()
                .closeFailedAnim()
//                .hideSuccessView()
//                .hideFailedView()
                .show();
        return loadingDialog;
    }
}
