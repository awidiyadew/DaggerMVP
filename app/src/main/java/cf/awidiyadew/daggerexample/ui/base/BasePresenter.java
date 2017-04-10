package cf.awidiyadew.daggerexample.ui.base;

/**
 * Created by awidiyadew on 4/11/17.
 */

public class BasePresenter<T extends MvpView> implements Presenter<T>{

    private T mMvpView;


    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public void checkViewAttached(){
        if(!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

    public T getMvpView() {
        return mMvpView;
    }
}
