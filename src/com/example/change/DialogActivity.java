package com.example.change;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class DialogActivity extends Activity {
	private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	/**
	 * AlertDialog，并用Builder方法形成了一个对象链，通过一系列的设置方法，构造出我们需要的对话框，
	 * 然 后调用show方法显示出来，注意到Builder方法的参数 self,这个其实是Activity对象的引用，
	 * 根据你所处的上下文来传入相应的引用就可以了。例如在onCreate方法中调用，只需传入this即 可。
	 */
	private Builder builder;
	private EditText et;		//可编辑的对象
	private ImageView img ;		//图片对象
	
  	@Override
    public void onCreate(Bundle savedInstanceState) {
	  	super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogtest);
        b1 = (Button)findViewById(R.id.button1);	//普通消息框
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);	//普通消息框
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        b9 = (Button)findViewById(R.id.button9);
        b10 = (Button)findViewById(R.id.button10);
        
        builder= new AlertDialog.Builder(this);     
        et = new EditText(this);
        img = new ImageView(this);
        
        b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.setTitle("标题").setMessage("简单消息框").setPositiveButton("确定", null).show();
			}
		});
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.setTitle("确认")
			 	.setMessage("确定吗？")
			 	.setPositiveButton("是", null)
			 	.setNegativeButton("否", null)
			 	.show();
			}
		});
        
        b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.setTitle("请输入")
			 	.setIcon(android.R.drawable.ic_dialog_info)
			 	.setView(et)
			 	.setPositiveButton("确定", null)
			 	.setNegativeButton("取消", null)
			 	.show();
			}
		});
        
        b4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder
		 	 	.setTitle("请选择")
		 	 	.setIcon(android.R.drawable.ic_dialog_info)                
		 	 	.setSingleChoiceItems(new String[] {"选项1","选项2","选项3","选项4"}, 0, 
			 	new DialogInterface.OnClickListener() {                 
			 	     public void onClick(DialogInterface dialog, int which) {
			 	        dialog.dismiss();
			 	     }
		 	 	});
			}
        });
        
        
        b5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.
				setTitle("多选框")
				.setMultiChoiceItems(new String[] {"选项1","选项2","选项3","选项4"}, null, null)
				.setPositiveButton("确定", null)                
				.setNegativeButton("取消", null)
				.show();
			}
        });
        
        b6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img.setImageResource(R.drawable.ic_launcher);
				builder
				.setTitle("图片框")
				.setView(img)
				.setPositiveButton("确定", null)
				.show();
				    
				             
			}
        });
        
        b7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				builder.
				setTitle("列表框").
				setItems(new String[] {"列表项1","列表项2","列表项3"}, null).
				setNegativeButton("确定", null).
				show();   
			                  
				             
			}
        });
        
        
        b9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				LayoutInflater inflater = getLayoutInflater();
				View layout = inflater.inflate(R.layout.user_defined_dialog,
				     (ViewGroup) findViewById(R.id.dialog));

				builder.setTitle("自定义布局").setView(layout)
			     .setPositiveButton("确定", null)
			     .setNegativeButton("取消", null).show();
			                  
				             
			}
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
  	}
	  	


  
	  
}
