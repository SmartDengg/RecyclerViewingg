package com.smartdengg.recyclerviewingg.activity.decoration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Button;
import butterknife.Bind;
import butterknife.BindString;
import butterknife.OnClick;
import com.smartdengg.recyclerviewingg.BaseActivity;
import com.smartdengg.recyclerviewingg.R;

/**
 * Created by SmartDengg on 2016/1/30.
 */
public class DecorationActivity extends BaseActivity {

  @BindString(R.string.decoration_recyclerView) protected String title;
  @BindString(R.string.decoration_recyclerView_standard) protected String standardString;
  @BindString(R.string.decoration_recyclerView_over) protected String overString;

  @NonNull @Bind(R.id.decoration_navigate_layout_standard_btn) protected Button standardBtn;
  @NonNull @Bind(R.id.decoration_navigate_layout_over_btn) protected Button overBtn;

  public static void navigateToDecorationActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, DecorationActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.decoration_navigate_layout);

    this.standardBtn.setText(standardString);
    this.overBtn.setText(overString);
  }

  @NonNull @OnClick({ R.id.decoration_navigate_layout_standard_btn, R.id.decoration_navigate_layout_over_btn })
  void onButtonClick(Button button) {

    switch (button.getId()) {
      case R.id.decoration_navigate_layout_standard_btn:
        DecorationActivityyyy.navigateToDecorationActivityyyy(DecorationActivity.this,
                                                              DecorationActivityyyy.STANDARD_DRAW);
        break;

      case R.id.decoration_navigate_layout_over_btn:
        DecorationActivityyyy.navigateToDecorationActivityyyy(DecorationActivity.this, DecorationActivityyyy.OVER_DRAW);
        break;
    }
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(title);

    DecorationActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    DecorationActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }
}
