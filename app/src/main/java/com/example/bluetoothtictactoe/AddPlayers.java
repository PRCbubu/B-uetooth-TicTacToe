package com.example.bluetoothtictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);


        EditText player1 = (EditText) findViewById(R.id.InputName1);
        EditText player2 = (EditText) findViewById(R.id.InputName2);

        Button SinglePlayerButton = (Button) findViewById(R.id.SinglePlayerButton);
        Button MultiPlayerButton = (Button) findViewById(R.id.MultiPlayerButton);
        Button StartSinglePlayerButton = (Button) findViewById(R.id.StartSinglePlayerButton);

        MultiPlayerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent;
                String PlayerName1 = player1.getText().toString();

                if(PlayerName1.isEmpty())
                    Toast.makeText(getApplicationContext(), "Please enter the name", Toast.LENGTH_SHORT).show();
                else
                {
                    intent = new Intent(AddPlayers.this,BluetoothConnection.class);
                    intent.putExtra("NameSet1", PlayerName1);
                    startActivity(intent);
                }
            }
        });

        SinglePlayerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(SinglePlayerButton.isPressed())
                {
                    view.animate().translationY(view.getHeight()).alpha(1).setDuration(1000).setListener(new AnimatorListenerAdapter()
                    {
                        @Override
                        public void onAnimationEnd(Animator animation)
                        {
                            Intent intent;
                            super.onAnimationEnd(animation);

                            SinglePlayerButton.setVisibility(View.GONE);
                            player2.setVisibility(View.VISIBLE);
                            StartSinglePlayerButton.setVisibility(View.VISIBLE);

                            String PlayerName1 = player1.getText().toString();
                            String PlayerName2 = player2.getText().toString();

                            if(PlayerName1.isEmpty() || PlayerName2.isEmpty())
                                Toast.makeText(getApplicationContext(), "Please enter the names", Toast.LENGTH_SHORT).show();
                            else
                            {
                                intent = new Intent(AddPlayers.this,MainActivity.class);
                                intent.putExtra("NameSet1", PlayerName1);
                                intent.putExtra("NameSet2", PlayerName2);
                                startActivity(intent);

                            }
                        }
                    });
                }
            }
        });
    }
}