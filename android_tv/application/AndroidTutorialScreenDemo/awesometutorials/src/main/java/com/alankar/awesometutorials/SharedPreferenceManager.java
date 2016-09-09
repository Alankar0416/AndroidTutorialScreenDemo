package com.alankar.awesometutorials;

import android.content.Context;
import android.content.SharedPreferences;

import com.urbanclap.provider.urbanclap_android_provider.AppConstants;

/**
 * Created by Alankar Gupta on 26/02/16.
 */
public class SharedPreferenceManager {
    private static SharedPreferenceManager ourInstance;
    private final SharedPreferences sharedPreference;

    private SharedPreferenceManager(Context context) {
        sharedPreference = context.getSharedPreferences(AppConstants.PREFERENCES,
                Context.MODE_PRIVATE);
    }

    public synchronized static SharedPreferenceManager getInstance(Context context) {
        if (ourInstance == null) {
            synchronized (SharedPreferenceManager.class) {
                if (ourInstance == null)
                    ourInstance = new SharedPreferenceManager(context);
            }
        }
        return ourInstance;
    }

    public SharedPreferences getSharedPreference() {
        return sharedPreference;
    }


}
