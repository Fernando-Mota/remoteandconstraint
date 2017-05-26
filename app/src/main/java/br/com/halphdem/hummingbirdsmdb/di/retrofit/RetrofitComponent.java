package br.com.halphdem.hummingbirdsmdb.di.retrofit;

import br.com.halphdem.hummingbirdsmdb.di.okhttpclient.OkHttpClientComponent;
import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = RetrofitModule.class, dependencies = OkHttpClientComponent.class)
public interface RetrofitComponent {

    Retrofit getRetrofit();

}
