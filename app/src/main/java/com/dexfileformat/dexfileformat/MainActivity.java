package com.dexfileformat.dexfileformat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.euler.andfix.AndFixManager;

import java.io.File;

public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";
    private TextView mTextView;
    private String dexFileName = "refile.dex";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.copy_file).setOnClickListener(clickListener);
        findViewById(R.id.fix_bug).setOnClickListener(clickListener);
        mTextView = (TextView) findViewById(R.id.show_content);
        mTextView.setText(new DexFileFormat().getVersion("for text"));
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.copy_file) {
                onClickCopyFile();
            } else if (v.getId() == R.id.fix_bug) {
                onClickFixBug();
            }
        }
    };

    private void onClickCopyFile() {
        File file = new File(getApplicationContext().getDir(AssetFileManager.BINARY_DEST_DIR_NAME, Context.MODE_PRIVATE), dexFileName);
        if (file.exists()) {
            Toast.makeText(getApplicationContext(), "file exist", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean result = new AssetFileManager().copyAssetFile(getApplicationContext(), dexFileName);
        Toast.makeText(getApplicationContext(), "copy dex finish result = " + result, Toast.LENGTH_SHORT).show();
    }

    private void onClickFixBug() {
        File file = new File(getApplicationContext().getDir(AssetFileManager.BINARY_DEST_DIR_NAME, Context.MODE_PRIVATE), dexFileName);
        if (!file.exists()) {
            Log.d(TAG, "onClickFixBug: file isn't exist");
        }
        new AndFixManager(getApplicationContext()).customFix(file, this.getClassLoader(), null);
        String text = new DexFileFormat().getVersion("for text");
        Log.d(TAG, "onClickFixBug: text = " + text);
        mTextView.setText(text);
    }
}
