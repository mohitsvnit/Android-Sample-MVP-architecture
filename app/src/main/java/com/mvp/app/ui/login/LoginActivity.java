package com.mvp.app.ui.login;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mvp.app.Injection;
import com.mvp.app.R;
import com.mvp.app.base.BaseActivity;
import com.mvp.app.data.model.User;
import com.mvp.app.databinding.ActivityMainBinding;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private LoginContract.Presenter presenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        initPresenter();
        initClicks();
    }

    private void initClicks() {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.authenticateUser("", "");
            }
        });
    }

    private void initPresenter() {
        presenter = LoginPresenter.getInstance(Injection.provideDataManager(this)
                , this);
    }

    @Override
    public void onAuthenticationSuccessfull(User user) {
        binding.textView.setText(user.getName());
    }

    @Override
    public void onAuthenticationFailed(String error) {

    }
}
