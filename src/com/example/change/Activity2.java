package com.example.change;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity2  extends Activity{
	private Button bt4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity2);
		bt4=(Button)findViewById(R.id.a2bt2);
		bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				Bundle bunle=new Bundle();	//使用Bundle在Activity之间传递数据
				bunle.putString("fh", "峰华公司");
				intent.putExtras(bunle);
				setResult(RESULT_OK, intent);
				finish();
			}
		});
		
		Bundle bun=getIntent().getExtras();
		if(bun!=null){
			setTitle(bun.getString("wh"));
		}else{
			setTitle("没有值");
		}
	}

}
