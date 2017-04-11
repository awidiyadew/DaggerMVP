package cf.awidiyadew.daggerexample.ui.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void showProgressBarLoading(boolean isShow, String message){
        if (isShow){

            if (mProgressDialog == null)
                mProgressDialog = new ProgressDialog(this);

            mProgressDialog.setMessage(message);
            mProgressDialog.show();

        }else {
            if (mProgressDialog != null && mProgressDialog.isShowing())
                mProgressDialog.hide();
        }
    }
}
