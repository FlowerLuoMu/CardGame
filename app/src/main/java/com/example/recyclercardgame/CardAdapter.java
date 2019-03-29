package com.example.recyclercardgame;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.recyclercardgame.model.Card;
import com.example.recyclercardgame.model.CardMatchingGame;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    private CardMatchingGame game;
    public CardAdapter(CardMatchingGame game) {
        this.game = game;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View button = new Button(viewGroup.getContext());
        ViewHolder viewHolder = new ViewHolder(button);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Card card = game.cardAtIndex(i);

        viewHolder.cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.chooseCardAtIndex(i);
                notifyDataSetChanged();
            }
        });
        viewHolder.cardButton.setAlpha(card.isMatched()?(float)0.5:1);
        if(card.isChosen()) {
            viewHolder.cardButton.setBackgroundResource(R.drawable.blankcard);
            viewHolder.cardButton.setText(card.getContents());
        }else {
            viewHolder.cardButton.setBackgroundResource(R.drawable.stanfordtree);
            viewHolder.cardButton.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return game.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         Button cardButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardButton = (Button) itemView;
        }
    }
}
