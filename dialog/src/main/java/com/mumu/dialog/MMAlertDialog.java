package com.mumu.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mumu.dialog.utils.DensityUtils;

/**
 * @author : zlf
 * date    : 2019-04-19
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 */
public class MMAlertDialog {
    /**
     * @param context        上下文
     * @param title          标题
     * @param content        内容
     * @param btnCancleText  取消按钮文本
     * @param btnSureText    确定按钮文本
     * @param touchOutside   外部取消
     * @param cancleListener 取消监听
     * @param sureListener   确定监听
     * @return
     */
    public synchronized static AlertDialog showDialog(Context context,
                                                      String title,
                                                      String content,
                                                      String btnCancleText,
                                                      String btnSureText,
                                                      boolean touchOutside,
                                                      DialogInterface.OnClickListener cancleListener,
                                                      DialogInterface.OnClickListener sureListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(touchOutside);
        dialog.setCancelable(false);

        View view = View.inflate(context, R.layout.alert_dialog, null);
        //标题
        TextView tvTitle = view.findViewById(R.id.tv_alert_title);
        //内容
        TextView tvContent = view.findViewById(R.id.tv_alert_content);
        //取消按钮
        Button buttonCancle = view.findViewById(R.id.btn_alert_cancel);
        //确定按钮
        Button buttonOk = view.findViewById(R.id.btn_alert_ok);
        //线
        View viewLine = view.findViewById(R.id.v_alert_line);

        if (TextUtils.isEmpty(title)) {
            tvTitle.setVisibility(View.GONE);
        } else {
            tvTitle.setText(title);
        }

        tvContent.setText(TextUtils.isEmpty(content) ? "" : content);

        if (TextUtils.isEmpty(btnCancleText)) {
            buttonCancle.setVisibility(View.GONE);
            viewLine.setVisibility(View.GONE);
        } else {
            buttonCancle.setText(btnCancleText);
        }

        buttonOk.setText(TextUtils.isEmpty(btnSureText) ? "确定" : btnSureText);
        final AlertDialog dialogFinal = dialog;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
        final DialogInterface.OnClickListener finalSureListener = sureListener;
        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalCancleListener.onClick(dialogFinal, DialogInterface.BUTTON_NEGATIVE);
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalSureListener.onClick(dialogFinal, DialogInterface.BUTTON_POSITIVE);
            }
        });

        //设置背景透明,去四个角
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        dialog.getWindow().setLayout(DensityUtils.dip2px(context, 290), LinearLayout.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setWindowAnimations(R.style.AnimMM);
        dialog.setContentView(view);

        return dialog;
    }


    /**
     * @param context        上下文
     * @param title          顶部标题
     * @param webUrl         网页的url
     * @param btnText        按钮的文字
     * @param checkText      CheckBox的文字
     * @param touchOutside   点击外部取消
     * @param sureListener   确定按钮的点击事件
     * @param cancleListener 取消按钮的点击事件
     * @param checkListener  checkbox的点击事件
     * @return
     */
    public synchronized static AlertDialog showDialogXieYi(Context context,
                                                           String title,
                                                           String webUrl,
                                                           String btnText,
                                                           String checkText,
                                                           boolean touchOutside,
                                                           DialogInterface.OnClickListener cancleListener,
                                                           DialogInterface.OnClickListener sureListener,
                                                           DialogInterface.OnMultiChoiceClickListener checkListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(touchOutside);
        dialog.setCancelable(false);

        // 是否包含标题，设置Title
        if (TextUtils.isEmpty(title)) {
            title = "提示";
        }
        View view = View.inflate(context, R.layout.alert_dialog_xieyi, null);
        //提示框title
        TextView tvTitle = view.findViewById(R.id.alert_tv_title);
        //网页webView
        WebView webView = view.findViewById(R.id.alert_wv);
        //按钮
        final Button button = view.findViewById(R.id.alert_btn);
        //CheckBox的说明文字
        TextView tvCheck = view.findViewById(R.id.alert_tv_check);
        //finish按钮
        ImageView imageView = view.findViewById(R.id.alert_iv_finish);
        //协议选中框
        CheckBox checkBox = view.findViewById(R.id.alert_cb);

        tvTitle.setText(title);
        button.setText(TextUtils.isEmpty(btnText) ? "确定" : btnText);
        tvCheck.setText(TextUtils.isEmpty(checkText) ? "" : checkText);
        webView.setWebViewClient(new WebViewClient());
        webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        //设置webView里字体大小
        WebSettings settings = webView.getSettings();
        settings.setTextZoom(55);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        webView.loadUrl(webUrl);
        final AlertDialog dialogFinal = dialog;
        final DialogInterface.OnClickListener finalSureListener = sureListener;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
        final DialogInterface.OnMultiChoiceClickListener finalCheckListener = checkListener;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalSureListener.onClick(dialogFinal, DialogInterface.BUTTON_POSITIVE);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalCancleListener.onClick(dialogFinal, DialogInterface.BUTTON_NEGATIVE);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                finalCheckListener.onClick(dialogFinal, 0, isChecked);
                if (isChecked) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }
        });
        //设置背景透明,去四个角
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        dialog.getWindow().setLayout(DensityUtils.dip2px(context, 290), LinearLayout.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setWindowAnimations(R.style.AnimMM);
        dialog.setContentView(view);

        return dialog;
    }

    /**
     *
     * @param context 上下文
     * @param imageUrl 图片url
     * @param touchOutside 外部取消
     * @param cancleListener 取消按钮监听
     * @param sureListener 确定按钮监听
     * @return
     */
    public synchronized static AlertDialog showDialogImage(Context context,
                                                           String imageUrl,
                                                           boolean touchOutside,
                                                           DialogInterface.OnClickListener cancleListener,
                                                           DialogInterface.OnClickListener sureListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(touchOutside);
        dialog.setCancelable(false);

        View view = View.inflate(context, R.layout.alert_dialog_image, null);
        ImageView ivSure = view.findViewById(R.id.iv_alert_image_sure);
        ImageView ivCancle = view.findViewById(R.id.iv_alert_image_cancle);
        if(!TextUtils.isEmpty(imageUrl)){
            Glide.with(context).load(imageUrl).into(ivSure);
        }
        final AlertDialog dialogFinal = dialog;
        final DialogInterface.OnClickListener finalSureListener = sureListener;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
        ivSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalSureListener.onClick(dialogFinal, DialogInterface.BUTTON_POSITIVE);
            }
        });
        ivCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalCancleListener.onClick(dialogFinal, DialogInterface.BUTTON_NEGATIVE);
            }
        });
        //设置背景透明,去四个角
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        dialog.getWindow().setLayout(DensityUtils.dip2px(context, 290), LinearLayout.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setWindowAnimations(R.style.AnimMM);
        dialog.setContentView(view);

        return dialog;
    }
}
