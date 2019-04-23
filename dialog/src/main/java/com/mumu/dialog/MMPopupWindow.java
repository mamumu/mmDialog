package com.mumu.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mumu.dialog.popup.MMPopupWindowUtils;
import com.mumu.dialog.utils.DensityUtils;

/**
 * @author : zlf
 * date    : 2019-04-23
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 */
public class MMPopupWindow implements MMPopupWindowUtils.ViewInterface{
    private static MMPopupWindowUtils popupWindow;
    private static String mText1;
    private static String mText2;

    //向下弹出
    public synchronized void showDownPop(Context context, View view, String text1, String text2, int dpX, int dpY) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        mText1=text1;
        mText2=text2;
        popupWindow = new MMPopupWindowUtils.Builder(context)
                .setView(R.layout.popup_item)
                .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setBackGroundLevel(0.6f)
                .setAnimationStyle(R.style.AnimDown)
                .setOutsideTouchable(true)
                .setViewOnclickListener(this)
                .create();

        popupWindow.showAsDropDown(view, DensityUtils.dip2px(context, dpX),dpY);
    }

    @Override
    public void getChildView(View view, int layoutResId) {
        //获得PopupWindow布局里的View
        if (layoutResId == R.layout.popup_item) {
            TextView textView1 = view.findViewById(R.id.popup_text1);
            TextView textView2 = view.findViewById(R.id.popup_text2);
            textView1.setText(mText1);
            textView2.setText(mText2);
        }
    }
}
