package com.example.codeclicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TelaJogo extends AppCompatActivity {
    ConstraintLayout click;
    Game game = Game.getInstance();
    LinearLayout layoutUpgrade;
    ImageButton imgAbre,imgFecha,imgUpClick,imgUpProg;
    TextView valorClick,pontos,upClick,upProg;
    boolean programador = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telajogo);
        getSupportActionBar().hide();
        click = findViewById(R.id.layoutClickJogo);
        layoutUpgrade = findViewById(R.id.layoutUpgrades);
        layoutUpgrade.setVisibility(layoutUpgrade.INVISIBLE);
        imgAbre = findViewById(R.id.imgUpgrades);
        imgFecha = findViewById(R.id.imgFecharUpgrades);
        imgUpClick = findViewById(R.id.imgClick);
        imgUpProg = findViewById(R.id.imgProg);
        valorClick = findViewById(R.id.txtValorClick);
        pontos = findViewById(R.id.txtPonto);
        upClick = findViewById(R.id.txtUpgrade);
        upProg = findViewById(R.id.txtUpgradeAuto);
        Thread t = new Thread(){
            @Override
            public void run() {
                while(programador){
                    try {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                game.codar();
                                atualizaTudo();
                                if(game.validaVitoria()){
                                    programador = false;
                                    proxTela();
                                }
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.contaPonto();
                if(game.validaVitoria()){
                    programador = false;
                    proxTela();
                }
                atualizaTudo();
            }
        });
        imgAbre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutUpgrade.setVisibility(layoutUpgrade.VISIBLE);
                imgAbre.setVisibility(imgAbre.INVISIBLE);
            }
        });
        imgFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutUpgrade.setVisibility(layoutUpgrade.INVISIBLE);
                imgAbre.setVisibility(imgAbre.VISIBLE);
            }
        });
        imgUpClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            game.upgradeClick();
                atualizaTudo();
            }
        });
        imgUpProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.upProgramador();
                atualizaTudo();
            }
        });
    }
    public void proxTela(){
        startActivity(new Intent(TelaJogo.this,TelaVitoria.class));
    }
    public void atualizaTudo(){
        pontos.setText(game.getPonto());
        valorClick.setText("+"+game.getValorClick());
        if(game.getValorUpgrade()==0){
            upClick.setText("100");
        }else {
            upClick.setText("" + game.getValorUpgrade());
        }if(game.getValorProg()==0){
            upProg.setText("100");
        }
        else{
        upProg.setText(""+game.getValorProg());
        }
    }
}