package jp.sio.testapp.mylocation;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by NTT docomo on 2017/05/26.
 * Log.d,Log.eにクラス名、メソッド名、行数を表示する
 */

public class L {
    public static void d(String msg){
        if(!BuildConfig.DEBUG) return;
        Log.d(getTag(),msg);
    }
    public static void e(String msg, Throwable t){
        Log.e(getTag(),msg, t);
    }

    public static  void e(String msg){
        Log.e(getTag(),msg);
    }

    /**
     * タグを生成する
     * @return className,method,line
     */
    private static String getTag() {
        //String regex = "&quot;[\\.]+&quot;"
        //Pattern p = Pattern.compile(regex);

        final StackTraceElement trace = Thread.currentThread().getStackTrace()[4];
        final String cla = trace.getClassName();
        final String mthd = trace.getMethodName();
        final int line = trace.getLineNumber();
        final String tag = cla + "," + mthd + "," + line;
        return tag;
    }
}