package com.smartdengg.recyclerviewingg.adapter;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.smartdengg.recyclerviewingg.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Created by SmartDengg on 2016/1/29.
 */
public class DrawableAdapter extends RecyclerView.Adapter<DrawableAdapter.ViewHolder> {

  public static final int ORANGE = 1;
  public static final int BLUE = 2;
  public static final int PURPLE = 3;

  @Retention(RetentionPolicy.SOURCE) @IntDef({ ORANGE, BLUE, PURPLE }) private @interface TYPE {}

  private Context context;
  private List<Integer> items;
  private int type;

  public static DrawableAdapter created(Context context, List<Integer> items, @TYPE int type) {
    return new DrawableAdapter(context, items, type);
  }

  private DrawableAdapter(Context context, List<Integer> items, @TYPE int type) {
    this.context = context;
    this.items = items;
    this.type = type;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    if (type == ORANGE) {
      return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.drawable_card_orange_item, parent, false));
    }
    if (type == BLUE) {
      return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.drawable_card_bule_item, parent, false));
    }
    return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.drawable_card_purple_item, parent, false));
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.bitmapIv.setImageDrawable(context.getResources().getDrawable(items.get(position)));
  }

  @Override public int getItemCount() {
    return (this.items != null) ? items.size() : 0;
  }

  public boolean isHeader(int position) {
    return position == 0;
  }

  public void updateItems(List<Integer> items) {
    this.items = items;
    DrawableAdapter.this.notifyDataSetChanged();
  }

  public static final class ViewHolder extends RecyclerView.ViewHolder {

    @NonNull @Bind(R.id.drawable_card_item_iv) protected ImageView bitmapIv;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(ViewHolder.this, itemView);
    }
  }
}
