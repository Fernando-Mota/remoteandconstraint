package br.com.halphdem.hummingbirdsmdb.di.movierepository;

import br.com.halphdem.hummingbirdsmdb.movie.data.MovieRepository;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteAPI;
import br.com.halphdem.hummingbirdsmdb.movie.data.remote.MovieRemoteRepository;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MovieRepositoryModule {

    @Provides
    public MovieRemoteAPI providesAbstractMovieRemoteRepository(Retrofit retrofit) {
        return retrofit.create(MovieRemoteAPI.class);
    }

    @Provides
    public MovieRemoteRepository providesMovieRemoteRepository(MovieRemoteAPI movieRemoteAPI) {
        return new MovieRemoteRepository(movieRemoteAPI);
    }

    @Provides
    public MovieRepository providesMovieRepository(MovieRemoteRepository remoteRepository) {
        return new MovieRepository(remoteRepository);
    }

}
