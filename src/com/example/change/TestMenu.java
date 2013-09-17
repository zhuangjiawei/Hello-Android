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
	 * 使用此方法调用OptionsMenu   点击屏幕上的Menu按钮就会显示
         * 
         * add()方法的四个参数，依次是：
         * 
         * 1、组别，如果不分组的话就写Menu.NONE,
         * 
         * 2、Id，这个很重要，Android根据这个Id来确定不同的菜单
         * 
         * 3、顺序，那个菜单现在在前面由这个参数的大小决定
         * 
         * 4、文本，菜单的显示文本
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) { 
		super.onCreateOptionsMenu(menu);
        menu.add(0, RED_MENU_ID, 0, R.string.red); 
        menu.add(0, GREEN_MENU_ID, 0, R.string.green); 
        menu.add(0, BLUE_MENU_ID, 0, R.string.blue);		

      /*  menu.add(Menu.NONE, Menu.FIRST + 1, 5, "删除").setIcon(

        android.R.drawable.ic_menu_delete);

        // setIcon()方法为菜单设置图标，这里使用的是系统自带的图标，同学们留意一下,以

        // android.R开头的资源是系统提供的，我们自己提供的资源是以R开头的

        menu.add(Menu.NONE, Menu.FIRST + 2, 2, "保存").setIcon(

        android.R.drawable.ic_menu_edit);

        menu.add(Menu.NONE, Menu.FIRST + 3, 6, "帮助").setIcon(

        android.R.drawable.ic_menu_help);

        menu.add(Menu.NONE, Menu.FIRST + 4, 1, "添加").setIcon(

        android.R.drawable.ic_menu_add);

        menu.add(Menu.NONE, Menu.FIRST + 5, 4, "详细").setIcon(

        android.R.drawable.ic_menu_info_details);

        menu.add(Menu.NONE, Menu.FIRST + 6, 3, "发送").setIcon(

        android.R.drawable.ic_menu_send);*/
		
        return true;
	}
	/**
	 * 选中菜单项后发生的动作。
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
