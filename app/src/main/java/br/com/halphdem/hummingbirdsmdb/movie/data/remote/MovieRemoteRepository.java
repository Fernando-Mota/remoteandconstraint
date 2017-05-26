package br.com.halphdem.hummingbirdsmdb.movie.data.remote;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.com.halphdem.hummingbirdsmdb.BuildConfig;
import br.com.halphdem.hummingbirdsmdb.infra.MovieSearchPagination;
import br.com.halphdem.hummingbirdsmdb.movie.data.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRemoteRepository {

    private MovieRemoteAPI movieRemoteAPI;

    @Inject
    public MovieRemoteRepository(MovieRemoteAPI remoteRepository) {
        this.movieRemoteAPI = remoteRepository;
    }

    public void discover(final MovieRemoteListenersContract.MovieDiscoverListener listener, Map<String, String> queryMap) {
        movieRemoteAPI.discover(queryMap).enqueue(new Callback<MovieSearchPagination>() {
            @Override
            public void onResponse(Call<MovieSearchPagination> call, Response<MovieSearchPagination> response) {
                listener.onDiscover(response.body());
            }

            @Override
            public void onFailure(Call<MovieSearchPagination> call, Throwable t) {
                listener.onDiscoverError(t);
            }
        });
    }

    public void findById(int id, final MovieRemoteListenersContract.MovieFindByIdListener listener, Map<String, String> queryMap) {
        movieRemoteAPI.findById(id, queryMap).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                listener.onFindById(response.body());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                listener.onFindByIdError(t);
            }
        });
    }

    public void search(int nextPage, String searchQuery, final MovieRemoteListenersContract.MovieSearchListener listener) {
        movieRemoteAPI.search(nextPage, MovieRemoteAPI.apiKey, searchQuery).enqueue(new Callback<MovieSearchPagination>() {
            @Override
            public void onResponse(Call<MovieSearchPagination> call, Response<MovieSearchPagination> response) {
                listener.onSearch(response.body());
            }

            @Override
            public void onFailure(Call<MovieSearchPagination> call, Throwable t) {
                listener.onSearchError(t);
            }
        });
    }

    public void loadRemoteImage(Context context, String uri, ImageView destination) {
        Picasso.with(context).load(BuildConfig.URL_IMAGES + uri).fit().centerCrop().into(destination);
    }
}
