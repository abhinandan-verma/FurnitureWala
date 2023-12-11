package com.example.furniturewala;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewModel> {
    private final ArrayList<DataModel> dataSet;
    private final Context context;

    public CustomAdapter2(ArrayList<DataModel> dataSet, Context context) {
        this.dataSet = dataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter2.MyViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cardview_s,parent,false);


        return new MyViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter2.MyViewModel holder, int position) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageViewIcon = holder.imageViewIcon;

        //Adding the TextView
        textViewName.setText(dataSet.get(position).getName());
        textViewVersion.setText(dataSet.get(position).getVersion());

        //ImageView with Glide
        Glide.with(context)
                .load(dataSet.get(position).getImage())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(10)))
                .into(imageViewIcon);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewModel extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;
        public MyViewModel(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewVersion = itemView.findViewById(R.id.textViewVersion);
            imageViewIcon = itemView.findViewById(R.id.imageView);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
