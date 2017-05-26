package br.com.halphdem.hummingbirdsmdb.di.movierepository;

import br.com.halphdem.hummingbirdsmdb.di.retrofit.RetrofitComponent;
import br.com.halphdem.hummingbirdsmdb.movie.data.MovieRepository;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteAPI;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteRepository;
import dagger.Component;

@Component(modules = MovieRepositoryModule.class, dependencies = RetrofitComponent.class)
public interface MovieRepositoryComponent {

    MovieRemoteAPI getMovieRemoteAPI();

    MovieRemoteRepository getMovieRemoteRepository();

    MovieRepository getMovieRepository();

}
