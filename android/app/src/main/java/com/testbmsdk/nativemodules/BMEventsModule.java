package com.testbmsdk.nativemodules;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class BMEventsModule extends ReactContextBaseJavaModule {

    public BMEventsModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "BMEventsModule";
    }
}
