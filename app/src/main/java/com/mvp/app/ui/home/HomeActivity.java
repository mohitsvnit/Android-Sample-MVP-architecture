package com.mvp.app.ui.home;

import android.support.compat.HomeActivityPresenter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mvp.app.Injection;
import com.mvp.app.R;
import com.mvp.app.base.BaseActivity;

public class HomeActivity extends BaseActivity implements HomeContract.View{

    private HomeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setPresenter(HomePresenter.getInstance(Injection.provideDataManager(this)
                , this));

    }


    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showError(String error) {

    }
}
