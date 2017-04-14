package cf.awidiyadew.daggerexample.injection;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import cf.awidiyadew.daggerexample.DaggerExampleApp;
import cf.awidiyadew.daggerexample.ui.listBarang.ListBarangActivity;
import cf.awidiyadew.daggerexample.ui.listBarang.ListBarangPresenter;
import dagger.Component;

/**
 * Created by awidiyadew on 4/10/17.
 */

@Singleton
@Component(modules = { ApplicationModule.class, NetworkModule.class } )
public interface ApplicationComponent {

    Context context();

    Application application();

    void inject(ListBarangPresenter listBarangPresenter);

    void inject(DaggerExampleApp daggerExampleApp);

}
