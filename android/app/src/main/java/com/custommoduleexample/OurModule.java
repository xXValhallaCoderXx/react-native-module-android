package com.custommoduleexample;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.widget.Toast;


public class OurModule extends ReactContextBaseJavaModule {
    private ReactContext mReactContext;
    
    OurModule(ReactApplicationContext context) {
        super(context);
        this.mReactContext = context;
    }

    @Override
    public String getName() {
        return "OurModule";
    }

    @ReactMethod
    public void openToast(String message) {
        Toast.makeText(mReactContext, message, 2500).show();
    }
}