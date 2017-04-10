package cf.awidiyadew.daggerexample.ui.listBarang;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

import cf.awidiyadew.daggerexample.DaggerExampleApp;
import cf.awidiyadew.daggerexample.DataManager;
import cf.awidiyadew.daggerexample.model.ApiResponse;
import cf.awidiyadew.daggerexample.model.Barang;
import cf.awidiyadew.daggerexample.ui.base.BasePresenter;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by awidiyadew on 4/11/17.
 */

public class ListBarangPresenter extends BasePresenter<ListBarangView> {

    private static final String TAG = "ListBarangPresenter";
    @Inject
    DataManager mDataManager;

    private Subscription mSubscription;

    public ListBarangPresenter() {

        DaggerExampleApp.getApp().getComponent().inject(this);

    }

    public void getListBarang(){
        mSubscription = mDataManager.getListBarang()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(new Func1<ApiResponse, ArrayList<Barang>>() {
                        @Override
                        public ArrayList<Barang> call(ApiResponse apiResponse) {
                            return new ArrayList<Barang>(apiResponse.getTbBarang());
                        }
                    })
                    .subscribe(new Subscriber<ArrayList<Barang>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(ArrayList<Barang> barangs) {
                            for (Barang brg : barangs){
                                Log.d(TAG, "onNext: " + brg.getNamaBarang());
                            }
                        }
                    });
                    /*.subscribe(new Subscriber<ApiResponse>() {
                        @Override
                        public void onCompleted() {
                            Log.d(TAG, "onCompleted ");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: ", e);
                        }

                        @Override
                        public void onNext(ApiResponse apiResponse) {
                            Log.d(TAG, "onNext: " + apiResponse.getTbBarang().get(0).getNamaBarang());
                        }
                    });*/
    }
}
