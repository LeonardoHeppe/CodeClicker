package com.example.codeclicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaInicial extends AppCompatActivity {
    ConstraintLayout click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        getSupportActionBar().hide();
        click = findViewById(R.id.layoutClickInicial);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proxTela();
            }
        });
    }
    public void proxTela(){
        startActivity(new Intent(TelaInicial.this,TelaTutorial.class));
    }
}