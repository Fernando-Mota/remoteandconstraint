package br.com.halphdem.hummingbirdsmdb.di.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.halphdem.hummingbirdsmdb.BuildConfig;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Provides
    public Retrofit getRetrofit(OkHttpClient client) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }
}