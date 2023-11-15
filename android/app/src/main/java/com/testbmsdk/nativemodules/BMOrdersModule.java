package com.testbmsdk.nativemodules;


import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;


public class BMOrdersModule extends ReactContextBaseJavaModule {

    public BMOrdersModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "BMOrdersModule";
    }
}
