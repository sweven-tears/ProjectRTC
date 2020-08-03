package fr.pchab.androidrtc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        TextView log = (TextView) findViewById(R.id.err_log);
        String extra = getIntent().getStringExtra("throw");
        log.setText(getString(R.string.no_camera, extra == null ? "发生未知错误" : extra));
    }
}