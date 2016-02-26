package com.smartdengg.recyclerviewingg.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.smartdengg.recyclerviewingg.R;
import java.util.List;

/**
 * Created by SmartDengg on 2016/1/30.
 */
public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {

  private Context context;
  private List<String> items;

  public static TextAdapter created(Context context, List<String> items) {
    return new TextAdapter(context, items);
  }

  private TextAdapter(Context context, List<String> items) {
    this.context = context;
    this.items = items;
  }



  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.text_item, parent, false));
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.textView.setText(items.get(position));
  }

  @Override public int getItemCount() {
    return (this.items != null) ? items.size() : 0;
  }

  public static final class ViewHolder extends RecyclerView.ViewHolder {

    @NonNull @Bind(R.id.text_item_tv) protected TextView textView;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(ViewHolder.this, itemView);
    }
  }
}
