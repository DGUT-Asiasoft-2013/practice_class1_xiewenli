package com.example.helloworld;

import com.example.helloworld.fragments.inputcells.SimpleTextInputCellFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends Activity {
	SimpleTextInputCellFragment fragAccount,fragPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
			//点击注册按钮进入RegisterActivity
			@Override
			public void onClick(View v) {
				goRegister();
			}
		});
		
		findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
			//点击登录按钮进入HelloWorldActivity
			@Override
			public void onClick(View v) {
				goLogin();
			}
		});
		
		findViewById(R.id.btn_forgot_password).setOnClickListener(new View.OnClickListener() {
			//点击忘记密码文本进入密码重置
			@Override
			public void onClick(View v) {
				goRecoverPassword();
			}
		});
		
		fragAccount = (SimpleTextInputCellFragment) getFragmentManager().findFragmentById(R.id.input_account);
		fragPassword = (SimpleTextInputCellFragment) getFragmentManager().findFragmentById(R.id.input_password);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//设置项目名
		fragAccount.setLabelText("账户名");
		fragAccount.setHintText("请输入账户名");
		fragPassword.setLabelText("密码");
		fragPassword.setHintText("请输入密码");
		fragPassword.setIsPassword(true);
	}
	
	void goRegister(){  //进入注册界面
		Intent itnt = new Intent(this,RegisterActivity.class);
		startActivity(itnt);
	}
	
	void goLogin(){  //进入登录界面
		Intent itnt = new Intent(this, HelloWorldActivity.class);
		startActivity(itnt);
	}
	
	void goRecoverPassword(){  //进入密码找回界面
		Intent itnt = new Intent(this, PasswordRecoverActivity.class);
		startActivity(itnt);
	}
}