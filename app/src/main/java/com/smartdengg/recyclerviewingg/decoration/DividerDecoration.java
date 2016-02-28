package com.smartdengg.recyclerviewingg.decoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.smartdengg.recyclerviewingg.R;

/**
 * 感谢http://stackoverflow.com/questions/24618829/how-to-add-dividers-and-spaces-between-items-in-recyclerview/27037230#27037230
 */
public class DividerDecoration extends RecyclerView.ItemDecoration {

  private static final int[] ATTRS = new int[] { android.R.attr.listDivider };

  private Context context;
  private Drawable mDivider;

  public DividerDecoration(Context context) {
    this.context = context;

    TypedArray styledAttributes = null;
    try {
      styledAttributes = context.obtainStyledAttributes(ATTRS);
      mDivider = styledAttributes.getDrawable(0);
    } finally {
      if (styledAttributes != null) {
        styledAttributes.recycle();
      }
    }
  }

  public DividerDecoration(Context context, int resId) {
    this.context = context;
    mDivider = ContextCompat.getDrawable(context, resId);
  }

  @Override public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

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

  @Override public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    outRect.set(0, 0, 0, 0);
  }
}