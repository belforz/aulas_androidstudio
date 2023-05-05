package com.example.avaliacao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class BancoDados extends SQLiteOpenHelper {

        public static final int VERSAO_BANCO = 1;
        public static final String BANCO_AVALIACAO = "db_avaliacao";

        public BancoDados(Context content){
            super(content, BANCO_AVALIACAO, null, VERSAO_BANCO);
        }

        public static final String TABELA_FILMES = "tb_filmes";

        public static final String COLUNA_CODIGO = "codigo";
        public static final String COLUNA_FILME = "filme";
        public static final String COLUNA_ANO = "ano";
        public static final String COLUNA_DIRETOR = "diretor";
        public static final String COLUNA_ATORES = "atores";
        public static final String COLUNA_DESCRICAO = "descricao";



        @Override
        public void onCreate(SQLiteDatabase db) {

            String CRIAR_TABELA = "CREATE TABLE " + TABELA_FILMES+ "("
                    + COLUNA_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUNA_FILME +
                    " TEXT," + COLUNA_ANO + " TEXT," + COLUNA_DIRETOR + " TEXT," + COLUNA_ATORES + " TEXT," + COLUNA_DESCRICAO + " TEXT)";

            db.execSQL(CRIAR_TABELA);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        }

        void addFilme(Filme filme){
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues valor = new ContentValues();
            valor.put(COLUNA_FILME,filme.getFilme());
            valor.put(COLUNA_ANO,filme.getAno());
            valor.put(COLUNA_DIRETOR, filme.getDiretor());
            valor.put(COLUNA_ATORES, filme.getAtores());
            valor.put(COLUNA_DESCRICAO, filme.getDescricao());


            db.insert(TABELA_FILMES,null,valor);
            db.close();

        }

        void apagaFilme(Filme filme){

            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABELA_FILMES,COLUNA_CODIGO + "=?", new String[]{
                    String.valueOf(filme.getCodigo())
            });
            db.close();
        }

        Filme selecionarFilme(int codigo){
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(TABELA_FILMES, new String[]{COLUNA_CODIGO, COLUNA_FILME, COLUNA_ANO, COLUNA_DIRETOR, COLUNA_ATORES,COLUNA_DESCRICAO},
                    COLUNA_CODIGO + "=?",new String[]{String.valueOf(codigo)},null,null,null,null);

            if (cursor != null){
                cursor.moveToFirst();
            }

            Filme filme = new Filme(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getString(4), cursor.getString(5));
            return filme;
        }
}
