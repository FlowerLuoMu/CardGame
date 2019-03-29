package com.example.recyclercardgame;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.recyclercardgame.model.CardMatchingGame;

public class MainActivity extends AppCompatActivity {

    private CardMatchingGame game = new CardMatchingGame(52);
    CardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(layoutManager);

         adapter = new CardAdapter(game);
        recyclerView.setAdapter(adapter);
        TextView textView = findViewById(R.id.score);
        textView.setText("Score："+game.getScore()+"分");
    }
    public void reset(View v){
        game.reset();
        adapter.notifyDataSetChanged();
    }
}
