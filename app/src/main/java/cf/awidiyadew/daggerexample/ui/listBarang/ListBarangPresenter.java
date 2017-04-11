package cf.awidiyadew.daggerexample.ui.listBarang;

import android.util.Log;

import java.util.ArrayList;

import javax.inject.Inject;

import cf.awidiyadew.daggerexample.DaggerExampleApp;
import cf.awidiyadew.daggerexample.DataManager;
import cf.awidiyadew.daggerexample.model.ApiResponse;
import cf.awidiyadew.daggerexample.ui.base.BasePresenter;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
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

        // pastikan view telah di attach ke presenter
        checkViewAttached();

        getMvpView().showLoading(true);

        mSubscription = mDataManager.getListBarang()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ApiResponse>() {
                        @Override
                        public void onCompleted() {
                            Log.d(TAG, "onCompleted ");
                            getMvpView().showLoading(false);
                        }

                        @Override
                        public void onError(Throwable e) {
                            getMvpView().showLoading(false);
                            getMvpView().showError(e.getMessage());
                            Log.e(TAG, "onError: ", e);
                        }

                        @Override
                        public void onNext(ApiResponse apiResponse) {
                            getMvpView().showData(new ArrayList<>(apiResponse.getTbBarang()));
                        }
                    });
    }

    @Override
    public void detachView() {
        super.detachView();

        if (mSubscription != null && !mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();

    }
}
