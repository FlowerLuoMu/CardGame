package com.example.cardgame_3.model;

public class PlayingDeck extends com.example.cardgame_3.model.Deck {
    public PlayingDeck(){
        super();
        for(String suit : com.example.cardgame_3.model.PlayingCard.validSuits()){
            for (int rank = 1; rank <= com.example.cardgame_3.model.PlayingCard.maxRank(); rank++){
                com.example.cardgame_3.model.PlayingCard card = new com.example.cardgame_3.model.PlayingCard();
                card.setRank(rank);
                card.setSuit(suit);
                addCard(card);
            }
        }
    }
}
