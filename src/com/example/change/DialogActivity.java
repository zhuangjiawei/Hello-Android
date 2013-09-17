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
	 * AlertDialog������Builder�����γ���һ����������ͨ��һϵ�е����÷����������������Ҫ�ĶԻ���
	 * Ȼ �����show������ʾ������ע�⵽Builder�����Ĳ��� self,�����ʵ��Activity��������ã�
	 * ��������������������������Ӧ�����þͿ����ˡ�������onCreate�����е��ã�ֻ�贫��this�� �ɡ�
	 */
	private Builder builder;
	private EditText et;		//�ɱ༭�Ķ���
	private ImageView img ;		//ͼƬ����
	
  	@Override
    public void onCreate(Bundle savedInstanceState) {
	  	super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogtest);
        b1 = (Button)findViewById(R.id.button1);	//��ͨ��Ϣ��
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);	//��ͨ��Ϣ��
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
				builder.setTitle("����").setMessage("����Ϣ��").setPositiveButton("ȷ��", null).show();
			}
		});
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.setTitle("ȷ��")
			 	.setMessage("ȷ����")
			 	.setPositiveButton("��", null)
			 	.setNegativeButton("��", null)
			 	.show();
			}
		});
        
        b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.setTitle("������")
			 	.setIcon(android.R.drawable.ic_dialog_info)
			 	.setView(et)
			 	.setPositiveButton("ȷ��", null)
			 	.setNegativeButton("ȡ��", null)
			 	.show();
			}
		});
        
        b4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder
		 	 	.setTitle("��ѡ��")
		 	 	.setIcon(android.R.drawable.ic_dialog_info)                
		 	 	.setSingleChoiceItems(new String[] {"ѡ��1","ѡ��2","ѡ��3","ѡ��4"}, 0, 
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
				setTitle("��ѡ��")
				.setMultiChoiceItems(new String[] {"ѡ��1","ѡ��2","ѡ��3","ѡ��4"}, null, null)
				.setPositiveButton("ȷ��", null)                
				.setNegativeButton("ȡ��", null)
				.show();
			}
        });
        
        b6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img.setImageResource(R.drawable.ic_launcher);
				builder
				.setTitle("ͼƬ��")
				.setView(img)
				.setPositiveButton("ȷ��", null)
				.show();
				    
				             
			}
        });
        
        b7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				builder.
				setTitle("�б��").
				setItems(new String[] {"�б���1","�б���2","�б���3"}, null).
				setNegativeButton("ȷ��", null).
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

				builder.setTitle("�Զ��岼��").setView(layout)
			     .setPositiveButton("ȷ��", null)
			     .setNegativeButton("ȡ��", null).show();
			                  
				             
			}
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
  	}
	  	


  
	  
}
