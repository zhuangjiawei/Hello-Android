package com.example.change;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        bt3=(Button)findViewById(R.id.bt3);
        bt4=(Button)findViewById(R.id.bt4);
        bt5=(Button)findViewById(R.id.bt5);
        bt6=(Button)findViewById(R.id.bt6);
        bt7=(Button)findViewById(R.id.button1);
        
        bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();		//建立Intent	
				intent.setClass(MainActivity.this, Activity1.class);	//设置活动
				startActivity(intent);		//开启活动
			}
        });

        bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Activity2.class);
				intent.putExtra("wh", "wanghui");
				startActivityForResult(intent, 0);
			}
		});
        
        bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, TestMenu.class);
				startActivity(intent);		//开启活动
			}
		});
        
        bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, DialogActivity.class);
				startActivity(intent);		//开启活动
			}
		});
        
        
        bt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, progressActivity.class);
				startActivity(intent);		//开启活动
			}
		});
        
        bt6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, imageChangeActivity.class);
				startActivity(intent);		//开启活动
			}
		});
        
        bt7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, AudioActivity.class);
				startActivity(intent);		//开启活动
			}
		});
    }
    
    
    /**
     * 获得返回值
     */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
//		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==0){
			if(resultCode==RESULT_OK){
				String title="没有返回值";
				Bundle bundle=data.getExtras();
				if(bundle!=null){
					title=bundle.getString("fh");
				}
				setTitle(title);
			}else{
				setTitle("程序执行失败");
			}
		}
		
	}

        

}
