package com.example.testing;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testing.Sql.DBHelper;
import com.example.testing.Sql.ItemModel;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<ItemModel> itemModalArrayList;
    private Context context;
    private OnClickListener onClickListener;


    // constructor
    public CourseRVAdapter(ArrayList<ItemModel> courseModalArrayList, Context context) {
        this.itemModalArrayList = courseModalArrayList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        ItemModel modal = itemModalArrayList.get(position);
        holder.itemCodeTV.setText(modal.getItemCode());
        holder.itemDesTV.setText(modal.getItemDes());
        holder.itemQuaTV.setText(modal.getItemQuan());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return itemModalArrayList.size();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, ItemModel model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView itemCodeTV, itemDesTV,itemQuaTV;

        public Button update;

        public ViewHolder(View itemView) {
            super(itemView);
            // initializing our text views
            itemCodeTV = itemView.findViewById(R.id.idTVItemCode);
            itemDesTV = itemView.findViewById(R.id.idTVItemDes);
            itemQuaTV = itemView.findViewById(R.id.idTVItemQuan);
            update =itemView.findViewById(R.id.updBtn);

            // Set the OnClickListener on the update button.
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (onClickListener != null) {
                        onClickListener.onClick(getAdapterPosition(), itemModalArrayList.get(getAdapterPosition()));
                    }
                }
            });
        }

    }

}