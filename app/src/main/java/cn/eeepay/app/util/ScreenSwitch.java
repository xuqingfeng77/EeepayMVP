package cn.eeepay.app.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;



/**
 * Activity界面跳转
 */
public class ScreenSwitch {

    public static void switchActivity(Context context, Class<?> descClass, Bundle bundle,int reqcode) {
        Class<?> mClass = context.getClass();
        if (mClass == descClass) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setClass(context, descClass);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            ((Activity) context).startActivityForResult(intent, reqcode);
//            ((Activity) context).overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        } catch (Exception e) {
        }
    }


    public static void finish(Activity context) {
        context.finish();
//        context.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

}
