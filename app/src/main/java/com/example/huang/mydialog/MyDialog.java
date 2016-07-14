package com.example.huang.mydialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import java.util.zip.Inflater;

/**
 * Created by huang on 16-7-14.
 */
public class MyDialog extends Dialog {
    private View mRootView;
    private Context mContext;
    public MyDialog(Context context, int dialog) {

        super(context,dialog);
        mRootView = View.inflate(context, R.layout.dialog, null);
        this.mContext = context;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mRootView);
    }

    public void show() {
        if ((mContext instanceof Activity) && !((Activity) mContext).isFinishing()) {
            super.show();
            //设置dialog大小
            Window window = this.getWindow();
            window.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);  //此处可以设置dialog显示的位置
            Display d = window.getWindowManager().getDefaultDisplay();  //为获取屏幕宽、高
            WindowManager.LayoutParams p = window.getAttributes();  //获取对话框当前的参数值
            p.width = (int) (d.getWidth() * 1.0);    //宽度设置为屏幕宽度
            window.setAttributes(p);     //设置生效
        }
    }

    public static class Builder{
        private Context context;

        public Builder(Context context) {
            this.context = context;
        }

        public MyDialog create(){
            MyDialog dialog = new MyDialog(context, R.style.Dialog);

            return dialog;
        }

    }
}
