package com.wqy.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {
	private EditText etName;
	private EditText etPassword;
	private Button btnRegist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		initView();
	}

	private void initView() {
		etName = (EditText) findViewById(R.id.et_name);
		etPassword = (EditText) findViewById(R.id.et_password);
		btnRegist = (Button) findViewById(R.id.btn_regist);

		btnRegist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String username = etName.getText().toString();
				String password = etName.getText().toString();
				
				if (!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(password)) {
					Intent intent = new Intent();
					intent.putExtra("username", username);
					intent.putExtra("password", password);
					//设置返回结果并回传
					setResult(RESULT_OK, intent);
					finish();

				} else {
					Toast.makeText(SecondActivity.this, "请输入完整信息",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
}
