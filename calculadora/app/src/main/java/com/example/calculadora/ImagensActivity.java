package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ImagensActivity extends AppCompatActivity {
   ImageView imgfoto;
   Button btfoto1, btfoto2,btfoto3, btfoto4;
   TextView txtinformacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagens);

        imgfoto = (ImageView) findViewById((R.id.foto1));
        btfoto1 = (Button)  findViewById(R.id.btfoto1);
        btfoto2 = (Button) findViewById(R.id.btfoto2);
        btfoto3 = (Button) findViewById(R.id.btfoto3);
        btfoto4 = (Button) findViewById(R.id.btfoto4);

        txtinformacao = (TextView)  findViewById(R.id.txtinformacao);
        btfoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgfoto.setImageResource(R.drawable.taylor);
                txtinformacao.setText("foto 1");
            }
        });

        btfoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgfoto.setImageResource(R.drawable.taylor2);
                txtinformacao.setText("Foto 2");
            }
        });

        btfoto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgfoto.setImageResource(R.drawable.taylor1);
                txtinformacao.setText("Foto 3");
            }
        });

        btfoto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgfoto.setImageResource(R.drawable.taylor3);
                txtinformacao.setText("Foto 4");
            }
        });






    }
}