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
      * ʹ��Handler����UI 
      */  
     Handler handler = new Handler(){  
   
         @Override  
         public void handleMessage(Message msg) {  
             //���ý�������ǰֵ�������̶߳�������̶߳���   
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
            progressDialog.setMessage("���ڵ�½�����Ժ�...");  
            progressDialog.setTitle("��½ϵͳ");  
            progressDialog.setIcon(R.drawable.ic_launcher);  
            progressDialog.setMax(100);  
            progressDialog.setProgress(0);  
            progressDialog.setCancelable(true);
            progressDialog.setButton("ȡ��", new DialogInterface.OnClickListener() {  
                  
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
            Message msg = handler.obtainMessage();    //�õ�һ����Ϣ����   
            //��msg����Ĳ�������Ϊi,Message�๲����������arg1��arg2������������Ա����������Ϣ���ŵ���ϵͳ������������   
            msg.arg1 = i;                 
            try {  
                Thread.sleep(100);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            //��msgѹ����Ϣ����,sendMessage�������첽�ģ�������Ϣ�������÷����ͷ��أ���������ִ��   
            handler.sendMessage(msg);  
            if(i == progressDialog.getMax()){  
                //��i�ﵽ���ֵʱ������Ϣ������ɾ��msg   
                handler.removeCallbacks(updateThread, msg);  
                progressDialog.dismiss();  
            }  
        }  
          
    };  
 	 
 	 
}
