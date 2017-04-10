package cf.awidiyadew.daggerexample.ui.base;

/**
 * Created by awidiyadew on 4/11/17.
 *
 * Setiap presenter harus meng-implement presenter ini atau BasePresenter
 */

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();

}
