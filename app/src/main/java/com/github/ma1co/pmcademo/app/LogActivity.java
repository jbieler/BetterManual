package com.github.ma1co.pmcademo.app;

import android.os.Bundle;
import android.widget.TextView;

import com.github.jbieler.holygrail.app.R;
import com.github.ma1co.openmemories.framework.logging.Log4jHelper;

public class LogActivity extends BaseActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        textView = (TextView) findViewById(R.id.logView);

        Log4jHelper.configureTextViewAppender(textView);
        Log4jHelper.configureSocketAppender("192.168.2.101", 5678);
    }
}
