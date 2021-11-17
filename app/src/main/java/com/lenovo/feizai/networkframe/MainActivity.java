package com.lenovo.feizai.networkframe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lenovo.feizai.networkframe.entity.Index;
import com.lenovo.feizai.networkframe.entity.Value;
import com.lenovo.feizai.networkframe.entity.Weather;
import com.lenovo.feizai.networkframe.entity.Weather3HoursDetailsInfo;
import com.lenovo.feizai.networkframe.utils.ToastUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private RetrofitClient client;
    private ToastUtil toast;
    private EditText account;
    private EditText password;
    private Button login;
    private Button register;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        context = this;
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
        client = new RetrofitClient.Builder<MyRequestAPI>(this)
                .setServiceApi(MyRequestAPI.class)
                .setTimeOut(10)
                .setConnectionPool(100, 100, TimeUnit.SECONDS)
                .builder();
    }

    @Override
    protected void onResume() {
        super.onResume();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client.getWeatherByCityId("101280301", new BaseObserver<BaseModel<Value>>(context) {
                    @Override
                    protected void showDialog() {

                    }

                    @Override
                    protected void hideDialog() {

                    }

                    @Override
                    protected void successful(BaseModel<Value> valueBaseModel) {
                        List<Value> values = valueBaseModel.getValue();
                        for (Value value : values) {
                            toast.showToast(value.toString());
                            Log.d("weather", value.getCity());
                            Log.d("weather", value.getCityid());
                            Log.d("weather", value.getProvinceName());
                            Log.d("weather", value.getRealtime().toString());
                            for (Index index : value.getIndexes()) {
                                Log.d("weather", index.toString());
                            }

                            Log.d("weather", value.getWeatherDetailsInfo().getPublishTime());
                            for (Weather3HoursDetailsInfo weather3HoursDetailsInfo : value.getWeatherDetailsInfo().getWeather3HoursDetailsInfos()) {
                                Log.d("weather", weather3HoursDetailsInfo.toString());
                            }
                            Log.d("weather", value.getPm25().toString());
                            for (Weather weather : value.getWeathers()) {
                                Log.d("weather", weather.toString());
                            }

                        }

                    }

                    @Override
                    protected void defeated(BaseModel<Value> valueBaseModel) {
                        toast.showToast(valueBaseModel.getCode().toString());
                    }

                    @Override
                    protected void onError(ExceptionHandle.ResponeThrowable e) {
                        toast.showToast(e.getMessage());
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