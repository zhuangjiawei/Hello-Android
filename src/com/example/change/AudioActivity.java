package com.example.change;
 
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
/**
 * 音乐播放器
 * MediaPlayer
 * @author zhuangjiawei
 *
 */
public class AudioActivity extends Activity {
    /** Called when the activity is first created. */
    private MediaPlayer mediaPlayer = null;
    private Button startButton = null;
    private Button pauseButton = null;
    private Button stopButton = null;
    private EditText editText = null;
 
    private boolean isPause = false;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediaplayer);
 
        editText = (EditText) findViewById(R.id.filename);	//文件名称
        startButton = (Button) findViewById(R.id.startButton);
        pauseButton = (Button) findViewById(R.id.pauseButton);
        stopButton = (Button) findViewById(R.id.stopButton);
 
        startButton.setOnClickListener(listener);
        pauseButton.setOnClickListener(listener);
        stopButton.setOnClickListener(listener);
 
        mediaPlayer = new MediaPlayer();
        
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
 
            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                Toast.makeText(AudioActivity.this, "播放完成",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
 
    /**
     * 
     */
    private OnClickListener listener = new OnClickListener() {
 
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Button button = (Button) v;
            switch (button.getId()) {
            case R.id.startButton:
                try {
                    String fileName = editText.getText().toString();
                    Log.i("输出",fileName);
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource("/sdcard/Music/" + fileName);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                	Log.i("错误","名称不正确");
                    e.printStackTrace();
                }
                break;
            case R.id.pauseButton:
                try {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                    } else {
                        mediaPlayer.start();
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
                break;
            case R.id.stopButton:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                break;
 
            default:
                break;
            }
        }
    };
 
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPause = true;
        }
        super.onPause();
    }
 
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        if (isPause) {
            mediaPlayer.start();
            isPause = false;
        }
        super.onResume();
    }
 
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        mediaPlayer.release();
        mediaPlayer = null;
        super.onDestroy();
    }
 
}