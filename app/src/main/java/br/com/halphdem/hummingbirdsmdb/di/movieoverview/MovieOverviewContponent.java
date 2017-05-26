package br.com.halphdem.hummingbirdsmdb.di.movieoverview;

import br.com.halphdem.hummingbirdsmdb.di.movierepository.MovieRepositoryComponent;
import br.com.halphdem.hummingbirdsmdb.movieoverview.MovieOverviewContract;
import br.com.halphdem.hummingbirdsmdb.movieoverview.MovieOverviewFragment;
import dagger.Component;

@Component(modules = MovieOverviewModule.class, dependencies = MovieRepositoryComponent.class)
public interface MovieOverviewContponent {

    MovieOverviewContract.Presenter getPresenter();

    void inject(MovieOverviewFragment view);

}
