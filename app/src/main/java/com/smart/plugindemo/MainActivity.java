package com.smart.plugindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.smart.pluginlibrary.PluginActivity;
import com.smart.pluginlibrary.PluginManager;
import com.smart.pluginlibrary.ProxyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PluginManager.getInstance().init(this);

        findViewById(R.id.button1).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 加载apk
                        String apkPath = Utils.copyAssetsAndWrite(MainActivity.this,"hotfix.apk");
                        PluginManager.getInstance().loadApk(apkPath);
                    }
                }
        );

        findViewById(R.id.button2).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 正常跳转
                        Intent intent = new Intent(MainActivity.this, ProxyActivity.class);
                        intent.putExtra("class_name","com.smart.hotfixlibrary.HotfixActivity");
                        startActivity(intent);
                    }
                }
        );

    }
}
