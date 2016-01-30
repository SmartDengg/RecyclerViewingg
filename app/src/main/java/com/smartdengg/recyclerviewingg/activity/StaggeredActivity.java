package com.smartdengg.recyclerviewingg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import butterknife.Bind;
import butterknife.BindString;
import com.smartdengg.recyclerviewingg.BaseActivity;
import com.smartdengg.recyclerviewingg.IconHelper;
import com.smartdengg.recyclerviewingg.R;
import com.smartdengg.recyclerviewingg.adapter.DrawableAdapter;
import com.smartdengg.recyclerviewingg.decoration.MarginDecoration;

/**
 * Created by Joker on 2016/1/29.
 */
public class StaggeredActivity extends BaseActivity {

  @NonNull @Bind(R.id.main_recycler_layout_rv) protected RecyclerView recyclerView;
  @BindString(R.string.staggered_recyclerView) protected String staggeredString;

  public static void navigateToStaggeredActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, StaggeredActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_recycler_layout);
    StaggeredActivity.this.initView();
  }

  private void initView() {

    StaggeredGridLayoutManager staggeredGridLayoutManager =
        new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

    recyclerView.addItemDecoration(new MarginDecoration(StaggeredActivity.this));
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(staggeredGridLayoutManager);
    recyclerView.setAdapter(
        DrawableAdapter.created(StaggeredActivity.this, IconHelper.ALL_ICONS, DrawableAdapter.PURPLE));
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(staggeredString);

    StaggeredActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    StaggeredActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }
}
