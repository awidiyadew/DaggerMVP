package cf.awidiyadew.daggerexample.ui.listBarang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cf.awidiyadew.daggerexample.R;
import cf.awidiyadew.daggerexample.model.Barang;
import cf.awidiyadew.daggerexample.model.Picture;
import cf.awidiyadew.daggerexample.ui.base.BaseActivity;

public class ListBarangActivity extends BaseActivity implements ListBarangView, ListBarangAdapter.OnItemClick {

    private static final String TAG = "ListBarangActivity";
    ListBarangPresenter mPresenter;
    @BindView(R.id.recyclerView)
    android.support.v7.widget.RecyclerView mRecyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.textProgress)
    TextView textProgress;
    @BindView(R.id.layoutProgress)
    LinearLayout layoutProgress;

    ListBarangAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new ListBarangPresenter();
        mPresenter.attachView(this);

        mPresenter.getListBarangWithPicture();

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new ListBarangAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showLoading(boolean isShow) {
        showProgressBarLoading(isShow, "Please wait...");
    }

    @Override
    public void showData(ArrayList<Barang> listBarang) {
        for (Barang barang : listBarang) {

            for (Picture pic : barang.getPictures()) {
                Log.d(TAG, "Barang with picture: " + barang.getNamaBarang() + " | " + pic.getIdPicture());
            }

            mAdapter.add(barang);
        }
    }

    @Override
    public void showPicture(ArrayList<Picture> listPicture) {
        for (Picture picture : listPicture) {
            Log.d(TAG, "showData: " + picture.getPath());
        }
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(Barang barang) {
        //mPresenter.gotoDetailView(barang);
        /* TODO : GOTO DETAIL VIEW */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
