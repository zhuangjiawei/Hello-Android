package com.example.change;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class TestMenu extends Activity{

	private Button mbutton;
	public static final int RED_MENU_ID   = Menu.FIRST; 
    public static final int GREEN_MENU_ID = Menu.FIRST + 1;     
    public static final int BLUE_MENU_ID  = Menu.FIRST + 2; 
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testmenu);

		mbutton = (Button) findViewById(R.id.button1);
		
	}

	/**
	 * ʹ�ô˷�������OptionsMenu   �����Ļ�ϵ�Menu��ť�ͻ���ʾ
         * 
         * add()�������ĸ������������ǣ�
         * 
         * 1��������������Ļ���дMenu.NONE,
         * 
         * 2��Id���������Ҫ��Android�������Id��ȷ����ͬ�Ĳ˵�
         * 
         * 3��˳���Ǹ��˵�������ǰ������������Ĵ�С����
         * 
         * 4���ı����˵�����ʾ�ı�
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) { 
		super.onCreateOptionsMenu(menu);
        menu.add(0, RED_MENU_ID, 0, R.string.red); 
        menu.add(0, GREEN_MENU_ID, 0, R.string.green); 
        menu.add(0, BLUE_MENU_ID, 0, R.string.blue);		

      /*  menu.add(Menu.NONE, Menu.FIRST + 1, 5, "ɾ��").setIcon(

        android.R.drawable.ic_menu_delete);

        // setIcon()����Ϊ�˵�����ͼ�꣬����ʹ�õ���ϵͳ�Դ���ͼ�꣬ͬѧ������һ��,��

        // android.R��ͷ����Դ��ϵͳ�ṩ�ģ������Լ��ṩ����Դ����R��ͷ��

        menu.add(Menu.NONE, Menu.FIRST + 2, 2, "����").setIcon(

        android.R.drawable.ic_menu_edit);

        menu.add(Menu.NONE, Menu.FIRST + 3, 6, "����").setIcon(

        android.R.drawable.ic_menu_help);

        menu.add(Menu.NONE, Menu.FIRST + 4, 1, "���").setIcon(

        android.R.drawable.ic_menu_add);

        menu.add(Menu.NONE, Menu.FIRST + 5, 4, "��ϸ").setIcon(

        android.R.drawable.ic_menu_info_details);

        menu.add(Menu.NONE, Menu.FIRST + 6, 3, "����").setIcon(

        android.R.drawable.ic_menu_send);*/
		
        return true;
	}
	/**
	 * ѡ�в˵�������Ķ�����
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		 	case RED_MENU_ID: 
		 		mbutton.setBackgroundColor(Color.RED); 
		 		mbutton.setText(R.string.red);             
	            return true; 
	        case GREEN_MENU_ID: 
	        	mbutton.setBackgroundColor(Color.GREEN); 
	        	mbutton.setText(R.string.green);   
	            return true; 
	        case BLUE_MENU_ID: 
	        	mbutton.setBackgroundColor(Color.BLUE); 
	        	mbutton.setText(R.string.blue);             
	            return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
