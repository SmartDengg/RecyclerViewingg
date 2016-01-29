package com.smartdengg.recyclerviewingg.activity;

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
 * Created by SmartDengg on 2016/1/28.
 */
public class MainActivity extends BaseActivity {

  @BindString(R.string.linear_recyclerView) protected String linearString;
  @BindString(R.string.grid_recyclerView) protected String gridString;
  @BindString(R.string.staggered_recyclerView) protected String staggeredString;

  @NonNull @Bind(R.id.main_layout_linear_btn) protected Button linearButton;
  @NonNull @Bind(R.id.main_layout_grid_btn) protected Button gridButton;
  @NonNull @Bind(R.id.main_layout_staggered_btn) protected Button staggeredButton;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.linearButton.setText(linearString);
    this.gridButton.setText(gridString);
    this.staggeredButton.setText(staggeredString);
  }

  @NonNull @OnClick(R.id.main_layout_linear_btn) void onLinearClick() {
    LinearActivity.navigateToLinearActivity(MainActivity.this);
  }

  @NonNull @OnClick(R.id.main_layout_grid_btn) void onGridClick() {
    GridActivity.navigateToGridActivity(MainActivity.this);
  }

  @NonNull @OnClick(R.id.main_layout_staggered_btn) void onStaggeredClick() {
    StaggeredActivity.navigateToStaggeredActivity(MainActivity.this);
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
  }
}
