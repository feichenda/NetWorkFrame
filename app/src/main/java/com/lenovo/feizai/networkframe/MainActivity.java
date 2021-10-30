package com.lenovo.feizai.networkframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lenovo.feizai.networkframe.utils.ToastUtil;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private RetrofitClient.Builder client;
    private ToastUtil toast;
    private EditText account;
    private EditText password;
    private Button login;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        account = findViewById(R.id.account);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
    }

    @Override
    protected void onStart() {
        super.onStart();
        client = new RetrofitClient.Builder(this);
        client.setUrl("")
                .setTimeOut(10)
                .setConnectionPool(10, 10, TimeUnit.SECONDS)
                .builder();
    }

    @Override
    protected void onResume() {
        super.onResume();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.showToast("login");
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.showToast("regitster");
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        client.destory();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}