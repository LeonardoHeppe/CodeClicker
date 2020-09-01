package com.example.codeclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaVitoria extends AppCompatActivity {
    Button btnReplai;
    TextView txtUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telavitoria);
        getSupportActionBar().hide();
        txtUp = findViewById(R.id.txtUpgrades);
        txtUp.setText("Número de Upgrades\nProgramadores: "+((Game.getInstance().getValorProg()/100)-1)+"\nClicks: "+((Game.getInstance().getValorUpgrade()/100)-1));
        btnReplai = findViewById(R.id.btnReplay);
        btnReplai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.getInstance().setInstacia();
                proxTela();
            }
        });
    }
    public void proxTela(){
        startActivity(new Intent(TelaVitoria.this,TelaJogo.class));
    }
}