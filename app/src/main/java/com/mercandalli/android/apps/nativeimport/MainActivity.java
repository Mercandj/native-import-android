package com.mercandalli.android.apps.nativeimport;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mercandalli.android.sdk.library.Library;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activity_main_copy_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                boolean succeeded = extractAsset(getFilesDir().getAbsolutePath());
                log("Copy succeeded == " + succeeded);
            }
        });

        findViewById(R.id.activity_main_load_module_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Library.loadFromModule();
                log("Load lib from module");
            }
        });

        findViewById(R.id.activity_main_load_so_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                boolean succeeded = Library.loadFromSo();
                log("Load lib from so. succeeded == " + succeeded);
            }
        });

        findViewById(R.id.activity_main_static_log_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String log = Library.staticLog();
                log(log);
            }
        });

        findViewById(R.id.activity_main_log_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String log = new Library().log();
                log(log);
            }
        });
    }

    private void log(String log) {
        TextView logTextView = findViewById(R.id.activity_main_log);
        logTextView.setText(log + "\n" + logTextView.getText().toString());
    }

    private boolean extractAsset(String outDir) {
        InputStream in;
        OutputStream out;
        File file;
        try {
            in = getAssets().open("lib1/armeabi-v7a/liblog1.so");
            file = new File(outDir, "liblog1.so");
            if (file.exists()) {
                return true;
            }
            out = new FileOutputStream(file);
            copyFile(in, out);
            in.close();
            out.flush();
            out.close();
            return true;
        } catch (IOException ignored) {
        }
        return false;
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }
}
