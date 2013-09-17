package com.example.change;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class progressActivity extends Activity{
	
	
	private ProgressDialog progressDialog;  
	private Button button;
	
	
 	 @Override
     public void onCreate(Bundle savedInstanceState) {
 	       super.onCreate(savedInstanceState);
 	       setContentView(R.layout.progress); 
 	       button = (Button)findViewById(R.id.loginBtn);  
 	       button.setOnClickListener(new loginBtnListener());  
 	       
	 }
 	 
 	/* 
      * 使用Handler更新UI 
      */  
     Handler handler = new Handler(){  
   
         @Override  
         public void handleMessage(Message msg) {  
             //设置进度条当前值，并将线程对象放入线程队列   
             progressDialog.setProgress(msg.arg1);  
             handler.post(updateThread);  
         }  
           
     };
     
 	class loginBtnListener implements OnClickListener{  
 		  
        @Override  
        public void onClick(View v) {  
            handler.post(updateThread);
            
            progressDialog = new ProgressDialog(progressActivity.this);  
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);  
            progressDialog.setMessage("正在登陆，请稍后...");  
            progressDialog.setTitle("登陆系统");  
            progressDialog.setIcon(R.drawable.ic_launcher);  
            progressDialog.setMax(100);  
            progressDialog.setProgress(0);  
            progressDialog.setCancelable(true);
            progressDialog.setButton("取消", new DialogInterface.OnClickListener() {  
                  
                @Override  
                public void onClick(DialogInterface dialog, int which) {  
                    // TODO Auto-generated method stub   
                    dialog.dismiss();  
                }  
            });  
            progressDialog.show();  
        }  
          
    }  
    Runnable updateThread = new Runnable() {  
        int i = 0;  
        @Override  
        public void run() {  
            i += 5;  
            Message msg = handler.obtainMessage();    //得到一个消息对象   
            //将msg对象的参数设置为i,Message类共有两个参数arg1和arg2，用这两个成员变量传递消息的优点是系统性能消耗最少   
            msg.arg1 = i;                 
            try {  
                Thread.sleep(100);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            //将msg压入消息队列,sendMessage方法是异步的，不等消息被处理，该方法就返回，继续往下执行   
            handler.sendMessage(msg);  
            if(i == progressDialog.getMax()){  
                //当i达到最大值时，从消息队列中删除msg   
                handler.removeCallbacks(updateThread, msg);  
                progressDialog.dismiss();  
            }  
        }  
          
    };  
 	 
 	 
}
