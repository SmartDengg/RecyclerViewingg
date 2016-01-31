package com.smartdengg.recyclerviewingg.activity.ItemAnimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Button;
import butterknife.Bind;
import butterknife.BindString;
import butterknife.OnClick;
import com.smartdengg.recyclerviewingg.BaseActivity;
import com.smartdengg.recyclerviewingg.R;

/**
 * Created by SmartDengg on 2016/1/29.
 */
public class ItemAnimatorActivity extends BaseActivity {

  @BindString(R.string.item_animator) protected String title;
  @BindString(R.string.handle_header) protected String headerString;
  @BindString(R.string.handle_footer) protected String footerString;

  @NonNull @Bind(R.id.itemanimator_layout_header_btn) protected Button headerBtn;
  @NonNull @Bind(R.id.itemanimator_layout_footer_btn) protected Button footerBtn;

  public static void navigateToItemAnimatorActivity(BaseActivity startingActivity) {
    startingActivity.startActivity(new Intent(startingActivity, ItemAnimatorActivity.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.itemanimator_navigate_layout);

    this.headerBtn.setText(headerString);
    this.footerBtn.setText(footerString);
  }

  @NonNull @OnClick(R.id.itemanimator_layout_header_btn) void onHeaderClick() {
    ItemAnimatorHeaderActivity.navigateToHeaderActivity(ItemAnimatorActivity.this);
  }

  @NonNull @OnClick(R.id.itemanimator_layout_footer_btn) void onFooterClick() {
    ItemAnimatorFooterActivity.navigateToFooterActivity(ItemAnimatorActivity.this);
  }

  @Override public void setupToolbar() {
    getSupportActionBar().setTitle(title);

    ItemAnimatorActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
    ItemAnimatorActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
  }
}
