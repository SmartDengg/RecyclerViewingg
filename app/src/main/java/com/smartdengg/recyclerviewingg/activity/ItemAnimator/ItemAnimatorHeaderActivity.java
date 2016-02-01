package com.smartdengg.recyclerviewingg.activity.ItemAnimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import butterknife.Bind;
import butterknife.BindString;
import com.smartdengg.recyclerviewingg.BaseActivity;
import com.smartdengg.recyclerviewingg.IconsHelper;
import com.smartdengg.recyclerviewingg.R;
import com.smartdengg.recyclerviewingg.adapter.AnimatorAdapter;
import com.smartdengg.recyclerviewingg.decoration.MarginDecoration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SmartDengg on 2016/1/29.
 */
public class ItemAnimatorHeaderActivity extends BaseActivity {

  @NonNull @BindString(R.string.handle_header) protected String title;
  @NonNull @Bind(R.id.main_recycler_layout_rv) protected RecyclerView recyclerView;

  private AnimatorAdapter animatorAdapter;

  public static void navigateToHeaderActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, ItemAnimatorHeaderActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_recycler_layout);
    ItemAnimatorHeaderActivity.this.initView();
  }

  private void initView() {

    LinearLayoutManager layoutManager = new LinearLayoutManager(ItemAnimatorHeaderActivity.this) {
      @Override public boolean supportsPredictiveItemAnimations() {
        return true;
      }
    };
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    layoutManager.setSmoothScrollbarEnabled(true);

    recyclerView.addItemDecoration(new MarginDecoration(ItemAnimatorHeaderActivity.this));
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());

    List<Integer> items = new ArrayList<>();
    items.addAll(IconsHelper.CAT_ICONS);
    animatorAdapter = AnimatorAdapter.created(ItemAnimatorHeaderActivity.this, items, AnimatorAdapter.HEADER);

    recyclerView.setAdapter(animatorAdapter);
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(title);

    ItemAnimatorHeaderActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    ItemAnimatorHeaderActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.menu_item, menu);

    MenuItem searchItem = menu.findItem(R.id.action_inbox_1);
    searchItem.setActionView(R.layout.menu_inbox_btn_item);
    ImageButton searchButton = (ImageButton) searchItem.getActionView().findViewById(R.id.action_inbox_btn);
    searchButton.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_add));
    searchItem.getActionView().setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        if (animatorAdapter != null) {
          animatorAdapter.addItem();
          recyclerView.scrollToPosition(0);
        }
      }
    });

    MenuItem trolleyItem = menu.findItem(R.id.action_inbox_2);
    trolleyItem.setActionView(R.layout.menu_inbox_btn_item);
    ImageButton trolleyButton = (ImageButton) trolleyItem.getActionView().findViewById(R.id.action_inbox_btn);
    trolleyButton.setImageDrawable(getResources().getDrawable(R.drawable.icon_minus));
    trolleyItem.getActionView().setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        if (animatorAdapter != null) {
          animatorAdapter.removeItem();
          recyclerView.scrollToPosition(0);
        }
      }
    });
    return true;
  }
}
