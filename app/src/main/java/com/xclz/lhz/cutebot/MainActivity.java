package com.xclz.lhz.cutebot;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;
import com.xclz.lhz.cutebot.MainActivity;

public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
		
		if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(MainActivity.this)) {
                Intent intent = new Intent(MainActivity.this, MainService.class);
                Toast.makeText(MainActivity.this,"已开启Toucher",Toast.LENGTH_SHORT).show();
                startService(intent);
                finish();
            } else {
                //若没有权限，提示获取.
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                Toast.makeText(MainActivity.this,"需要取得权限以使用悬浮窗", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        } else {
            //SDK在23以下，不用管.
            Intent intent = new Intent(MainActivity.this, MainService.class);
            startService(intent);
            finish();
        }
    }
}
