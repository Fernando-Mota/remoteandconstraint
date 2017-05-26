package br.com.halphdem.hummingbirdsmdb.di.application;

import br.com.halphdem.hummingbirdsmdb.HummingBirdsMdbApplication;
import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    HummingBirdsMdbApplication getApplication();

    void inject(HummingBirdsMdbApplication hummingBirdsMdbApplication);

}
