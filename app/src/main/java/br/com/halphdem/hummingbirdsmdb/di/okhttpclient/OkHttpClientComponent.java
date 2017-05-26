package br.com.halphdem.hummingbirdsmdb.di.okhttpclient;

import dagger.Component;
import okhttp3.OkHttpClient;

@Component(modules = OkHttpClientModule.class)
public interface OkHttpClientComponent {

    OkHttpClient getOkHttpClient();

}