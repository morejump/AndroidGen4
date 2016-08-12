package com.project.phamhoang.weatherappnghean;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by phamhoang on 8/13/16.
 */
public class ServiceFactory {

    private Retrofit retrofit;
    private static final String BASE_URL = "http://http://api.openweathermap.org";

    private static ServiceFactory ourInstance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <ServiceClass>ServiceClass creatService(Class<ServiceClass>serviceClass) {
        return retrofit.create(serviceClass);
    }
}
