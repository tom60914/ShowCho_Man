package com.example.showcho_man;


import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;


public class MainActivity extends Activity {
	
	ImageView iconbutton;
	ImageView image_marquee;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm); //先取得螢幕解析度  
        int width = (dm.widthPixels);
        int height = (dm.heightPixels);
        
        // All object declared
        iconbutton = (ImageView)findViewById(R.id.icon);
        image_marquee = (ImageView)findViewById(R.id.marquee);
        final Animation animRotateIn_icon = AnimationUtils.loadAnimation(this, R.anim.rotate);
        
        iconbutton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
					iconbutton.startAnimation(animRotateIn_icon);
			}			
        });
        
        TranslateAnimation am = new TranslateAnimation(-width,width, 0, 0);
        //設定移動路徑(x1,x2,y1,y2);
        am.setDuration(7000);
        // 動畫開始到結束的時間(毫秒)
        am.setRepeatCount(-1);
        //0代表只跑一次,-1代表一直重複
        am.startNow();
        //動畫開始
        image_marquee.setAnimation(am);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
