package com.smart.pluginlibrary;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

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
public class PluginApk {
    public PackageInfo mPackageInfo;
    public Resources mResources;
    public AssetManager mAssetManager;
    public DexClassLoader mClassLoader;

    public PluginApk(PackageInfo packageInfo, Resources resources, AssetManager assetManager, DexClassLoader dexClassLoader) {
        mPackageInfo = packageInfo;
        mResources = resources;
        mAssetManager = resources.getAssets();
        mClassLoader = dexClassLoader;
    }

}
