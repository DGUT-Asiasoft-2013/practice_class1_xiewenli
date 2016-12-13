package com.example.helloworld;

import java.io.IOException;

import com.example.helloworld.api.Server;
import com.example.helloworld.fragments.PasswordRecoverStep1Fragment;
import com.example.helloworld.fragments.PasswordRecoverStep1Fragment.OnGoNextListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.helloworld.fragments.PasswordRecoverStep2Fragment;
import com.example.helloworld.fragments.PasswordRecoverStep2Fragment.OnSubmitClickedListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class PasswordRecoverActivity extends Activity {
	PasswordRecoverStep1Fragment step1 = new PasswordRecoverStep1Fragment();
	PasswordRecoverStep2Fragment step2 = new PasswordRecoverStep2Fragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_password_recover);

		step1.setOnGoNextListener(new OnGoNextListener() {

			@Override
			public void onGoNext() {
				goStep2();

			}
		});
		
		step2.setOnSubmitClickedListener(new OnSubmitClickedListener() {
			
			@Override
			public void onSubmitClicked() {
				goSubmit();
			}
		});

		getFragmentManager().beginTransaction().replace(R.id.container, step1).commit();
	}

	void goStep2() { // 动画渐变效果
		getFragmentManager()
		.beginTransaction().setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left,
						R.animator.slide_in_left, R.animator.slide_out_right)
				.replace(R.id.container, step2).addToBackStack(null).commit();
	}
	
	void goSubmit()
	{
		String email = step1.getEmail();
		String password = step2.getPassword();
		String passwordRepeat = step2.getPasswordRepeat();
		
		if (email.equals("") || password.equals("")){
			new AlertDialog.Builder(this)
			.setTitle("提示")
			.setMessage("未填写邮箱或密码！")
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
						
				}
			}).show();
			return ;
		}
		
		if (!password.equals(passwordRepeat))
		{
			new AlertDialog.Builder(PasswordRecoverActivity.this)
					.setMessage("两次输入密码不一致！")
					.show();
			return;
		}
		
		OkHttpClient client = Server.getSharedClient();
		MultipartBody body = new MultipartBody.Builder()
							.addFormDataPart("email", step1.getEmail())
							.addFormDataPart("passwordHash", MD5.getMD5(step2.getPassword()))
							.build();
		Request request = Server.requestBuliderWithApi("passwordrecover").post(body).build();
		
		client.newCall(request).enqueue(new Callback() {
			
			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				
				try{
					final Boolean succeed = new ObjectMapper().readValue(arg1.body().bytes(), Boolean.class);
					
					runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							if (succeed) {
								new AlertDialog.Builder(PasswordRecoverActivity.this)
										.setTitle("请求成功")
										.setMessage("修改密码成功！")
										.setPositiveButton("OK", new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface dialogInterface, int i) {

											}
										}).show();
							}else {
								new AlertDialog.Builder(PasswordRecoverActivity.this)
										.setTitle("请求成功")
										.setMessage("修改密码失败！")
										.setPositiveButton("OK", new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface dialogInterface, int i) {

											}
										}).show();
							}

						}
					});
				}catch (Exception e) {
						runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							Toast.makeText(PasswordRecoverActivity.this, "邮箱错误！", Toast.LENGTH_SHORT).show(); 
						}
					});
					
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(Call arg0, IOException arg1) {
					runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						new AlertDialog.Builder(PasswordRecoverActivity.this)
									.setTitle("请求失败")
									.setNegativeButton("OK", new OnClickListener() {
										
										@Override
										public void onClick(DialogInterface dialog, int which) {
											
										}
									})
									.show();						
					}
				});
				
			}
		});
	}

	
	
	
	
//	void passwordRecover() {
//		String email = step1.getText();
//		String passwordHash = step2.getPassword();
//		String passwordRepeat = step2.getPasswordRepeat();
//
//		if (passwordRepeat.equals("") || passwordHash.equals("")) {
//			new AlertDialog.Builder(PasswordRecoverActivity.this)
//					.setMessage("输入密码不能为空！")
//					.setNegativeButton("OK", null)
//					.show();
//			return;
//		}
//		if (!passwordHash.equals(passwordRepeat))
//		{
//			new AlertDialog.Builder(PasswordRecoverActivity.this)
//					.setMessage("两次输入密码不一致！")
//					.setNegativeButton("OK", null)
//					.show();
//			return;
//		}
//		
//		passwordHash = MD5.getMD5(passwordHash);
//		OkHttpClient okHttpClient = Server.getSharedClient();
//		RequestBody requestBody = new MultipartBody.Builder()
//				.setType(MultipartBody.FORM)
//				.addFormDataPart("email", email)
//				.addFormDataPart("passwordHash", passwordHash)
//				.build();
//		Request request = Server.requestBuliderWithApi("passwordrecover")
//				.method("post", null)
//				.post(requestBody)
//				.build();
//		okHttpClient.newCall(request).enqueue(new Callback() {
//			
//			@Override
//			public void onResponse(Call arg0, Response arg1) throws IOException {
//				final Boolean succeed = new ObjectMapper().readValue(arg1.body().bytes(), Boolean.class);
//				
//				runOnUiThread(new Runnable() {
//					
//					@Override
//					public void run() {
//						if (succeed) {
//							new AlertDialog.Builder(PasswordRecoverActivity.this)
//									.setTitle("请求成功")
//									.setMessage("修改密码成功！")
//									.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//										@Override
//										public void onClick(DialogInterface dialogInterface, int i) {
//
//										}
//									}).show();
//						}else {
//							new AlertDialog.Builder(PasswordRecoverActivity.this)
//									.setTitle("请求成功")
//									.setMessage("修改密码失败！")
//									.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//										@Override
//										public void onClick(DialogInterface dialogInterface, int i) {
//
//										}
//									}).show();
//						}
//
//					}
//				});
//			}
//			
//			@Override
//			public void onFailure(Call arg0, IOException e) {
//					runOnUiThread(new Runnable() {
//					
//					@Override
//					public void run() {
//						new AlertDialog.Builder(PasswordRecoverActivity.this)
//									.setTitle("请求失败")
//									.setNegativeButton("OK", new OnClickListener() {
//										
//										@Override
//										public void onClick(DialogInterface dialog, int which) {
//											
//										}
//									})
//									.show();						
//					}
//				});
//				
//			}
//		});
//	}
	
	
}
