package com.example.avaliacao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BancoDados extends SQLiteOpenHelper {
        // Define a versão do banco de dados

        public static final int VERSAO_BANCO = 1;
        public static final String BANCO_AVALIACAO = "db_avaliacao";
        // Define o nome do banco de dados

        public BancoDados(Context content){
            super(content, BANCO_AVALIACAO, null, VERSAO_BANCO);
        }
        // Define as constantes que serão usadas para criar a tabela "tb_filmes"
        public static final String TABELA_FILMES = "tb_filmes";

        public static final String COLUNA_CODIGO = "codigo";
        public static final String COLUNA_FILME = "filme";
        public static final String COLUNA_ANO = "ano";
        public static final String COLUNA_DIRETOR = "diretor";
        public static final String COLUNA_ATORES = "atores";
        public static final String COLUNA_DESCRICAO = "descricao";


        // Define o método que é chamado na primeira vez que o banco de dados é criado

        @Override
        public void onCreate(SQLiteDatabase db) {
            // Cria a tabela "tb_filmes" com as colunas definidas nas constantes acima
            String CRIAR_TABELA = "CREATE TABLE " + TABELA_FILMES+ "("
                    + COLUNA_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUNA_FILME +
                    " TEXT," + COLUNA_ANO + " TEXT," + COLUNA_DIRETOR + " TEXT," + COLUNA_ATORES + " TEXT," + COLUNA_DESCRICAO + " TEXT)";

            db.execSQL(CRIAR_TABELA);
        }

        // Define o método que é chamado quando o banco de dados é atualizado
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        }


        void addFilme(Filme filme){
            // Define um método para adicionar um filme à tabela "tb_filmes"
            SQLiteDatabase db = this.getWritableDatabase();

            // Cria um objeto ContentValues com as informações do filme
            ContentValues valor = new ContentValues();
            valor.put(COLUNA_FILME,filme.getFilme());
            valor.put(COLUNA_ANO,filme.getAno());
            valor.put(COLUNA_DIRETOR, filme.getDiretor());
            valor.put(COLUNA_ATORES, filme.getAtores());
            valor.put(COLUNA_DESCRICAO, filme.getDescricao());

            // Insere os valores na tabela "tb_filmes"
            db.insert(TABELA_FILMES,null,valor);
            db.close();

        }

        void apagaFilme(Filme filme){
            // Define um método para apagar um filme da tabela "tb_filmes"

            SQLiteDatabase db = this.getWritableDatabase();

            // deleta o filme com um placholder
            db.delete(TABELA_FILMES,COLUNA_CODIGO + "=?", new String[]{
                    String.valueOf(filme.getCodigo())
            });
            db.close();
        }

        Filme selecionarFilme(int codigo){
            // define um método para ler(seleciomar) a tabela
            SQLiteDatabase db = this.getReadableDatabase();

            // cursor seria tipo um arquivo excel que se mexe
            Cursor cursor = db.query(TABELA_FILMES, new String[]{COLUNA_CODIGO, COLUNA_FILME, COLUNA_ANO, COLUNA_DIRETOR, COLUNA_ATORES,COLUNA_DESCRICAO},
                    COLUNA_CODIGO + "=?",new String[]{String.valueOf(codigo)},null,null,null,null);

            if (cursor != null){
                cursor.moveToFirst();

                // se não tiver nenhum valor, ele se move pra cima
            }


            // retorno a seleção do cursor por ordem
            Filme filme = new Filme(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4), cursor.getString(5));
            return filme;
        }
        // método para atualizar filme da databse
        void atualizarFilme(Filme filme){
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues valor = new ContentValues();
            valor.put(COLUNA_FILME,filme.getFilme());
            valor.put(COLUNA_ANO,filme.getAno());
            valor.put(COLUNA_DIRETOR, filme.getDiretor());
            valor.put(COLUNA_ATORES, filme.getAtores());
            valor.put(COLUNA_DESCRICAO, filme.getDescricao());
            // atributo put guarda os valores atuaçizados e pega os campos inseridos pelo usuario para atualizar na database

            // método para atualizar
            db.update(TABELA_FILMES,valor,COLUNA_CODIGO + " =?", new String[]{String.valueOf(filme.getCodigo())});
            db.close();
        }

    public List<Filme> listaPessoa() {

        List<Filme> filmeLista = new ArrayList<Filme>();

        String query = "SELECT * FROM " + TABELA_FILMES;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                Filme filme = new Filme();

                filme.setCodigo(Integer.parseInt(cursor.getString(0)!=null?cursor.getString( 0 ):"0"));
                filme.setFilme(cursor.getString(1));
                filme.setAno(cursor.getString(2));
                filme.setAtores(cursor.getString(3));
                filme.setDiretor(cursor.getString(4));
                filme.setDescricao(cursor.getString(5));

                filmeLista.add(filme);

            } while (cursor.moveToNext());
        }

        return filmeLista;

    }}
