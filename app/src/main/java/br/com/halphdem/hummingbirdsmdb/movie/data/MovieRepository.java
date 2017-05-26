package br.com.halphdem.hummingbirdsmdb.movie.data;

import android.content.Context;
import android.widget.ImageView;

import java.util.Map;

import javax.inject.Inject;

import br.com.halphdem.hummingbirdsmdb.infra.MovieSearchPagination;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteListenersContract;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteRepository;

/**
 * Created by fernando on 13/05/17.
 */

public class MovieRepository {

    private MovieRemoteRepository remoteRepository;

    @Inject
    public MovieRepository(MovieRemoteRepository movieRemoteRepository) {
        this.remoteRepository = movieRemoteRepository;
    }

    public void discover(MovieRemoteListenersContract.MovieDiscoverListener listener, Map<String, String> queryMap) {
        remoteRepository.discover(listener, queryMap);
    }

    public void findById(int id, MovieRemoteListenersContract.MovieFindByIdListener listener, Map<String, String> queryMap) {
        remoteRepository.findById(id, listener, queryMap);
    }

    public void loadRemoteImage(Context context, String uri, ImageView destination) {
        remoteRepository.loadRemoteImage(context, uri, destination);
    }

}
