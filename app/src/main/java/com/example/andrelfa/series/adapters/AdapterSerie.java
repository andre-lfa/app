package com.example.andrelfa.series.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.andrelfa.series.GameOfThronesActivity;
import com.example.andrelfa.series.MrRobotActivity;
import com.example.andrelfa.series.R;
import com.example.andrelfa.series.RickAndMortyActivity;
import com.example.andrelfa.series.ThisIsUsActivity;

/**
 * Created by Android on 14/11/2017.
 */

public class AdapterSerie extends RecyclerView.Adapter<AdapterSerie.ViewHolder> {


    int img[] = {R.drawable.game_of_thrones, R.drawable.mr_robot, R.drawable.rick_and_morty, R.drawable.this_is_us};

    @Override
    public AdapterSerie.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_serie, parent, false);
        return new ViewHolder(view);
    }

    public AdapterSerie(){
        super();
    }

    @Override
    public void onBindViewHolder(AdapterSerie.ViewHolder holder, int position){
        holder.ivImagem.setImageResource((img[position]));

    }

    @Override
    public int getItemCount(){
        return img.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView ivImagem;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImagem = (ImageView) itemView.findViewById(R.id.imagem_serie);
            ivImagem.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int posit = getPosition();
            Intent myIntent = new Intent();
            switch (posit){
                case 0:
                    myIntent = new Intent(view.getContext(), GameOfThronesActivity.class);
                    view.getContext().startActivity(myIntent);
                    break;
                case 1:
                    myIntent = new Intent(view.getContext(), MrRobotActivity.class);
                    view.getContext().startActivity(myIntent);
                    break;
                case 2:
                    myIntent = new Intent(view.getContext(), RickAndMortyActivity.class);
                    view.getContext().startActivity(myIntent);
                    break;
                case 3:
                    myIntent = new Intent(view.getContext(), ThisIsUsActivity.class);
                    view.getContext().startActivity(myIntent);
                    break;
            }
        }


    }
}

