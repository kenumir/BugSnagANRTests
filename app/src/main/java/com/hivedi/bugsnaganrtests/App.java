package com.hivedi.bugsnaganrtests;

import android.app.Application;
import android.util.Log;

import com.bugsnag.android.Bugsnag;
import com.github.anrwatchdog.ANRError;
import com.github.anrwatchdog.ANRWatchDog;

/**
 * Created on 2016-07-19.
 */
public class App extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		Bugsnag.init(this);

		if (!BuildConfig.DEBUG) {
			new ANRWatchDog().setANRListener(new ANRWatchDog.ANRListener() {
				@Override
				public void onAppNotResponding(final ANRError error) {
					Log.e("tests", "ANR Error: " + error, error);
					Bugsnag.notify(error);
					throw error;
				}
			}).start();
		}
	}
}
