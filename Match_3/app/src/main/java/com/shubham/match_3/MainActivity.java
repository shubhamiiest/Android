package com.shubham.match_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0 for yellow and 1 for red
    int active_player = 0;
    //2 means unplayed
    int state[] = {2,2,2,2,2,2,2,2,2};
   //winning positions
    int winning_positions[][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    //active state of game
    boolean gameisactive = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void click(View v) {
        ImageView im = (ImageView) v;

        int clicked_image = Integer.parseInt(im.getTag().toString());

        if (state[clicked_image] == 2 && gameisactive) {
            state[clicked_image] = active_player;
            im.setTranslationY(-1000f);
            if (active_player == 0) {
                im.setImageResource(R.drawable.yellow);
                active_player = 1;
            } else {
                im.setImageResource(R.drawable.red);
                active_player = 0;
            }
            im.animate().translationYBy(1000f).rotation(3600).setDuration(300);
        }

        for (int winning_postion[] : winning_positions)
        {
            if(state[winning_postion[0]] == state[winning_postion[1]] && state[winning_postion[1]] == state[winning_postion[2]] &&
                    state[winning_postion[0]] != 2)
            {
                String winner = "Red";
                gameisactive = false;
               if(state[winning_postion[0]] == 0){
                   // Toast.makeText(MainActivity.this,"Yellow User has won",Toast.LENGTH_LONG).show();
                   winner = "Yellow";
                }
                TextView t = (TextView)findViewById(R.id.WinnerMessage);
                t.setText( winner + " User Won !");
                LinearLayout l = (LinearLayout)findViewById(R.id.playagainlayout);
                l.setVisibility(View.VISIBLE);


            }
            else{
                boolean gameisover = true;
                for(int i : state){
                    if(i == 2) gameisover = false;
                }
                if(gameisover){
                    TextView t = (TextView)findViewById(R.id.WinnerMessage);
                    t.setText( "Match Drawn");
                    LinearLayout l = (LinearLayout)findViewById(R.id.playagainlayout);
                    l.setVisibility(View.VISIBLE);
                }
            }
        }

    }
    public void playagain(View v){
        gameisactive = true;
        LinearLayout l = (LinearLayout)findViewById(R.id.playagainlayout);
        l.setVisibility(View.INVISIBLE);
        active_player = 0;
        for(int i = 0 ; i<state.length ; i++){
            state[i] = 2 ;
        }
        GridLayout gl = (GridLayout)findViewById(R.id.gridlayout);
        for(int j = 0; j< gl.getChildCount() ; j++){
            ((ImageView)gl.getChildAt(j)).setImageResource(0);
        }
    }
}
