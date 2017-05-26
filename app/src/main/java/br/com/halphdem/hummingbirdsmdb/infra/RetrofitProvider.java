package br.com.halphdem.hummingbirdsmdb.infra;

import br.com.halphdem.hummingbirdsmdb.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface RetrofitProvider {

    OkHttpClient client = new OkHttpClient();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();
}