package com.doubisanyou.appcenter.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.doubisanyou.appcenter.R;
import com.doubisanyou.appcenter.date.Config;

public class LoginActivity extends Activity implements OnClickListener {
	
	EditText loginUserName;
	EditText loginPassWord;
	Button loginBtn;
	Button rigisterBtn;
	TextView title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		iniView();
	}
	
	void iniView(){
		loginUserName = (EditText) findViewById(R.id.login_user_name);
		loginPassWord = (EditText) findViewById(R.id.login_pass_word);
		loginBtn = (Button) findViewById(R.id.btn_signin);
		loginBtn.setOnClickListener(this);
		rigisterBtn = (Button) findViewById(R.id.btn_register);
		rigisterBtn.setOnClickListener(this);
		title = (TextView) findViewById(R.id.default_title);
		title.setText("登录");
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_signin:
			 //进行网络通讯返回一个token
			 Config.setToken(this, "111");	
			 finish();
			break;
		case R.id.btn_register:
			 Intent i = new Intent(this,RegisterActivity.class);
			 startActivity(i);
			break;
			
		default:
			break;
		}
		
	} 
}