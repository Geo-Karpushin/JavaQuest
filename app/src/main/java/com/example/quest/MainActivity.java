package com.example.quest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    public static Character player;
    Button[] choices = new Button[3];
    TextView console, K, C, Rn, Rz;
    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choices[0] = findViewById(R.id.ch1);
        choices[1] = findViewById(R.id.ch2);
        choices[2] = findViewById(R.id.ch3);
        K = findViewById(R.id.K);
        C = findViewById(R.id.C);
        Rn = findViewById(R.id.Rn);
        Rz = findViewById(R.id.Rz);
        for (Button b : choices) {
            b.setOnClickListener(this);
        }
        console = findViewById(R.id.Console);

        player = new Character("Виталий");
        story = new Story(this);
        console.setText(story.current_situation.subject + "\n" + story.current_situation.text);

        Speaker();
    }

    @Override
    public void onClick(View v) {
        int choice = 0;
        System.out.println(v.getId());
        switch (v.getId()) {
            case (R.id.ch1):
                choice = 1;
                break;
            case (R.id.ch2):
                choice = 2;
                break;
            case (R.id.ch3):
                choice = 3;
                break;
        }
        if (story.isEnd()) {
            console.setText("==========Конец игры==========");
            return;
        }
        story.go(choice);
        console.setText(story.current_situation.subject + "\n" + story.current_situation.text);
        Speaker();
    }

    public void Speaker()
    {
        choices[0].setVisibility(View.INVISIBLE);
        choices[1].setVisibility(View.INVISIBLE);
        choices[2].setVisibility(View.INVISIBLE);
        for (int i = 0; i < story.current_situation.variants; i++){
            choices[i].setVisibility(View.VISIBLE);
        }

        player.C+=story.current_situation.dС;
        player.K+=story.current_situation.dK;
        player.Rn+=story.current_situation.dRn;
        player.Rz+=story.current_situation.dRz;
        K.setText(String.valueOf(player.K));
        C.setText(String.valueOf(player.C));
        Rn.setText(String.valueOf(player.Rn));
        Rz.setText(String.valueOf(player.Rz));
    }
}