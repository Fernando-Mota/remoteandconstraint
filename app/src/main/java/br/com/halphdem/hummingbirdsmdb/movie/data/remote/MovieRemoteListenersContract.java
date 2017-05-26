package br.com.halphdem.hummingbirdsmdb.movie.data.remote;

import java.util.List;

import br.com.halphdem.hummingbirdsmdb.infra.MovieSearchPagination;
import br.com.halphdem.hummingbirdsmdb.movie.data.Movie;

public class MovieRemoteListenersContract {

    public interface MovieDiscoverListener {
        public void onDiscover(MovieSearchPagination searchPagination);
        public void onDiscoverError(Throwable throwable);
    }

    public interface MovieFindByIdListener {
        public void onFindById(Movie movie);
        public void onFindByIdError(Throwable throwable);
    }

    public interface MovieSearchListener {
        public void onSearch(MovieSearchPagination searchPagination);
        public void onSearchError(Throwable throwable);
    }
}