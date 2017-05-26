package br.com.halphdem.hummingbirdsmdb;

import android.app.Application;

import br.com.halphdem.hummingbirdsmdb.di.okhttpclient.DaggerOkHttpClientComponent;
import br.com.halphdem.hummingbirdsmdb.di.okhttpclient.OkHttpClientComponent;
import br.com.halphdem.hummingbirdsmdb.di.okhttpclient.OkHttpClientModule;
import br.com.halphdem.hummingbirdsmdb.di.retrofit.DaggerRetrofitComponent;
import br.com.halphdem.hummingbirdsmdb.di.retrofit.RetrofitComponent;
import br.com.halphdem.hummingbirdsmdb.di.retrofit.RetrofitModule;

public class HummingBirdsMdbApplication extends Application {

    private static OkHttpClientComponent okHttpClientComponent;

    private static RetrofitComponent retrofitComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        okHttpClientComponent = DaggerOkHttpClientComponent.builder().okHttpClientModule(new OkHttpClientModule()).build();

        retrofitComponent = DaggerRetrofitComponent.builder().retrofitModule(new RetrofitModule()).okHttpClientComponent(okHttpClientComponent).build();
    }

    public static RetrofitComponent getRetrofitComponent() {
        return retrofitComponent;
    }
}
