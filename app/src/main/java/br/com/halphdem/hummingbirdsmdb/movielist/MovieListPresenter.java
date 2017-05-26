package br.com.halphdem.hummingbirdsmdb.movielist;

import android.content.Context;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import br.com.halphdem.hummingbirdsmdb.infra.MovieSearchPagination;
import br.com.halphdem.hummingbirdsmdb.movie.data.MovieRepository;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteAPI;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteListenersContract;

public class MovieListPresenter implements MovieListContract.Presenter {

    private MovieRepository movieRepository;

    private MovieSearchPagination pagination;

    @Inject
    public MovieListPresenter(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void listMovies(MovieRemoteListenersContract.MovieDiscoverListener listener) {
        movieRepository.discover(listener, getQueryMapDiscover());
    }

    @Override
    public void loadImage(Context context, String imageUri, ImageView destination) {
        movieRepository.loadRemoteImage(context, imageUri, destination);
    }

    @Override
    public void setPagination(MovieSearchPagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public int getNextPage() {
        if (pagination == null)
            pagination = new MovieSearchPagination(0, 0, 0);
        return pagination.getPage() + 1;
    }

    public Map<String, String> getQueryMapDiscover() {
        Map<String, String> queryMapResult = new HashMap<>();
        queryMapResult.put("api_key", MovieRemoteAPI.apiKey);
        queryMapResult.put("sort_by", "popularity.desc");
        queryMapResult.put("include_adult", "false");
        queryMapResult.put("include_video", "false");
        queryMapResult.put("page", String.valueOf(getNextPage()));
        return queryMapResult;
    }
}