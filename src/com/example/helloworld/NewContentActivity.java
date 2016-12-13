package com.example.helloworld;

import java.io.IOException;

import com.example.helloworld.api.Server;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;

public class NewContentActivity extends Activity {//发表新文章界面
	
	EditText editTitle, editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_content);
		
		editTitle = (EditText) findViewById(R.id.title);
		editText = (EditText) findViewById(R.id.text);
		
		findViewById(R.id.btn_send).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				finish();
//				overridePendingTransition(R.anim.none, R.anim.slide_out_bottom);
				sendContent();
			}
		});
	}
	
	void sendContent()
	{
		String title = editTitle.getText().toString();
		String text = editText.getText().toString();
		
		MultipartBody body = new MultipartBody.Builder()
							.addFormDataPart("title", title)
							.addFormDataPart("text", text)
							.build();
		
		Request request = Server.requestBuliderWithApi("article")
						.post(body)
						.build();
		
		Server.getSharedClient().newCall(request).enqueue(new Callback() {
			
			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				final String responBody = arg1.body().string();
				
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						NewContentActivity.this.onSucceed(responBody);
						
					}
				});
				
			}
			
			@Override
			public void onFailure(Call arg0, final IOException arg1) {
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						NewContentActivity.this.onFailure(arg1);
						
					}
				});
				
			}
		});
	}
	
	void onSucceed(String text){
		new AlertDialog.Builder(this).setMessage(text)
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
				overridePendingTransition(R.anim.none, R.anim.slide_out_bottom);
			}
		}).show();
	}
	
	void onFailure(Exception e){
		new AlertDialog.Builder(this).setMessage(e.getMessage()).show();
}

}
