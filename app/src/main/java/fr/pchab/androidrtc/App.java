package fr.pchab.androidrtc;

import android.app.Application;

/**
 * Created by Sweven on 2020/8/3--10:44.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (!BuildConfig.DEBUG) new CrashHandle(this);
    }
}
