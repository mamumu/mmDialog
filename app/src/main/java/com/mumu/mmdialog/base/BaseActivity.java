package com.mumu.mmdialog.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mumu.dialog.MMLoading;
import com.mumu.dialog.MMToast;


/**
 * @author : zlf
 * date    : 2019/4/17
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 */
public class BaseActivity extends AppCompatActivity {

    private MMLoading mmLoading;
    private MMToast mmToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void showLoading() {
        if (mmLoading == null) {
            MMLoading.Builder builder = new MMLoading.Builder(this)
                    .setMessage("加载中...")
                    .setCancelable(false)
                    .setCancelOutside(false);
            mmLoading = builder.create();
        }else {
            mmLoading.dismiss();
            MMLoading.Builder builder = new MMLoading.Builder(this)
                    .setMessage("加载中...")
                    .setCancelable(false)
                    .setCancelOutside(false);
            mmLoading = builder.create();
        }
        mmLoading.show();
    }

    protected void showLoading(String msg) {
        if (mmLoading == null) {
            MMLoading.Builder builder = new MMLoading.Builder(this)
                    .setMessage(msg)
                    .setCancelable(false)
                    .setCancelOutside(false);
            mmLoading = builder.create();
        }else {
            mmLoading.dismiss();
            MMLoading.Builder builder = new MMLoading.Builder(this)
                    .setMessage(msg)
                    .setCancelable(false)
                    .setCancelOutside(false);
            mmLoading = builder.create();
        }
        mmLoading.show();
    }

    protected void hideLoading() {
        if (mmLoading != null && mmLoading.isShowing()) {
            mmLoading.dismiss();
        }
    }

    protected void showToastSuccess(String msg) {
        if (mmToast == null) {
            MMToast.Builder builder=new MMToast.Builder(this)
                    .setMessage(msg)
                    .setSuccess(true);
            mmToast=builder.create();
        }else {
            mmToast.cancel();
            MMToast.Builder builder=new MMToast.Builder(this)
                    .setMessage(msg)
                    .setSuccess(true);
            mmToast=builder.create();
        }
        mmToast.show();
    }

    protected void showToastFailure(String msg) {
        if (mmToast == null) {
            MMToast.Builder builder=new MMToast.Builder(this)
                    .setMessage(msg)
                    .setSuccess(false);
            mmToast=builder.create();
        }else {
            mmToast.cancel();
            MMToast.Builder builder=new MMToast.Builder(this)
                    .setMessage(msg)
                    .setSuccess(false);
            mmToast=builder.create();
        }
        mmToast.show();
    }
}
