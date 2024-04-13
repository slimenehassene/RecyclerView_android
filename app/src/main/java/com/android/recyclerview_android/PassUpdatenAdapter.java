package com.android.recyclerview_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PassUpdatenAdapter extends RecyclerView.Adapter<PassUpdatenAdapter.PassUpdatenViewHolder> {

    private List<Item> itemList;

    public ItemClickListener clickListener;


    public void setClickListener(ItemClickListener myListener){
        this.clickListener = myListener;
    }

    public void setFilteredList(List<Item> list){
        this.itemList = list;
        notifyDataSetChanged();
    }




    public PassUpdatenAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public PassUpdatenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // responsible for creating new view holders for your items

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recycler_view_item_layout,parent, false);



        return new PassUpdatenViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PassUpdatenViewHolder holder, int position) {
        // Binds the data from your dataset to the views within the view holder
        Item item = itemList.get(position);

        holder.name.setText(item.getName());
        holder.ausweisNr.setText(item.getAusweisNr());
    }

    @Override
    public int getItemCount() {
        // Returns the total number of items in your dataset
        return itemList.size();
    }





    public class PassUpdatenViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener  {
        // Holds references to the views within the item layout
        TextView name,ausweisNr;

        public PassUpdatenViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameRecyclerView);
            ausweisNr = itemView.findViewById(R.id.ausweisNrRecyclerView);

            itemView.setOnClickListener(this);





        }

        @Override
        public void onClick(View v) {
            if (clickListener != null){
                clickListener.onCLick(v,getAdapterPosition());
            }
        }
    }
}
