package br.com.halphdem.hummingbirdsmdb.di.movielist;

import br.com.halphdem.hummingbirdsmdb.movie.data.MovieRepository;
import br.com.halphdem.hummingbirdsmdb.movielist.MovieListContract;
import br.com.halphdem.hummingbirdsmdb.movielist.MovieListPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class MovieListModule {

    @Provides
    public MovieListContract.Presenter providesMovieListPresenter(MovieRepository movieRepository) {
        return new MovieListPresenter(movieRepository);
    }

}