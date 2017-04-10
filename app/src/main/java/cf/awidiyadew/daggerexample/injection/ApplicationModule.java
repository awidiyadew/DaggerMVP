package cf.awidiyadew.daggerexample.injection;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by awidiyadew on 4/10/17.
 */

@Module
public class ApplicationModule {

    protected final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    Application provideApplication(){ return mApplication; }

    @Provides
    Context provideContext(){ return mApplication.getApplicationContext(); }

}
