package com.smartdengg.recyclerviewingg.activity.linear;

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
 * Created by SmartDengg on 2016/1/29.
 */
public class LinearActivity extends BaseActivity {

  @BindString(R.string.linear_recyclerView) protected String title;
  @BindString(R.string.linear_recyclerView_vertical) protected String verticalString;
  @BindString(R.string.linear_recyclerView_horizontal) protected String horizontalString;

  @NonNull @Bind(R.id.linear_layout_vertical_btn) protected Button verticalBtn;
  @NonNull @Bind(R.id.linear_layout_horizontal_btn) protected Button horizontalBtn;

  public static void navigateToLinearActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, LinearActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.navigate_linear_layout);

    this.verticalBtn.setText(verticalString);
    this.horizontalBtn.setText(horizontalString);
  }

  @NonNull @OnClick(R.id.linear_layout_vertical_btn) void onVerticalClick() {
    LinearVerticalActivity.navigateToVerticalActivity(LinearActivity.this);
  }

  @NonNull @OnClick(R.id.linear_layout_horizontal_btn) void onHorizontalClick() {
    LinearHorizontalActivity.navigateToHorizontalActivity(LinearActivity.this);
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(title);

    LinearActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    LinearActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }
}
