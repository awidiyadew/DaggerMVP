package cf.awidiyadew.daggerexample.ui.listBarang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import cf.awidiyadew.daggerexample.R;
import cf.awidiyadew.daggerexample.model.Barang;

public class ListBarangActivity extends AppCompatActivity implements ListBarangView {

    ListBarangPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new ListBarangPresenter();

        mPresenter.getListBarang();
    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void showData(ArrayList<Barang> listBarang) {

    }

    @Override
    public void showError() {

    }
}
