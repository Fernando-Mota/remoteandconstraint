package br.com.halphdem.hummingbirdsmdb.movielist;

import android.content.Context;
import android.widget.ImageView;

import br.com.halphdem.hummingbirdsmdb.infra.MovieSearchPagination;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteListenersContract;

public interface MovieListContract {

    interface View {

        void openMovieOverView(String id);

    }

    interface Presenter {

        void listMovies(MovieRemoteListenersContract.MovieDiscoverListener listener);

        void loadImage(Context context, String imageUri, ImageView destinationImageView);

        void setPagination(MovieSearchPagination pagination);

        int getNextPage();

    }

}