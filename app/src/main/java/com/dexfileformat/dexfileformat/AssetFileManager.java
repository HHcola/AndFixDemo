package com.dexfileformat.dexfileformat;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hewei05 on 2017/3/23.
 */

public class AssetFileManager {

    public static final String BINARY_DEST_DIR_NAME 	= "bin";

    public boolean copyAssetFile(Context context, String fileName) {
        AssetManager assetManager = context.getAssets();
        try {
            InputStream inputStream = assetManager.open(fileName);
            File file = new File(context.getDir(BINARY_DEST_DIR_NAME, Context.MODE_PRIVATE), fileName);
            copyFile(file, inputStream);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    private void copyFile(File file, InputStream is) throws IOException, InterruptedException {
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        final String abspath = file.getAbsolutePath();
        final FileOutputStream out = new FileOutputStream(file);
        byte buf[] = new byte[1024];
        int len;
        while ((len = is.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        out.close();
        is.close();
    }
}
