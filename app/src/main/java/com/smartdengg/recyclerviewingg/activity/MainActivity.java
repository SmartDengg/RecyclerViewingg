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
import com.smartdengg.recyclerviewingg.activity.ItemAnimator.ItemAnimatorActivity;
import com.smartdengg.recyclerviewingg.activity.decoration.DecorationActivity;
import com.smartdengg.recyclerviewingg.activity.grid.GridActivity;
import com.smartdengg.recyclerviewingg.activity.linear.LinearActivity;
import com.smartdengg.recyclerviewingg.activity.staggered.StaggeredActivity;
import com.smartdengg.recyclerviewingg.activity.swipe.SwipeRefreshActivity;

/**
 * Created by SmartDengg on 2016/1/28.
 */
public class MainActivity extends BaseActivity {

  @BindString(R.string.app_name) protected String title;
  @BindString(R.string.linear_recyclerView) protected String linearString;
  @BindString(R.string.grid_recyclerView) protected String gridString;
  @BindString(R.string.staggered_recyclerView) protected String staggeredString;
  @BindString(R.string.decoration_recyclerView) protected String decorationString;
  @BindString(R.string.item_animator) protected String animatorString;
  @BindString(R.string.swipe_recyclerView) protected String swipeString;

  @NonNull @Bind(R.id.main_layout_linear_btn) protected Button linearButton;
  @NonNull @Bind(R.id.main_layout_grid_btn) protected Button gridButton;
  @NonNull @Bind(R.id.main_layout_staggered_btn) protected Button staggeredButton;
  @NonNull @Bind(R.id.main_layout_decoration_btn) protected Button decorationButton;
  @NonNull @Bind(R.id.main_layout_animator_btn) protected Button animatorButton;
  @NonNull @Bind(R.id.main_layout_swipe_btn) protected Button swipeButton;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.navigate_main_layout);

    this.linearButton.setText(linearString);
    this.gridButton.setText(gridString);
    this.staggeredButton.setText(staggeredString);
    this.decorationButton.setText(decorationString);
    this.decorationButton.setText(decorationString);
    this.animatorButton.setText(animatorString);
    this.swipeButton.setText(swipeString);
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

  @NonNull @OnClick(R.id.main_layout_decoration_btn) void onDecorationClick() {
    DecorationActivity.navigateToDecorationActivity(MainActivity.this);
  }

  @NonNull @OnClick(R.id.main_layout_animator_btn) void onAnimatorClick() {
    ItemAnimatorActivity.navigateToItemAnimatorActivity(MainActivity.this);
  }

  @NonNull @OnClick(R.id.main_layout_swipe_btn) void onSwipClick() {
    SwipeRefreshActivity.navigateToSwipeRefreshActivity(MainActivity.this);
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(title);
  }
}
