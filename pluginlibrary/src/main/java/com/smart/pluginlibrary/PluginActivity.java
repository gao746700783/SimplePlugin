package com.smart.pluginlibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Project name:  SimplePluginApplication
 * Package name:  com.smart.pluginlibrary
 * Description:   todo
 * All rights Reserved, Designed By gaoxiaohui
 * Company        ${COMPANY_NAME}.
 *
 * @author Administrator
 * @version V1.0
 * CreateDate:    2019/3/22 0022 上午 10:29
 * <p>
 * Modification  History:
 * Date          Author        Version        Description
 * -----------------------------------------------------------------------------------
 * 2019/3/22 0022       Administrator          1.0             1.0
 * Why & What is modified: <修改原因描述>
 */
public class PluginActivity extends Activity implements IPlugin {

    private int mFrom = FROM_INTERNAL;
    private Activity mProxyActivity;

    @Override
    public void attach(Activity proxyActivity) {
        mProxyActivity = proxyActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (null != savedInstanceState) {
            mFrom = savedInstanceState.getInt("FROM");
        }
        if (mFrom == FROM_INTERNAL) {
            super.onCreate(savedInstanceState);
            mProxyActivity = this;
        }
    }

    @Override
    public void setContentView(int layoutId) {
        if (mFrom == FROM_INTERNAL){
        super.setContentView(layoutId);
        } else {
            mProxyActivity.setContentView(layoutId);
        }
    }

    @Override
    public void onStart() {
        if (mFrom == FROM_INTERNAL){
            super.onStart();
        }
    }

    @Override
    public void onRestart() {
        if (mFrom == FROM_INTERNAL){
            super.onRestart();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mFrom == FROM_INTERNAL){
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onResume() {
        if (mFrom == FROM_INTERNAL){
            super.onResume();
        }
    }

    @Override
    public void onPause() {
        if (mFrom == FROM_INTERNAL){
            super.onPause();
        }
    }

    @Override
    public void onStop() {
        if (mFrom == FROM_INTERNAL){
            super.onStop();
        }
    }

    @Override
    public void onDestroy() {
        if (mFrom == FROM_INTERNAL){
            super.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mFrom == FROM_INTERNAL){
            super.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (mFrom == FROM_INTERNAL){
            super.onNewIntent(intent);
        }
    }
}
