package com.example.rebelbob11.recyclerviewpractice.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rebelbob11.recyclerviewpractice.POJO.Hero;
import com.example.rebelbob11.recyclerviewpractice.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MarvelAdapter extends RecyclerView.Adapter<MarvelAdapter.ViewHolder> {

    private List<Hero> heros ;
    private Context context;

    public MarvelAdapter(List<Hero> heros, Context context) {
        this.heros = heros;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //Create view, inflate and return it
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        //Binding data
    Hero hero = heros.get(position);


    viewHolder.nameView.setText(hero.getName());
    viewHolder.realNameView.setText(hero.getRealname());

        Picasso.get().load(hero.getImageurl()).resize(150,150).centerCrop().into(viewHolder.heroImage);


    }

    @Override
    public int getItemCount() {

        //return size


        return heros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //Declare the views in list item\\

        TextView nameView, realNameView;
        ImageView heroImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //cast them here
            nameView = itemView.findViewById(R.id.textName);
            realNameView = itemView.findViewById(R.id.textRealName);
            heroImage = itemView.findViewById(R.id.hero_image);
        }
    }
}
