package com.yibao.buglydemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = " ==== " + MainActivity.class.getSimpleName() + "  ";
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mBtn1 = findViewById(R.id.btn1);
        mBtn2 = findViewById(R.id.btn2);
        mBtn3 = findViewById(R.id.btn3);
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btn1) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "制造Bug", Toast.LENGTH_SHORT).show();
                }
            }).start();
        } else if (id == R.id.btn2) {
            Log.d(TAG, "正常点击");

        } else if (id == R.id.btn3) {
            mTextView.setText("空指针Bug");

        }
    }
}
