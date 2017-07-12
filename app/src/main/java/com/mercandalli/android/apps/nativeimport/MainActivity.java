package com.mercandalli.android.apps.nativeimport;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mercandalli.android.sdk.library.Library;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activity_main_log_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Log.d("jm/debug", "[Java] log clicked");
                String log = new Library().log();
                log(log);
            }
        });
    }

    private void log(String log) {
        TextView logTextView = findViewById(R.id.activity_main_log);
        logTextView.setText(log + "\n" + logTextView.getText().toString());
    }
}
