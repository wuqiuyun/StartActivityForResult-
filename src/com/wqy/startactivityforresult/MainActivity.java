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
				// �������ֵ������ã�������>=0
				startActivityForResult(intent, 100);
			}
		});
	}

	/**
	 * �ص��������ӵڶ���ҳ�������ʱ���ִ���������
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		/*
		 * requestCode �����룬������startActivityForResult()���ݹ�ȥ��ֵ
         * resultCode ����룬��������ڱ�ʶ�������������ĸ���Activity
		 */
		if(requestCode == 100 & resultCode == RESULT_OK){
			String username = data.getStringExtra("username");
			CharSequence password = data.getStringExtra("password");
			tvName.setText(username);
			tvPassword.setText(password);
		}
	}
}
