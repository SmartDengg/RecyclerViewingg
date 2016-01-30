package com.smartdengg.recyclerviewingg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import butterknife.BindString;
import com.smartdengg.recyclerviewingg.BaseActivity;
import com.smartdengg.recyclerviewingg.R;
import com.smartdengg.recyclerviewingg.adapter.TextAdapter;
import com.smartdengg.recyclerviewingg.decoration.DividerDecoration;
import com.smartdengg.recyclerviewingg.decoration.DividerOverDecoration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/**
 * Created by SmartDengg on 2016/1/30.
 */
public class DecorationActivityyyy extends BaseActivity {

  @BindString(R.string.decoration_recyclerView_standard) protected String standardString;
  @BindString(R.string.decoration_recyclerView_over) protected String overString;

  private static final String TYPE = "TYPE";
  protected static final int STANDARD_DRAW = 1;
  protected static final int OVER_DRAW = 2;

  @Retention(RetentionPolicy.SOURCE) @IntDef({ STANDARD_DRAW, OVER_DRAW }) public @interface DecorationType {}

  @NonNull @Bind(R.id.main_recycler_layout_rv) protected RecyclerView recyclerView;

  public static void navigateToDecorationActivityyyy(BaseActivity startingActivity, @DecorationType int type) {

    Intent intent = new Intent(startingActivity, DecorationActivityyyy.class);
    intent.putExtra(TYPE, type);
    startingActivity.startActivity(intent);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_recycler_layout);

    Integer decorationType = getIntent().getIntExtra(TYPE, 1);
    DecorationActivityyyy.this.initView(decorationType);

    getSupportActionBar().setTitle(decorationType == STANDARD_DRAW ? standardString : overString);
  }

  private void initView(int type) {

    LinearLayoutManager layoutManager = new LinearLayoutManager(DecorationActivityyyy.this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    layoutManager.setSmoothScrollbarEnabled(true);

    recyclerView.addItemDecoration((type == STANDARD_DRAW) ? new DividerDecoration(DecorationActivityyyy.this)
                                                           : new DividerOverDecoration(DecorationActivityyyy.this));
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(TextAdapter.created(DecorationActivityyyy.this, Arrays.asList(
        getResources().getStringArray(R.array.smart_description))));
  }

  @Override public void setupToolbar() {

    DecorationActivityyyy.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    DecorationActivityyyy.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }
}
