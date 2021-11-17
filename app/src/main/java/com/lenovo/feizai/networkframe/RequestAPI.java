package com.lenovo.feizai.networkframe;

import com.lenovo.feizai.networkframe.entity.Customer;
import com.lenovo.feizai.networkframe.entity.Weather;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author feizai
 * @date 2021/6/2 0002 AM 10:53:44
 */
public interface RequestAPI {
//    public static final String BASE_URL = "http://172.21.58.83:8080/Parking_war/";
    public static final String BASE_URL = "http://aider.meizu.com/";
    public static final String BASE_IMAGE_URL = "";


    @GET("api/customer/selectCustomerByUsername")//接口名
    Observable<BaseModel<Customer>> selectCustomerByUsername(@Query("name") String name);//你的参数，和接口参数保持一致

    @POST("app/weather/listWeather")
    Observable<BaseModel<Weather>> getWeatherByCityId(@Query("cityIds") String cityIds);
}
