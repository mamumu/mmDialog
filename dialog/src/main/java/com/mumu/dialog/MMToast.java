package com.mumu.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author : zlf
 * date    : 2019-04-18
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 */
public class MMToast extends Toast {

    public MMToast(Context context) {
        super(context);
    }

    public static class Builder {
        private Context context;
        private String message;
        private boolean isSuccess = true;

        public Builder(Context context) {
            this.context = context;
        }

        /**
         * 设置toast的内容
         *
         * @param message
         * @return
         */
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * 是否是显示成功的toast，true:成功 false:失败
         *
         * @param isSuccess
         * @return
         */
        public Builder setSuccess(boolean isSuccess) {
            this.isSuccess = isSuccess;
            return this;
        }

        public MMToast create() {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.dialog_toast, null);
            MMToast mmToast = new MMToast(context);
            TextView msgText = view.findViewById(R.id.t_text);
            ImageView imageView = view.findViewById(R.id.t_image);
            if (!message.isEmpty()) {
                msgText.setText(message);
            }
            if (isSuccess) {
                imageView.setImageResource(R.drawable.ic_success);
            } else {
                imageView.setImageResource(R.drawable.ic_failure);
            }

            mmToast.setView(view);
            mmToast.setDuration(Toast.LENGTH_SHORT);
            mmToast.setGravity(Gravity.CENTER,0,0);
            return mmToast;
        }
    }
}
