package cf.awidiyadew.daggerexample.ui.listBarang;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import cf.awidiyadew.daggerexample.R;
import cf.awidiyadew.daggerexample.model.Barang;
import cf.awidiyadew.daggerexample.model.Picture;
import cf.awidiyadew.daggerexample.ui.base.BaseActivity;

public class ListBarangActivity extends BaseActivity implements ListBarangView {

    private static final String TAG = "ListBarangActivity";
    ListBarangPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new ListBarangPresenter();
        mPresenter.attachView(this);

        /*mPresenter.getListBarang();

        mPresenter.getListPicture();*/

        mPresenter.getListBarangWithPicture();

    }

    @Override
    public void showLoading(boolean isShow) {
        showProgressBarLoading(isShow, "Please wait...");
    }

    @Override
    public void showData(ArrayList<Barang> listBarang) {
        for (Barang barang : listBarang){

            for (Picture pic : barang.getPictures()){
                Log.d(TAG, "Barang with picture: " + barang.getNamaBarang() + " | " + pic.getIdPicture());
            }
        }
    }

    @Override
    public void showPicture(ArrayList<Picture> listPicture) {
        for (Picture picture : listPicture){
            Log.d(TAG, "showData: " + picture.getPath());
        }
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
