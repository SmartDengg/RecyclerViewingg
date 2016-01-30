package com.smartdengg.recyclerviewingg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
public class GridAutoFixActivity extends BaseActivity {

  @NonNull @Bind(R.id.autofix_recycler_layout_rv) protected RecyclerView recyclerView;

  public static void navigateToGridAutoFixActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, GridAutoFixActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.autofix_recycler_layout);
    GridAutoFixActivity.this.initView();
  }

  private void initView() {

    recyclerView.addItemDecoration(new MarginDecoration(GridAutoFixActivity.this));
    recyclerView.setHasFixedSize(true);
    recyclerView.setAdapter(
        DrawableAdapter.created(GridAutoFixActivity.this, IconHelper.CAT_ICONS, DrawableAdapter.BLUE));
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(getResources().getString(R.string.grid_recyclerView_auto_fix));

    GridAutoFixActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    GridAutoFixActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }
}
