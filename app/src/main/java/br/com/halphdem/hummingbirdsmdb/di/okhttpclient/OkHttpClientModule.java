package br.com.halphdem.hummingbirdsmdb.di.okhttpclient;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class OkHttpClientModule {

    @Provides
    public OkHttpClient providesOkHttpClient() {
        return new OkHttpClient();
    }
}
