package com.example.avaliacao;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class telaSalva extends AppCompatActivity {
    TextView filme, ano, diretor, atores, descricao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_salva);

        filme = findViewById(R.id.filmesalvo_txt);
        ano = findViewById(R.id.anosalvo_txt);
        diretor = findViewById(R.id.diretor_txt);
        atores = findViewById(R.id.atoressalvo_txt);
        descricao = findViewById(R.id.descricaosalvo_txt);

        Intent it = getIntent();
        String getFilme = getIntent().getStringExtra("filme_txt");
        String getAno = getIntent().getStringExtra("ano_txt");
        String getDiretor = getIntent().getStringExtra("diretor_txt");
        String getAtores = getIntent().getStringExtra("atores_txt");
        String getDescricao = getIntent().getStringExtra("descricao_txt");

        filme.setText(getFilme);
        ano.setText(getAno);
        diretor.setText(getDiretor);
        atores.setText(getAtores);
        descricao.setText(getDescricao);







    }



}
