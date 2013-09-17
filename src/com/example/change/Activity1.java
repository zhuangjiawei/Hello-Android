package com.example.change;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity1 extends Activity{
	private Button bt3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity1);
		bt3=(Button)findViewById(R.id.a1bt1);
		bt3.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(Activity1.this, MainActivity.class);
				startActivity(intent);
			}
		});
	
	}
	
	
	
}
