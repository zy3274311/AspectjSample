package com.qihoo.aspectjlibrary;

import android.util.Log;

/**
 * Created by zhangying-pd on 2016/6/29.
 *
 * Wrapper around {@link android.util.Log}
 */
public class DebugLog {
    private DebugLog() {}

    /**
     * Send a debug log message
     *
     * @param tag Source of a log message.
     * @param message The message you would like logged.
     */
    public static void log(String tag, String message) {
        Log.e(tag, message);
    }
}
