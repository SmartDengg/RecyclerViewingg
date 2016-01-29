package com.smartdengg.recyclerviewingg.activity;

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
public class GridActivity extends BaseActivity {

  @BindString(R.string.grid_recyclerView_standard) protected String standardString;
  @BindString(R.string.grid_recyclerView_auto_fix) protected String autoFixString;

  @NonNull @Bind(R.id.grid_layout_standard_btn) protected Button standardBtn;
  @NonNull @Bind(R.id.grid_layout_auto_fix_btn) protected Button autoFixBtn;

  public static void navigateToGridActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, GridActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.grid_navigate_layout);

    this.standardBtn.setText(standardString);
    this.autoFixBtn.setText(autoFixString);
  }

  @NonNull @OnClick(R.id.grid_layout_standard_btn) void onVerticalClick() {
    GridStandardActivity.navigateToStandardActivity(GridActivity.this);
  }

  @NonNull @OnClick(R.id.grid_layout_auto_fix_btn) void onHorizontalClick() {
    GridAutoFixActivity.navigateToGridAutoFixActivity(GridActivity.this);
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(getResources().getString(R.string.grid_recyclerView));

    GridActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    GridActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }
}
