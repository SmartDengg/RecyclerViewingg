package com.smartdengg.recyclerviewingg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import com.smartdengg.recyclerviewingg.BaseActivity;
import com.smartdengg.recyclerviewingg.IconHelpler;
import com.smartdengg.recyclerviewingg.R;
import com.smartdengg.recyclerviewingg.adapter.DrawableAdapter;
import com.smartdengg.recyclerviewingg.decoration.MarginDecoration;

/**
 * Created by SmartDengg on 2016/1/29.
 */
public class GridStandardActivity extends BaseActivity {

  @NonNull @Bind(R.id.main_recycler_layout_rv) protected RecyclerView recyclerView;

  public static void navigateToStandardActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, GridStandardActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_recycler_layout);
    GridStandardActivity.this.initView();
  }

  private void initView() {

    GridLayoutManager gridLayoutManager = new GridLayoutManager(GridStandardActivity.this, 2);
    gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    gridLayoutManager.setSmoothScrollbarEnabled(true);

    recyclerView.addItemDecoration(new MarginDecoration(GridStandardActivity.this));
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(gridLayoutManager);
    recyclerView.setAdapter(
        DrawableAdapter.created(GridStandardActivity.this, IconHelpler.CAT_ICONS, DrawableAdapter.BLUE));
  }
}
