package com.example.cardgame_3.model;

import java.util.Arrays;

public class PlayingCard extends Card {
    private String suit;
    private int rank;

    public String getSuit() {
        return suit;
    }
    public void setSuit(String aSuit) {
        if(Arrays.asList(com.example.cardgame_3.model.PlayingCard.validSuits()).contains(aSuit)){
            suit = aSuit;
        }
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int aRank) {
        if(aRank <= com.example.cardgame_3.model.PlayingCard.maxRank()) {
            rank = aRank;
        }
    }
    public static String[] validSuits(){
        return new String[]{"♥","♦","♠","♣"};
    }
    private static String[] rankStrings() {
        return new String[]{"?","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    }
    static int maxRank() {
        return  com.example.cardgame_3.model.PlayingCard.rankStrings().length-1;
    }
    @Override
    public int match(Card[] otherCards) {
        int score = 0;
        if(otherCards.length == 1) {
            com.example.cardgame_3.model.PlayingCard otherCard = (com.example.cardgame_3.model.PlayingCard) otherCards[0];
            if (otherCard.getRank() == this.getRank()) {
                score = 4;
            }else if(otherCard.getSuit().equals(this.getSuit())){
                score = 1;
            }
        }
        return  score;
    }
    @Override
    public String getContents(){
        return com.example.cardgame_3.model.PlayingCard.rankStrings()[rank] + suit;
    }
}

