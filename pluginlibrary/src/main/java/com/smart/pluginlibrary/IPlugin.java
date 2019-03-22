package com.smart.pluginlibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

/**
 * Project name:  SimplePluginApplication
 * Package name:  com.smart.pluginlibrary
 * Description:   todo
 * All rights Reserved, Designed By gaoxiaohui
 * Company        ${COMPANY_NAME}.
 *
 * @author Administrator
 * @version V1.0
 * CreateDate:    2019/3/20 0020 下午 5:33
 * <p>
 * Modification  History:
 * Date          Author        Version        Description
 * -----------------------------------------------------------------------------------
 * 2019/3/20 0020       Administrator          1.0             1.0
 * Why & What is modified: <修改原因描述>
 */
public interface IPlugin {

    public int FROM_INTERNAL = 0;
    public int FROM_EXTERNAL = 1;

    public void attach(Activity proxyActivity);
    public void onCreate(Bundle savedInstanceState);
    public void onStart();
    public void onRestart();
    public void onActivityResult(int requestCode, int resultCode, Intent data);
    public void onResume();
    public void onPause();
    public void onStop();
    public void onDestroy();
    public void onSaveInstanceState(Bundle outState);
    public void onNewIntent(Intent intent);
}
