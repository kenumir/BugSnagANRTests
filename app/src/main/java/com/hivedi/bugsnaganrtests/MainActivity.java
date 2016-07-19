package com.hivedi.bugsnaganrtests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bugsnag.android.Bugsnag;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void handleClick(View view) {
		try {
			Thread.sleep(20_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void handleClick2(View view) {
		if (1==1) {
			throw new RuntimeException("Test error for BugSnag");
		}
		//Bugsnag.notify(new RuntimeException("Test"));
	}
}
