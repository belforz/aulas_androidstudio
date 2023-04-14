package com.example.avaliacao;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;

public class SegundaTela extends AppCompatActivity {
    EditText editFilme;
    EditText editAno;
    EditText editDiretor;
    EditText editAtores;
    EditText edt_descricao;
    Button btnLimpar;
    Button btnSelecionaImagem;
    Button btnSalvar;

    private static final int REQUEST_IMAGE_PICKER = 1;
    private Uri imageuri;

    @Override
    // criando uma instancia de chamado de tela
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundatela);

        setupViews();
    }

    //criando um rest nos campos, usando o metodo setupviews que inicializa uma nova atividade
    private void setupViews() {
        editFilme = findViewById(R.id.edt_filme);
        editAno = findViewById(R.id.edt_ano);
        editDiretor = findViewById(R.id.edt_diretor);
        editAtores = findViewById(R.id.edt_atores);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFilme.setText("");
                editAno.setText("");
                editDiretor.setText("");
                editAtores.setText("");
                edt_descricao.setText("");
            }
        });
        EditText filme = findViewById(R.id.edt_filme);
        EditText ano = findViewById(R.id.edt_ano);
        EditText diretor = findViewById(R.id.edt_diretor);
        EditText atores = findViewById(R.id.edt_atores);
        EditText descricao = findViewById(R.id.edt_descricao);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String getFilme = filme.getText().toString();
                String getAno = ano.getText().toString();
                String getDiretor = diretor.getText().toString();
                String getAtores = atores.getText().toString();
                String getDescricao = descricao.getText().toString();
                Log.d("MY_APP_TAG", "Values retrieved: " + getFilme + ", " + getAno + ", " + getDiretor + ", " + getAtores + ", " + getDescricao);
                Intent it = new Intent(SegundaTela.this, telaSalva.class);
                it.putExtra("filme_txt",getFilme);
                it.putExtra("ano_txt",getAno);
                it.putExtra("diretor_txt",getDiretor);
                it.putExtra("atores_txt",getAtores);
                it.putExtra("descricao_txt",getDescricao);
                startActivity(it);


            }
        });

        /// botão de selecionar imagem dentro do android para uso futuro
        btnSelecionaImagem = findViewById(R.id.btn_imagem);
        btnSelecionaImagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_IMAGE_PICKER);
            }
        });
    }
    /// onActivityResult necessario para a imagem ser lida e salva pelo sistema
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_PICKER && resultCode == RESULT_OK && data != null) {

            Uri imageUri = data.getData();

        }
    }


    }




// Your code here


