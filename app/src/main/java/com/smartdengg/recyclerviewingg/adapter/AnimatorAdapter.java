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
import com.smartdengg.recyclerviewingg.IconsHelper;
import com.smartdengg.recyclerviewingg.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Created by SmartDengg on 2016/1/29.
 */
public class AnimatorAdapter extends RecyclerView.Adapter<AnimatorAdapter.ViewHolder> {

  public static final int HEADER = 1;
  public static final int FOOTER = 2;

  @Retention(RetentionPolicy.SOURCE) @IntDef({ HEADER, FOOTER }) private @interface TYPE {}

  private Context context;
  private List<Integer> items;
  private int type;

  public static AnimatorAdapter created(Context context, List<Integer> items, @TYPE int type) {
    return new AnimatorAdapter(context, items, type);
  }

  private AnimatorAdapter(Context context, List<Integer> items, int type) {
    this.context = context;
    this.items = items;
    this.type = type;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    if (this.type == HEADER) {
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

  public void addItem() {

    if (this.type == HEADER) {

      this.items.add(0, IconsHelper.getRandomCatIcon());
      AnimatorAdapter.this.notifyItemInserted(0);
    } else if (this.type == FOOTER) {

      this.items.add(items.size(), IconsHelper.getRandomCatIcon());
      AnimatorAdapter.this.notifyItemInserted(items.size());
    }
  }

  public void removeItem() {

    if (this.items.size() > 0) {

      if (this.type == HEADER) {

        this.items.remove(0);
        AnimatorAdapter.this.notifyItemRemoved(0);
      } else if (this.type == FOOTER) {

        this.items.remove(this.items.size() - 1);
        AnimatorAdapter.this.notifyItemRemoved(this.items.size());
      }
    }
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @NonNull @Bind(R.id.drawable_card_item_iv) protected ImageView bitmapIv;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(ViewHolder.this, itemView);
    }
  }
}
