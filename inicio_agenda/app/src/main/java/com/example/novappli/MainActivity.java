package com.example.novappli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btInicio = findViewById(R.id.btn_cadastro);

        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamaSegundaTela();
            }

            });
    }

        private void chamaSegundaTela (){
        Intent it = new Intent(this, Cadastro.class);
        startActivityForResult(it, 1);
        }
    }
