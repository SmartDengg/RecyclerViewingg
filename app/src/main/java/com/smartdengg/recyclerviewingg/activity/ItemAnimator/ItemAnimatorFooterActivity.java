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
public class ItemAnimatorFooterActivity extends BaseActivity {

  @NonNull @BindString(R.string.handle_footer) protected String title;
  @NonNull @Bind(R.id.main_recycler_layout_rv) protected RecyclerView recyclerView;

  private AnimatorAdapter animatorAdapter;

  public static void navigateToFooterActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, ItemAnimatorFooterActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_recycler_layout);
    ItemAnimatorFooterActivity.this.initView();
  }

  private void initView() {

    LinearLayoutManager layoutManager = new LinearLayoutManager(ItemAnimatorFooterActivity.this) {
      @Override public boolean supportsPredictiveItemAnimations() {
        return true;
      }
    };
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    layoutManager.setSmoothScrollbarEnabled(true);

    recyclerView.addItemDecoration(new MarginDecoration(ItemAnimatorFooterActivity.this));
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());

    List<Integer> items = new ArrayList<>();
    items.addAll(IconsHelper.CAT_ICONS);
    animatorAdapter = AnimatorAdapter.created(ItemAnimatorFooterActivity.this, items, AnimatorAdapter.FOOTER);

    recyclerView.setAdapter(animatorAdapter);
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(title);

    ItemAnimatorFooterActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    ItemAnimatorFooterActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
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
          recyclerView.scrollToPosition(animatorAdapter.getItemCount() - 1);
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
          recyclerView.scrollToPosition((animatorAdapter.getItemCount() != 0) ? animatorAdapter.getItemCount() - 1 : 0);
        }
      }
    });
    return true;
  }
}
