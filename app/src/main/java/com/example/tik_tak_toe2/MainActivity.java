package com.example.tik_tak_toe2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {



    int myActivePlayer = 0;

    //setting 0 for cross and 1 for circle


    //my game state
    int[] myGameState ={2,2,2,2,2,2,2,2,2};

    public void imageTapped(View view) {
        ImageView myTapped = (ImageView) view;


        Log.i("tag is", "image number is" + myTapped.getTag().toString());
        int tappedimageTag= Integer.parseInt(myTapped.getTag().toString());
        if (myGameState[tappedimageTag] == 2) {
            myGameState[tappedimageTag] = myActivePlayer;

            if (myActivePlayer == 0) {
                ((ImageView) myTapped).setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 1;
            } else {
                myTapped.setImageResource(R.drawable.circle);
                myActivePlayer = 0;
            }

        }else {
            Log.i("msg", "this place is filled already");
        }

    }


    public void playAgain(View view){
      //  Log.i("msg","play again tapped");


        //change game state back to 2
        for (int i=0;i<myGameState.length;i++){
            myGameState[i]=2;
        }


        //make active player 0 again
        int myActivePlayer = 0;


        //change all images to ic_launcher
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.lineOne);
        for (int i=0;i< linearLayout.getChildCount();i++){
            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayoutOne=(LinearLayout) findViewById(R.id.lineTwo);
        for (int i=0;i< linearLayoutOne.getChildCount();i++){
            ((ImageView) linearLayoutOne.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayoutTwo=(LinearLayout) findViewById(R.id.lineThree);
        for (int i=0;i< linearLayoutTwo.getChildCount();i++){
            ((ImageView) linearLayoutTwo.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }




    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
