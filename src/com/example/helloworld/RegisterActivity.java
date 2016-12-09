package com.example.helloworld;

import com.example.helloworld.fragments.inputcells.SimpleTextInputCellFragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RegisterActivity extends Activity {
	
	SimpleTextInputCellFragment fragInputCellAccount;
	SimpleTextInputCellFragment fragInputEmailAddress;
	SimpleTextInputCellFragment fragInputCellPassword;
	SimpleTextInputCellFragment fragInputCellPasswordRepeat;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		fragInputCellAccount = (SimpleTextInputCellFragment)getFragmentManager().findFragmentById(R.id.input_account);
		fragInputEmailAddress = (SimpleTextInputCellFragment)getFragmentManager().findFragmentById(R.id.input_email);
		fragInputCellPassword = (SimpleTextInputCellFragment)getFragmentManager().findFragmentById(R.id.input_password);
		fragInputCellPasswordRepeat = (SimpleTextInputCellFragment)getFragmentManager().findFragmentById(R.id.input_password_repeat);
		
		findViewById(R.id.btn_submit).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				submit();
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//设置项目名
		fragInputCellAccount.setLabelText("用户名");
		fragInputCellAccount.setHintText("请输入用户名");
		fragInputCellPassword.setLabelText("密码");
		fragInputCellPassword.setHintText("请输入密码");
		fragInputCellPassword.setIsPassword(true);
		fragInputCellPasswordRepeat.setLabelText("重复密码");
		fragInputCellPasswordRepeat.setHintText("请重复密码");
		fragInputCellPasswordRepeat.setIsPassword(true);
		fragInputEmailAddress.setLabelText("电子邮箱");
		fragInputEmailAddress.setHintText("请输入电子邮箱");
	}
	
	void submit()
	{
		//String password = fragInputCellPassword.edit.getText(); 
	}
}
