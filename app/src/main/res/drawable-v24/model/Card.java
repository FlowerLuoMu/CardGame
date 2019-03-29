package com.example.cardgame_3.model;

public abstract class Card {
    private boolean chosen;
    private boolean matched;
    public abstract String getContents();
    public boolean isChosen(){
        return chosen;
    }
    public boolean isMatched() {
        return matched;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public int match(com.example.cardgame_3.model.Card[] otherCards){
        int score = 0;
        for (com.example.cardgame_3.model.Card card : otherCards) {
            if (card.getContents().equals(this)) {
                score = 1;
            }
        }
        return score;
    }
}
