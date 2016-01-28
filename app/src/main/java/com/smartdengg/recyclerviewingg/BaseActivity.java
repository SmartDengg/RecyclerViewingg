package com.smartdengg.recyclerviewingg;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

public  class BaseActivity extends AppCompatActivity {

  @Override public void setContentView(@LayoutRes int layoutResID) {
    super.setContentView(layoutResID);
    ButterKnife.bind(BaseActivity.this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(BaseActivity.this);
  }

}
