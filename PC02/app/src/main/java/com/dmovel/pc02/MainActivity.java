package com.dmovel.pc02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int scoreTeam1 = 0;
    private int scoreTeam2 = 0;
    private String matchScoreString = " x ";
    private LastPlay lastPlay = new LastPlay();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Botões do Time 1
        Button btnOnePointT1 = findViewById(R.id.btnOnePointT1);
        Button btnTwoPointerT1 = findViewById(R.id.btnTwoPointerT1);
        Button btnThreePointerT1 = findViewById(R.id.btnThreePointerT1);

        // Botões do Time 2
        Button btnOnePointT2 = findViewById(R.id.btnOnePointT2);
        Button btnTwoPointerT2 = findViewById(R.id.btnTwoPointerT2);
        Button btnThreePointerT2 = findViewById(R.id.btnThreePointerT2);

        // Botão Voltar lance
        Button btnCancelBasket = findViewById(R.id.btnCancelBasket);

        View.OnClickListener addOnePoint = v -> {
            if (v.getId() == R.id.btnOnePointT1) {
                scoreTeam1++;
                lastPlay.setLastPlay("Team 1", 1);
            } else if (v.getId() == R.id.btnOnePointT2) {
                scoreTeam2++;
                lastPlay.setLastPlay("Team 2", 1);
            }

            updateMatchScore();
            btnCancelBasket.setEnabled(true);
        };

        // Ações dos botões
        View.OnClickListener addTwoPointer = v -> {
            if (v.getId() == R.id.btnTwoPointerT1) {
                scoreTeam1 += 2;
                lastPlay.setLastPlay("Team 1", 2);
            } else if (v.getId() == R.id.btnTwoPointerT2) {
                scoreTeam2 += 2;
                lastPlay.setLastPlay("Team 2", 2);
            }

            updateMatchScore();
            btnCancelBasket.setEnabled(true);
        };

        View.OnClickListener addThreePointer = v -> {
            if (v.getId() == R.id.btnThreePointerT1) {
                scoreTeam1 += 3;
                lastPlay.setLastPlay("Team 1", 3);
            } else if (v.getId() == R.id.btnThreePointerT2) {
                scoreTeam2 += 3;
                lastPlay.setLastPlay("Team 2", 3);
            }

            updateMatchScore();
            btnCancelBasket.setEnabled(true);
        };

        btnOnePointT1.setOnClickListener(addOnePoint);
        btnTwoPointerT1.setOnClickListener(addTwoPointer);
        btnThreePointerT1.setOnClickListener(addThreePointer);

        btnOnePointT2.setOnClickListener(addOnePoint);
        btnTwoPointerT2.setOnClickListener(addTwoPointer);
        btnThreePointerT2.setOnClickListener(addThreePointer);

        btnCancelBasket.setOnClickListener(v -> cancelBasket(btnCancelBasket));

        btnCancelBasket.setEnabled(false);
    }

    private void updateMatchScore() {
        TextView matchScore = findViewById(R.id.matchScore);
        matchScoreString = scoreTeam1 + " x " + scoreTeam2;
        matchScore.setText(matchScoreString);
    }

    private void cancelBasket(Button btnCancelBasket) {
        if (lastPlay.getTeam().equals("Team 1")) {
            scoreTeam1 -= lastPlay.getPoints();
        } else {
            scoreTeam2 -= lastPlay.getPoints();
        }

        updateMatchScore();
        btnCancelBasket.setEnabled(false);
    }
}
