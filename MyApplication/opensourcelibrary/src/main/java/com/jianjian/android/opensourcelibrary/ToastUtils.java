package com.jianjian.android.opensourcelibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Lenovo on 2017/9/30.
 */

public class ToastUtils {
    //显示消息
    public static void showToast(Context context, String str){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }
}
