package br.com.halphdem.hummingbirdsmdb.di.movielist;

import br.com.halphdem.hummingbirdsmdb.di.movierepository.MovieRepositoryComponent;
import br.com.halphdem.hummingbirdsmdb.movielist.MovieListContract;
import br.com.halphdem.hummingbirdsmdb.movielist.MovieListFragment;
import dagger.Component;

@Component(modules = MovieListModule.class, dependencies = MovieRepositoryComponent.class)
public interface MovieListComponent {

    MovieListContract.Presenter getPresenter();

    void inject(MovieListFragment view);
}