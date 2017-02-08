package com.wqy.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button btnGotoRegist;
	private TextView tvName;
	private TextView tvPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		btnGotoRegist = (Button) findViewById(R.id.btn_goto_regist);
		tvName = (TextView) findViewById(R.id.tv_name);
		tvPassword = (TextView) findViewById(R.id.tv_password);

		btnGotoRegist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						SecondActivity.class);
				// 请求码的值随便设置，但必须>=0
				startActivityForResult(intent, 100);
			}
		});
	}

	/**
	 * 回调方法，从第二个页面回来的时候会执行这个方法
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		/*
		 * requestCode 请求码，即调用startActivityForResult()传递过去的值
         * resultCode 结果码，结果码用于标识返回数据来自哪个新Activity
		 */
		if(requestCode == 100 & resultCode == RESULT_OK){
			String username = data.getStringExtra("username");
			CharSequence password = data.getStringExtra("password");
			tvName.setText(username);
			tvPassword.setText(password);
		}
	}
}
