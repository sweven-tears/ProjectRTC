package fr.pchab.androidrtc;

import android.content.Context;
import android.content.Intent;
import android.os.Process;

/**
 * Created by Sweven on 2020/8/3--10:27.
 */
public class CrashHandle implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler defaultHandler;
    private Context context;

    public CrashHandle(Context context) {
        this.context = context;
        defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (!BuildConfig.DEBUG) {
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Intent intent = new Intent(context, FeedbackActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("throw", e.getMessage());
        context.startActivity(intent);
        Process.killProcess(Process.myPid());
    }
}
