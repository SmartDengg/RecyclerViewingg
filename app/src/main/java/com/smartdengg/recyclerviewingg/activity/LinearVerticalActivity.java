package com.smartdengg.recyclerviewingg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import com.smartdengg.recyclerviewingg.BaseActivity;
import com.smartdengg.recyclerviewingg.IconHelper;
import com.smartdengg.recyclerviewingg.R;
import com.smartdengg.recyclerviewingg.adapter.DrawableAdapter;
import com.smartdengg.recyclerviewingg.decoration.MarginDecoration;

/**
 * Created by SmartDengg on 2016/1/29.
 */
public class LinearVerticalActivity extends BaseActivity {

  @NonNull @Bind(R.id.main_recycler_layout_rv) protected RecyclerView recyclerView;

  public static void navigateToVerticalActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, LinearVerticalActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_recycler_layout);
    LinearVerticalActivity.this.initView();
  }

  private void initView() {

    LinearLayoutManager layoutManager = new LinearLayoutManager(LinearVerticalActivity.this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    layoutManager.setSmoothScrollbarEnabled(true);

    recyclerView.addItemDecoration(new MarginDecoration(LinearVerticalActivity.this));
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(
        DrawableAdapter.created(LinearVerticalActivity.this, IconHelper.ICONS, DrawableAdapter.ORANGE));
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(getResources().getString(R.string.linear_recyclerView_vertical));

    LinearVerticalActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    LinearVerticalActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }
}
