package cf.awidiyadew.daggerexample;

import android.app.Application;

import cf.awidiyadew.daggerexample.injection.ApplicationComponent;
import cf.awidiyadew.daggerexample.injection.ApplicationModule;
import cf.awidiyadew.daggerexample.injection.DaggerApplicationComponent;

/**
 * Created by awidiyadew on 4/10/17.
 */

public class DaggerExampleApp extends Application {

    /* TODO : DONT FORGET ADD THIS APP TO MANIFEST */
    private static DaggerExampleApp mDaggerExampleApp;
    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mDaggerExampleApp = this;

        // Application component dibuat pertama oleh dagger
        if (mApplicationComponent == null){
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }

        mApplicationComponent.inject(this);

    }

    public static DaggerExampleApp getApp(){
        return mDaggerExampleApp;
    }

    public ApplicationComponent getComponent(){
        return mApplicationComponent;
    }
}
