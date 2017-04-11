package cf.awidiyadew.daggerexample.ui.listBarang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import cf.awidiyadew.daggerexample.R;
import cf.awidiyadew.daggerexample.model.Barang;
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

        mPresenter.getListBarang();

    }

    @Override
    public void showLoading(boolean isShow) {
        showProgressBarLoading(isShow, "Please wait...");
    }

    @Override
    public void showData(ArrayList<Barang> listBarang) {
        for (Barang barang : listBarang){
            Log.d(TAG, "showData: " + barang.getNamaBarang());
        }
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
