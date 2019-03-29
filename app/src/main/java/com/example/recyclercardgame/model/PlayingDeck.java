package com.example.recyclercardgame.model;

public class PlayingDeck extends Deck {
    public PlayingDeck(){
        super();
        for(String suit : PlayingCard.validSuits()){
            for (int rank = 1;rank <= PlayingCard.maxRank();rank++){
                PlayingCard card = new PlayingCard();
                card.setRank(rank);
                card.setSuit(suit);
                addCard(card);
            }
        }
    }
}
