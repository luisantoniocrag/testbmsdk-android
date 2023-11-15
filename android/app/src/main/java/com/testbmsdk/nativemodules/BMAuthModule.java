package com.testbmsdk.nativemodules;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class BMAuthModule extends ReactContextBaseJavaModule {

    // Just the constructor and it accepts a context as a parameter then pass through the parent constructor
    public BMAuthModule(ReactApplicationContext context) {
        super(context);
    }

    // Name of the native module
    @Override
    public String getName () {  return "BMAuthModule"; }
}
