package cf.awidiyadew.daggerexample.ui.listBarang;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cf.awidiyadew.daggerexample.DaggerExampleApp;
import cf.awidiyadew.daggerexample.DataManager;
import cf.awidiyadew.daggerexample.model.ApiResponse;
import cf.awidiyadew.daggerexample.model.Barang;
import cf.awidiyadew.daggerexample.model.Picture;
import cf.awidiyadew.daggerexample.ui.base.BasePresenter;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.internal.util.SubscriptionList;
import rx.schedulers.Schedulers;

/**
 * Created by awidiyadew on 4/11/17.
 */

public class ListBarangPresenter extends BasePresenter<ListBarangView> {

    private static final String TAG = "ListBarangPresenter";

    @Inject
    DataManager mDataManager;

    private Subscription mSubscriptionBarang;
    private Subscription mSubscriptionPicture;
    private Subscription mSubscriptionJoin;

    SubscriptionList mSubscriptionList;

    public ListBarangPresenter() {

        DaggerExampleApp.getApp().getComponent().inject(this);

        mSubscriptionList = new SubscriptionList();

    }

    public void getListBarang(){

        // pastikan view telah di attach ke presenter
        checkViewAttached();

        getMvpView().showLoading(true);

        mSubscriptionBarang = mDataManager.getListBarang()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<ApiResponse<Barang>>() {
                @Override
                public void onCompleted() {
                    Log.d(TAG, "onCompleted ");
                    getMvpView().showLoading(false);
                }

                @Override
                public void onError(Throwable e) {
                    getMvpView().showError(e.getMessage());
                    Log.e(TAG, "onError: ", e);
                }

                @Override
                public void onNext(ApiResponse<Barang> barangApiResponse) {
                    //getMvpView().showData(new ArrayList<>(apiResponse.getTbBarang()));

                    getMvpView().showData(new ArrayList<>(barangApiResponse.getTbBarang()));
                }
            });

        mSubscriptionList.add(mSubscriptionBarang);
    }

    public void getListPicture(){

        // pastikan view telah di attach ke presenter
        checkViewAttached();

        getMvpView().showLoading(true);

        mSubscriptionPicture = mDataManager.getListPicture()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ApiResponse<Picture>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted ");
                        getMvpView().showLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(e.getMessage());
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onNext(ApiResponse<Picture> pictureApiResponse) {
                        //getMvpView().showData(new ArrayList<>(apiResponse.getTbBarang()));

                        getMvpView().showPicture(new ArrayList<>(pictureApiResponse.getTbPicture()));
                    }
                });

        mSubscriptionList.add(mSubscriptionPicture);

    }

    public void getListBarangWithPicture(){

        // pastikan view telah di attach ke presenter
        checkViewAttached();

        getMvpView().showLoading(true);

        mSubscriptionJoin = Observable.zip(
                mDataManager.getListBarang(),
                mDataManager.getListPicture(),
                new Func2<ApiResponse<Barang>, ApiResponse<Picture>, List<Barang>>() {

            @Override
            public List<Barang> call(ApiResponse<Barang> barangApiResponse, ApiResponse<Picture> pictureApiResponse) {

                List<Barang> barangWithPicture = new ArrayList<>();

                /* Get all list barang */
                for (Barang brg : barangApiResponse.getTbBarang()){

                    /* take idBarang from tb_barang */
                    String idBarangInBarang = brg.getIdBarang();
                    ArrayList<Picture> listPicOnBrg = new ArrayList<>();

                    /* get all picture list from tb_picture */
                    for (Picture picture : pictureApiResponse.getTbPicture()){
                        /* tak idBarang from tb_picure */
                        String idBarangInPicture = picture.getIdBarang();
                        /* if ibBarang from tb_barang equal to idBarang in tb_picture */
                        if (idBarangInBarang.equalsIgnoreCase(idBarangInPicture)) listPicOnBrg.add(picture);
                    }

                    /* set list picture with matched with idBarang */
                    brg.setPictures(listPicOnBrg);
                    barangWithPicture.add(brg);
                }

                return barangWithPicture;
            }

        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<List<Barang>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted ");
                getMvpView().showLoading(false);
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showError(e.getMessage());
                Log.e(TAG, "onError: ", e);
            }

            @Override
            public void onNext(List<Barang> barangs) {
                getMvpView().showData(new ArrayList<>(barangs));
            }
        });

        mSubscriptionList.add(mSubscriptionJoin);

    }

    public void gotoDetailView(Barang barang){

    }

    @Override
    public void detachView() {
        super.detachView();

        if (mSubscriptionList.hasSubscriptions() && !mSubscriptionList.isUnsubscribed()){
            mSubscriptionList.unsubscribe();
            Log.d(TAG, "detachView: unsubscribe all subscription");
        }

    }
}
