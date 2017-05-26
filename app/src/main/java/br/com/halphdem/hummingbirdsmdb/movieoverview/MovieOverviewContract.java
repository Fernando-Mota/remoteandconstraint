package br.com.halphdem.hummingbirdsmdb.movieoverview;

import android.content.Context;
import android.widget.ImageView;

import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteListenersContract;

public interface MovieOverviewContract {

    public interface View {

    }

    public interface Presenter {

        public void findById(String id, MovieRemoteListenersContract.MovieFindByIdListener listener);

        public void loadImage(Context context, String imageUri, ImageView destinationImageView);
    }
}
