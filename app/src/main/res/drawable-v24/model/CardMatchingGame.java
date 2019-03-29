package com.example.cardgame_3.model;

import java.util.ArrayList;

public class CardMatchingGame {
    private ArrayList<com.example.cardgame_3.model.Card> cards;

    private int count = 0;
    private int score = 0;

    public CardMatchingGame(int count){
        this.count = count;
        com.example.cardgame_3.model.Deck deck = new PlayingDeck();
        cards = new ArrayList<com.example.cardgame_3.model.Card>();
        for (int i=0;i<count;i++){
            com.example.cardgame_3.model.Card card = deck.drawRandomCard();
            if (card != null){
                cards.add(card);
            }
        }
    }

    public CardMatchingGame() {
    }

    public void reset(){
        com.example.cardgame_3.model.Deck deck = new PlayingDeck();
        cards = new ArrayList<com.example.cardgame_3.model.Card>();
        for (int i=0;i<count;i++){
            com.example.cardgame_3.model.Card card = deck.drawRandomCard();
            if (card != null){
                cards.add(card);
            }
        }
    }
    public com.example.cardgame_3.model.Card cardAtIndex(int index){
        return (index < cards.size()) ? cards.get(index) : null;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    final int MISMATCH_PENALTY = 2;
    final int MATCH_BONUS = 4;
    final int COST_TO_CHOOSE = 1;

    public void chooseCardAtIndex(int index) {
        com.example.cardgame_3.model.Card card = cardAtIndex(index);
        if(!card.isMatched()){
            if(card.isChosen()){
                card.setChosen(false);
            }else{
                for (com.example.cardgame_3.model.Card otherCard : cards) {
                    if(otherCard.isChosen() && !otherCard.isMatched()) {
                        int matchScore = card.match(new com.example.cardgame_3.model.Card[] {otherCard});
                        if(matchScore > 0) {
                            score += matchScore * MATCH_BONUS;
                            otherCard.setMatched(true);
                            card.setMatched(true);
                        }else {
                            score -= MISMATCH_PENALTY;
                            otherCard.setChosen(false);
                        }
                        break;
                    }
                }
                score -= COST_TO_CHOOSE;
                card.setChosen(true);
            }
        }
    }
}
