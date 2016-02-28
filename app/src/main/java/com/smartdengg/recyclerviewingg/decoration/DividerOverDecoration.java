package com.smartdengg.recyclerviewingg.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import com.smartdengg.recyclerviewingg.R;

/**
 * 感谢http://stackoverflow.com/questions/24618829/how-to-add-dividers-and-spaces-
 * between-items-in-recyclerview/27037230#27037230
 */
public class DividerOverDecoration extends RecyclerView.ItemDecoration {

  private static final int[] ATTRS = new int[] { android.R.attr.listDivider };

  private Context context;
  private Drawable mDivider;

  public DividerOverDecoration(Context context) {
    this.context = context;

    TypedValue typedValue = new TypedValue();
    if (context.getTheme().resolveAttribute(android.R.attr.listDivider, typedValue, true)) {
      int dividerId = typedValue.resourceId;
      this.mDivider = context.getResources().getDrawable(dividerId);
    }
  }

  public DividerOverDecoration(Context context, int resId) {
    this.context = context;
    mDivider = ContextCompat.getDrawable(context, resId);
  }

  @Override public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

    int left = parent.getPaddingLeft() + context.getResources().getDimensionPixelOffset(R.dimen.material_24dp);
    int right = parent.getWidth() - parent.getPaddingRight() - context
        .getResources()
        .getDimensionPixelOffset(R.dimen.material_24dp);

    int childCount = parent.getChildCount();
    for (int i = 0; i < childCount; i++) {
      View child = parent.getChildAt(i);

      RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

      int top = child.getBottom() + params.bottomMargin;
      int bottom = top + mDivider.getIntrinsicHeight();

      mDivider.setBounds(left, top, right, bottom);
      mDivider.draw(c);
    }
  }
}