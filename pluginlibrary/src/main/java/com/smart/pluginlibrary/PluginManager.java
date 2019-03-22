package com.smart.pluginlibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
 * CreateDate:    2019/3/20 0020 下午 5:34
 * <p>
 * Modification  History:
 * Date          Author        Version        Description
 * -----------------------------------------------------------------------------------
 * 2019/3/20 0020       Administrator          1.0             1.0
 * Why & What is modified: <修改原因描述>
 */
public class PluginManager {

    private static PluginManager instance;

    public static PluginManager getInstance() {
        if (null == instance) {
            synchronized (PluginManager.class) {
                instance = new PluginManager();
            }
        }

        return instance;
    }

    private Context mContext;
    private PluginApk mPluginApk;

    public PluginApk getPluginApk(){
        return mPluginApk;
    }

    public void init(Context context) {
        mContext = context.getApplicationContext();
    }

    public void loadApk(String apkPath){
        PackageInfo packageInfo = mContext.getPackageManager().getPackageArchiveInfo(apkPath,
                PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);
        if (null == packageInfo){
            return;
        }

        DexClassLoader dexClassLoader=createDexClassLoader(apkPath);
        AssetManager assetManager = createAssetManager(apkPath);
        Resources resources = createResources(assetManager);

        mPluginApk = new PluginApk(packageInfo,resources,assetManager,dexClassLoader);
    }

    private Resources createResources(AssetManager assetManager) {
        Resources resources = mContext.getResources();
        return new Resources(assetManager,resources.getDisplayMetrics(),resources.getConfiguration());
    }

    private AssetManager createAssetManager(String apkPath) {
        try{
            AssetManager assetManager = AssetManager.class.newInstance();
            @SuppressLint("PrivateApi")
            Method method = AssetManager.class.getDeclaredMethod("addAssetPath",String.class);
            method.invoke(assetManager,apkPath);

            return assetManager;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private DexClassLoader createDexClassLoader(String apkPath) {
        File file = mContext.getDir("dex",Context.MODE_PRIVATE);
        return new DexClassLoader(apkPath,file.getAbsolutePath(),null,mContext.getClassLoader());
    }

}
