package com.smartdengg.recyclerviewingg.activity.grid;

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

  @BindString(R.string.grid_recyclerView) protected String title;
  @BindString(R.string.grid_recyclerView_standard) protected String standardString;
  @BindString(R.string.grid_recyclerView_auto_fix) protected String autoFixString;
  @BindString(R.string.grid_recyclerView_header) protected String headerString;

  @NonNull @Bind(R.id.grid_layout_standard_btn) protected Button standardBtn;
  @NonNull @Bind(R.id.grid_layout_auto_fix_btn) protected Button autoFixBtn;
  @NonNull @Bind(R.id.grid_layout_header_btn) protected Button headerBtn;

  public static void navigateToGridActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, GridActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.navigate_grid__layout);

    this.standardBtn.setText(standardString);
    this.autoFixBtn.setText(autoFixString);
    this.headerBtn.setText(headerString);
  }

  @NonNull @OnClick(R.id.grid_layout_standard_btn) void onStandardClick() {
    GridStandarOrHeaderdActivity.navigateToStandardOrHeaderActivity(GridActivity.this,
                                                                    GridStandarOrHeaderdActivity.STANDARD);
  }

  @NonNull @OnClick(R.id.grid_layout_auto_fix_btn) void onAutoFixClick() {
    GridAutoFixActivity.navigateToGridAutoFixActivity(GridActivity.this);
  }

  @NonNull @OnClick(R.id.grid_layout_header_btn) void onHeaderClick() {
    GridStandarOrHeaderdActivity.navigateToStandardOrHeaderActivity(GridActivity.this,
                                                                    GridStandarOrHeaderdActivity.HEADER);
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(title);

    GridActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    GridActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }
}
