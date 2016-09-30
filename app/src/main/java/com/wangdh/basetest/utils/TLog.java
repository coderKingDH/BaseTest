package com.wangdh.basetest.utils;

import android.util.Log;

/**
 * 作者: wdh <br>
 * 内容摘要: <br>
 * 创建时间:  2016/8/22 13:59<br>
 * 描述:  <br>
 */
public class TLog {
    public static void l(String msg){
        d("wdh",msg);
    }
    public static void e(String TAG,String msg){
        Log.e(TAG,msg);
    }
    public static void d(String TAG,String msg){
        Log.d(TAG,msg);
    }
}
