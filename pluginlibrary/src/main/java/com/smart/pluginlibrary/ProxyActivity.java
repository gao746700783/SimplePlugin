package com.smart.pluginlibrary;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

/**
 * Project name:  SimplePluginApplication
 * Package name:  com.smart.pluginlibrary
 * Description:   todo
 * All rights Reserved, Designed By gaoxiaohui
 * Company        ${COMPANY_NAME}.
 *
 * @author Administrator
 * @version V1.0
 * CreateDate:    2019/3/22 0022 上午 10:44
 * <p>
 * Modification  History:
 * Date          Author        Version        Description
 * -----------------------------------------------------------------------------------
 * 2019/3/22 0022       Administrator          1.0             1.0
 * Why & What is modified: <修改原因描述>
 */
public class ProxyActivity extends Activity {

    private String className;
    private PluginApk mPluginApk;
    private IPlugin mIPlugin;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        className = getIntent().getStringExtra("class_name");
        mPluginApk = PluginManager.getInstance().getPluginApk();

        launchPluginActivity();

    }

    private void launchPluginActivity() {
        if (null == mPluginApk){
            throw new RuntimeException("请先加载插件apk");
        }

        try {
            Class<?> clazz = mPluginApk.mClassLoader.loadClass(className);
            Object o = clazz.newInstance();
            if (o instanceof IPlugin){
                mIPlugin = (IPlugin) o;
                mIPlugin.attach(this);

                Bundle bundle = new Bundle();
                bundle.putInt("FROM",IPlugin.FROM_EXTERNAL);

                mIPlugin.onCreate(bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Resources getResources() {
        return mPluginApk != null ? mPluginApk.mResources : super.getResources();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mPluginApk != null ? mPluginApk.mClassLoader:super.getClassLoader();
    }

    @Override
    public AssetManager getAssets() {
        return mPluginApk != null ? mPluginApk.mAssetManager: super.getAssets();
    }
}
