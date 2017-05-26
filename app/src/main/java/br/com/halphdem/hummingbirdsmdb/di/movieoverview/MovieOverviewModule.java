package br.com.halphdem.hummingbirdsmdb.di.movieoverview;

import br.com.halphdem.hummingbirdsmdb.movie.data.MovieRepository;
import br.com.halphdem.hummingbirdsmdb.movieoverview.MovieOverviewContract;
import br.com.halphdem.hummingbirdsmdb.movieoverview.MovieOverviewPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class MovieOverviewModule {

    @Provides
    public MovieOverviewContract.Presenter providesMovieOverviewPresenter(MovieRepository movieRepository) {
        return new MovieOverviewPresenter(movieRepository);
    }

}
