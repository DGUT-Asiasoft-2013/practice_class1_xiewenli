package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class BootActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_boot);
		
		
	}
	
	protected void onResume()  //开始界面。1000ms后进入LoginActivity
	{
		super.onResume();
			
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			private int abcd = 0;
			
			public void run(){
				startLoginActivity();
			}
		}, 1000);
		
	}
	
	void startLoginActivity()  //进入LoginActivity
	{
		Intent itnt = new Intent(this, LoginActivity.class);
		startActivity(itnt);
		finish();
	}
}
