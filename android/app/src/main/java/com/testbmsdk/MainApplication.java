package com.testbmsdk;

import static com.boletomovil.core.di.RemoteDataSourceModuleKt.createOkHttpClientWithInterceptor;
import static com.boletomovil.core.lifecycle.BoletomovilApplicationKt.startBoletomovil;
import static com.boletomovil.tickets.di.BoletomovilTicketsModuleKt.getBoletomovilTicketsModule;

import android.app.Application;

import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.soloader.SoLoader;
import com.google.zxing.BarcodeFormat;

import java.util.List;

import okhttp3.OkHttpClient;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost =
      new DefaultReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
          return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
          @SuppressWarnings("UnnecessaryLocalVariable")
          List<ReactPackage> packages = new PackageList(this).getPackages();
          // Packages that cannot be autolinked yet can be added manually here, for example:
          // packages.add(new MyReactNativePackage());

          packages.add(new MyAppPackage());
          return packages;
        }

        @Override
        protected String getJSMainModuleName() {
          return "index";
        }

        @Override
        protected boolean isNewArchEnabled() {
          return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
        }

        @Override
        protected Boolean isHermesEnabled() {
          return BuildConfig.IS_HERMES_ENABLED;
        }
      };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
      // If you opted-in for the New Architecture, we load the native entry point for this app.
      DefaultNewArchitectureEntryPoint.load();
    }

    ReactNativeFlipper.initializeFlipper(this, getReactNativeHost().getReactInstanceManager());


    // Update this variable values
    Boolean isDevelopment = false;
    String  teamName = "Sultanes";
    String  appIdentifierName = "sultanes";
    Integer bmTeamID = 80;
    String defaultPhoneCountryCode = "52";
    String applicationID = "com.boletomovil.sultanes"; // the app's ID in the play store


    // Create custom client (this is mandatory in order check what APP is calling the SDK - All anonymous apps will be blocked from the SDK)
      // it needs an app identifier string and the version of the code
      OkHttpClient customClient = createOkHttpClientWithInterceptor(
              appIdentifierName,
              String.valueOf(BuildConfig.VERSION_CODE)
      );

    // Start the boletomovil configuration
      startBoletomovil(
              this,
            bmTeamID,
            teamName,
              isDevelopment,
            false,
            defaultPhoneCountryCode,
            BarcodeFormat.QR_CODE,
            java.util.Arrays.asList(
                    getBoletomovilTicketsModule(teamName)
            ),
            java.util.Arrays.asList(),
              applicationID,
              customClient
    );
  }
}
