package cf.awidiyadew.daggerexample.injection;

import android.app.Service;

import javax.inject.Singleton;

import cf.awidiyadew.daggerexample.remote.ApiService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by awidiyadew on 4/10/17.
 */

@Module
public class NetworkModule {

    private static final String BASE_URL = "http://awidiyadew.cf/MettaHardware/api/api.php/";

    @Provides
    public ApiService provideItemService(Retrofit retrofit){
        // this method need retrofit, someone have to provide Retrofit
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        // I need OkHttpClient, someone please provide OkHttp
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                // Convert retrofit response into Observable
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient().newBuilder().build();
    }

}
