package com.lenovo.feizai.networkframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lenovo.feizai.networkframe.entity.User;
import com.lenovo.feizai.networkframe.utils.ToastUtil;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private RetrofitClient client;
    private RetrofitClient client1;
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
        toast = ToastUtil.getInstance(this);
        client = new RetrofitClient.Builder(this)
                .setUrl("http://172.21.58.82:8080/Parking_war/")
                .setTimeOut(2)
                .setConnectionPool(10, 10, TimeUnit.SECONDS)
                .builder();
        client1 = new RetrofitClient.Builder(this)
                .setUrl("http://172.21.58.82:8080/Parking/")
                .setTimeOut(2)
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
                client.getAllUserList(new BaseObserver<User>(MainActivity.this) {
                    @Override
                    protected void showDialog() {

                    }

                    @Override
                    protected void hideDialog() {

                    }

                    @Override
                    protected void successful(User user) {

                    }

                    @Override
                    protected void defeated(User user) {

                    }

                    @Override
                    protected void onError(ExceptionHandle.ResponeThrowable e) {

                    }
                });
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.showToast("regitster");
                client1.getAllUserList(new BaseObserver<User>(MainActivity.this) {
                    @Override
                    protected void showDialog() {

                    }

                    @Override
                    protected void hideDialog() {

                    }

                    @Override
                    protected void successful(User user) {

                    }

                    @Override
                    protected void defeated(User user) {

                    }

                    @Override
                    protected void onError(ExceptionHandle.ResponeThrowable e) {

                    }
                });
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