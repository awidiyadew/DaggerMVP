package cf.awidiyadew.daggerexample.ui.listBarang;

import java.util.ArrayList;
import java.util.List;

import cf.awidiyadew.daggerexample.model.Barang;
import cf.awidiyadew.daggerexample.model.Picture;
import cf.awidiyadew.daggerexample.ui.base.MvpView;

/**
 * Created by awidiyadew on 4/11/17.
 */

public interface ListBarangView extends MvpView {

    void showLoading(boolean isShow);

    void showData(ArrayList<Barang> listBarang);

    void showPicture(ArrayList<Picture> listPicture);

    void showError(String errorMessage);

}
