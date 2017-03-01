package com.toyberman.localeReload;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class RNReactNativeLocaleModule extends ReactContextBaseJavaModule implements LifecycleEventListener {

    final BroadcastReceiver receiver;

    public RNReactNativeLocaleModule(final ReactApplicationContext reactContext) {
        super(reactContext);

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Configuration newConfig = intent.getParcelableExtra("newConfig");
                WritableMap params = Arguments.createMap();
                params.putString("locale", newConfig.locale.toString());
                if (reactContext.hasActiveCatalystInstance()) {
                    reactContext
                            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                            .emit("localeDidChange", params);
                }
            }
        };
        reactContext.addLifecycleEventListener(this);

    }

    @Override
    public String getName() {
        return "RNReactNativeLocale";
    }

    @Override
    public void onHostResume() {

        final Activity activity = getCurrentActivity();

        assert activity != null;

        activity.registerReceiver(receiver, new IntentFilter("onConfigurationChanged"));
    }

    @Override
    public void onHostPause() {
        final Activity activity = getCurrentActivity();
        if (activity == null) return;
    }

    @Override
    public void onHostDestroy() {
        final Activity activity = getCurrentActivity();
        if (activity == null) return;

        try {
            activity.unregisterReceiver(receiver);
        } catch (java.lang.IllegalArgumentException e) {
            FLog.e(ReactConstants.TAG, "receiver already unregistered", e);
        }
    }

}
