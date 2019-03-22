package com.smart.plugindemo;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Project name:  SimplePluginApplication
 * Package name:  com.smart.plugindemo
 * Description:   todo
 * All rights Reserved, Designed By gaoxiaohui
 * Company        ${COMPANY_NAME}.
 *
 * @author Administrator
 * @version V1.0
 * CreateDate:    2019/3/22 0022 上午 11:13
 * <p>
 * Modification  History:
 * Date          Author        Version        Description
 * -----------------------------------------------------------------------------------
 * 2019/3/22 0022       Administrator          1.0             1.0
 * Why & What is modified: <修改原因描述>
 */
public class Utils {
    public static String copyAssetsAndWrite(Context context,String fileName){

        try{
            File cacheDir = context.getCacheDir();
            if (!cacheDir.exists()){
                cacheDir.mkdirs();
            }
            File outFile = new File(cacheDir,fileName);
            if (!outFile.exists()){
                boolean res = outFile.createNewFile();
                if (res){
                    InputStream in = context.getAssets().open(fileName);
                    FileOutputStream outputStream = new FileOutputStream(outFile);

                    byte [] buffer = new byte[in.available()];
                    int byteCount;
                    while ((byteCount = in.read(buffer))!= -1){
                        outputStream.write(buffer,0,byteCount);
                    }
                    outputStream.flush();
                    in.close();
                    outputStream.close();

                    Toast.makeText(context,"加载成功",Toast.LENGTH_SHORT).show();
                    return outFile.getAbsolutePath();

                }
            }else {
                Toast.makeText(context,"文件已存在",Toast.LENGTH_SHORT).show();
                return outFile.getAbsolutePath();
            }

        } catch (Exception e){

        }

        return "";
    }


}
