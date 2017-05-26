package br.com.halphdem.hummingbirdsmdb.movieoverview;

import android.content.Context;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import br.com.halphdem.hummingbirdsmdb.BuildConfig;
import br.com.halphdem.hummingbirdsmdb.movie.data.MovieRepository;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteAPI;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteListenersContract;

public class MovieOverviewPresenter implements MovieOverviewContract.Presenter {


    private MovieRepository repository;

    @Inject
    public MovieOverviewPresenter(MovieRepository movieRepository) {
        this.repository = movieRepository;
    }

    @Override
    public void findById(String id, MovieRemoteListenersContract.MovieFindByIdListener listener) {
        repository.findById(new Integer(id), listener, getQueryMap());
    }

    @Override
    public void loadImage(Context context, String imageUri, ImageView destinationImageView) {
        repository.loadRemoteImage(context, imageUri, destinationImageView);
    }

    public Map<String, String> getQueryMap() {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("api_key", MovieRemoteAPI.apiKey);
        queryMap.put("language", "en-US");
        return queryMap;
    }
}