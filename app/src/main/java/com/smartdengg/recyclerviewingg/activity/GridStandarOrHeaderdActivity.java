package com.smartdengg.recyclerviewingg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import butterknife.BindString;
import com.smartdengg.recyclerviewingg.BaseActivity;
import com.smartdengg.recyclerviewingg.IconsHelper;
import com.smartdengg.recyclerviewingg.R;
import com.smartdengg.recyclerviewingg.adapter.DrawableAdapter;
import com.smartdengg.recyclerviewingg.decoration.MarginDecoration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by SmartDengg on 2016/1/29.
 */
public class GridStandarOrHeaderdActivity extends BaseActivity {

  @BindString(R.string.grid_recyclerView_header) protected String title;

  private static final String TYPE = "TYPE";

  public static final int STANDARD = 1;
  public static final int HEADER = 2;

  @Retention(RetentionPolicy.SOURCE) @IntDef({ STANDARD, HEADER }) private @interface TYPE {}

  @NonNull @BindString(R.string.grid_recyclerView_standard) protected String standardTitle;
  @NonNull @BindString(R.string.grid_recyclerView_header) protected String HeaderTitle;

  @NonNull @Bind(R.id.main_recycler_layout_rv) protected RecyclerView recyclerView;

  public static void navigateToStandardOrHeaderActivity(BaseActivity startingActivity, @TYPE int type) {
    Intent intent = new Intent(startingActivity, GridStandarOrHeaderdActivity.class);
    intent.putExtra(TYPE, type);

    startingActivity.startActivity(intent);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_recycler_layout);

    int type = getIntent().getIntExtra(TYPE, STANDARD);
    GridStandarOrHeaderdActivity.this.initView(type);

    getSupportActionBar().setTitle(type == STANDARD ? standardTitle : HeaderTitle);
  }

  private void initView(int type) {

    final GridLayoutManager gridLayoutManager = new GridLayoutManager(GridStandarOrHeaderdActivity.this, 2);
    gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    gridLayoutManager.setSmoothScrollbarEnabled(true);

    recyclerView.addItemDecoration(new MarginDecoration(GridStandarOrHeaderdActivity.this));
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(gridLayoutManager);
    final DrawableAdapter drawableAdapter =
        DrawableAdapter.created(GridStandarOrHeaderdActivity.this, IconsHelper.BEE_ICONS, DrawableAdapter.BLUE);

    if (type == HEADER) {
      gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
        @Override public int getSpanSize(int position) {
          return drawableAdapter.isHeader(position) ? gridLayoutManager.getSpanCount() : 1;
        }
      });
    }

    recyclerView.setAdapter(drawableAdapter);
  }

  @Override public void setupToolbar() {

    GridStandarOrHeaderdActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    GridStandarOrHeaderdActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }
}
