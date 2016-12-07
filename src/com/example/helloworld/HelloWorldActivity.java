package com.example.helloworld;

import com.example.helloworld.fragments.pages.FeedListFragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class HelloWorldActivity extends Activity {
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_helloworld);
		
	
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	void changeContentFragment()
	{
		Fragment newFrag = null;
		
		switch (index) {
		case 0: newFrag =  break;

		default:
			break;
		}
	}
}
