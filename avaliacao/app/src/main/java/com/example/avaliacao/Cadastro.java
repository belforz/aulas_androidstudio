package com.example.avaliacao;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Cadastro extends AppCompatActivity {

    EditText cCodigo;
    EditText cFilme;
    EditText cAno;
    EditText cAtores;
    EditText cDiretor;
    EditText cDescricao;
    Button btSalvar;
    Button btExcluir;
    Button btLimpar;
    ListView viewFilme;

    ArrayAdapter adapter;
    ArrayList<String> arrayList;
    InputMethodManager inm ;

    BancoDados db = new BancoDados(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inm = (InputMethodManager) this.getSystemService( Service.INPUT_METHOD_SERVICE);

        cCodigo = findViewById(R.id.txtCodigo);

        cFilme = findViewById(R.id.edt_filme);
        cAno = findViewById(R.id.edt_ano);
        cAtores = findViewById(R.id.edt_atores);
        cDiretor = findViewById(R.id.edt_diretor);
        cDescricao = findViewById(R.id.edt_descricao);
        btSalvar = findViewById(R.id.btnSalvar);
        btExcluir = findViewById(R.id.btn_Excluir);
        btLimpar = findViewById(R.id.btnLimpar);

        cFilme.requestFocus();

        viewFilme.setOnClickListener( new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String conteudo = (String) viewFilme.getItemAtPosition( position );

                String codigo = conteudo.substring( 0, conteudo.indexOf( "-" ) );

                Filme filme = db.selecionarFilme( Integer.parseInt( codigo ) );

                cCodigo.setText(String.valueOf( filme.getCodigo() )  );
                cFilme.setText( filme.getFilme() );
                cAno.setText(filme.getAno());
                cAtores.setText(filme.getAtores());
                cDiretor.setText(filme.getDiretor());
                cDescricao.setText(filme.getDescricao());

            } };



        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparCampos();

            }
        });

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codigo = cCodigo.getText().toString();
                String filme = cFilme.getText().toString();
                String ano = cAno.getText().toString();
                String atores = cAtores.getText().toString();
                String diretor = cDiretor.getText().toString();
                String descricao = cDescricao.getText().toString();

                if(filme.isEmpty()){
                    cFilme.setError("Este campo é obrigatório");

                } else if (codigo.isEmpty()){
                    db.addFilme(new Filme(filme,ano,atores,diretor,descricao));
                    Toast.makeText(Cadastro.this, "Cadastro salvo com sucesso", Toast.LENGTH_SHORT).show();
                    listarFilmes();
                    limpaCampos();
                    escondeTeclado();
                } else {
                    db.atualizarFilme(new Filme(Integer.parseInt(codigo), filme, ano, atores, diretor, descricao));
                    Toast.makeText(Cadastro.this, "Cadastro atualizado com sucesso", Toast.LENGTH_SHORT).show();
                    listarFilmes();
                    limpaCampos();
                    escondeTeclado();
                }

            }
        });

        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codigo = cCodigo.getText().toString();
                if(codigo.isEmpty()){
                    Toast.makeText(Cadastro.this, "Nenhuma pessoa está selecionada", Toast.LENGTH_SHORT).show();
                } else{
                    Filme filme = new Filme();
                    filme.setCodigo(Integer.parseInt(codigo));
                    db.apagaFilme((filme));
                    cCodigo.setText("");
                    listarFilmes();
                    limpaCampos();
                }
            }
        });
        void escondeTeclado() { inm.hideSoftInputFromWindow(cFilme.getWindowToken(), 0));

            public void limpaCampos(){
                cCodigo.setText("");
                cFilme.setText("");
                cAno.setText("");
                cAtores.setText("");
                cDiretor.setText("");
                cDescricao.setText("");

                cFilme.requestFocus();
            }

            public void listaFilmes(){
                List<Filme> filmes = db.listaFilmes();
                arrayList = new ArrayList<String>();
                adapter = new ArrayAdapter<String>(Cadastro.this, android.R.layout.simple_list_item_1, arrayList);

                viewFilme.setAdapter(adapter);

                for(Filme c : filmes){
                    //Log.d( "Lista", "\nID: " + c.getCodigo() + "Nome: " + c.getNome(  ));            //arrayList. add( c.getCodigo() + "-" + c.getCodigo());
                    arrayList.add(c.getCodigo() + "-" + c.getCodigo());
                    adapter.notifyDataSetChanged();
                }

            }
        }





    }
}
}