package br.com.halphdem.hummingbirdsmdb.di.application;

import br.com.halphdem.hummingbirdsmdb.HummingBirdsMdbApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    public final HummingBirdsMdbApplication application;

    public ApplicationModule(HummingBirdsMdbApplication application) {
        this.application = application;
    }

    @Provides
    public HummingBirdsMdbApplication getApplication() {
        return this.application;
    }
}