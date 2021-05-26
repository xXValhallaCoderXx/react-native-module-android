package com.custommoduleexample;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactMethod;
import android.widget.Toast;


public class OurModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private ReactContext ctx;

    OurModule(ReactApplicationContext context) {
        super(context);
        this.ctx = context;
        // Add this lide below
        context.addLifecycleEventListener(this);
    }

    @Override
    public void onHostResume() {
        Toast.makeText(ctx, "Hello - I have mounted", 2500).show();
    }

    @Override
    public void onHostPause() {

    }

    @Override
    public void onHostDestroy() {

    }

    @Override
    public String getName() {
        return "OurModule";
    }

    @ReactMethod
    public void openToast(String message) {
        Toast.makeText(ctx, message, 2500).show();
    }

    @ReactMethod
    public void heavyCalculation(Integer a, Integer b, Promise promise) {
        try {
            promise.resolve((a + b * 4) + "");
        } catch(Exception e) {
            promise.reject("Computer says no", "Error Mpas", e);
        }
    }
}