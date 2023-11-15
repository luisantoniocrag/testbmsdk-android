package com.testbmsdk;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.testbmsdk.nativemodules.BMAuthModule;
import com.testbmsdk.nativemodules.BMEventsModule;
import com.testbmsdk.nativemodules.BMOrdersModule;
import com.testbmsdk.viewmanagers.BMAuthViewManager;
import com.testbmsdk.viewmanagers.BMEventsViewManager;
import com.testbmsdk.viewmanagers.BMOrdersViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyAppPackage implements ReactPackage {

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        // Here the modules are added
        modules.add(new BMEventsModule(reactContext));
        modules.add(new BMOrdersModule(reactContext));
        modules.add(new BMAuthModule(reactContext));

        return modules;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new BMEventsViewManager(reactContext),
                new BMOrdersViewManager(reactContext),
                new BMAuthViewManager(reactContext)
        );
    }

}
