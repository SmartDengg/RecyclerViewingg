package com.smartdengg.recyclerviewingg.activity.linear;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import butterknife.BindString;
import com.smartdengg.recyclerviewingg.BaseActivity;
import com.smartdengg.recyclerviewingg.IconsHelper;
import com.smartdengg.recyclerviewingg.R;
import com.smartdengg.recyclerviewingg.adapter.DrawableAdapter;
import com.smartdengg.recyclerviewingg.decoration.MarginDecoration;

/**
 * Created by SmartDengg on 2016/1/29.
 */
public class LinearHorizontalActivity extends BaseActivity {

  @NonNull @BindString(R.string.linear_recyclerView_horizontal) protected String title;

  @NonNull @Bind(R.id.main_recycler_layout_rv) protected RecyclerView recyclerView;

  public static void navigateToHorizontalActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, LinearHorizontalActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recycler_main_layout);
    LinearHorizontalActivity.this.initView();
  }

  private void initView() {

    LinearLayoutManager layoutManager = new LinearLayoutManager(LinearHorizontalActivity.this);
    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
    layoutManager.setSmoothScrollbarEnabled(true);

    recyclerView.addItemDecoration(new MarginDecoration(LinearHorizontalActivity.this));
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(
        DrawableAdapter.created(LinearHorizontalActivity.this, IconsHelper.ICONS, DrawableAdapter.ORANGE));
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(title);

    LinearHorizontalActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    LinearHorizontalActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }
}
