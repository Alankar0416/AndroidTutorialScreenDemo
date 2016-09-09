package com.alankar.awesometutorials;

import com.urbanclap.provider.urbanclap_android_provider.BuildConfig;
import com.urbanclap.provider.urbanclap_android_provider.UCApplication;
import com.urbanclap.urbanclap.EnvConstants;

import utils.SharedPreferenceManager;

/**
 * Created by alankargupta on 07/09/16.
 */

public class DemoPolicy {

    public static boolean shouldShowDemo(DemoType demoType) {
        return BuildConfig.DEBUG || demoType != null && SharedPreferenceManager.getInstance(UCApplication.getInstance()).
                getSharedPreference().getBoolean(demoType.getKey(), true);
    }

    public static void updateDemoShownStatus(DemoType demo, boolean status) {
        if (demo == null) {
            return;
        }

        SharedPreferenceManager.getInstance(UCApplication.getInstance()).getSharedPreference()
                .edit().putBoolean(demo.getKey(), status).apply();
    }
}
