package com.disfarse.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

public class RegisterStudent extends AppCompatActivity {

    EditText nomeEt, nota1Et, nota2Et;
    Button addAluno, cancel;
    //private LinkedList<Aluno> alunoLista;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        //Get Ids
        nomeEt = findViewById(R.id.et_nome);
        nota1Et = findViewById(R.id.et_teste1);
        nota2Et = findViewById(R.id.et_teste2);
        addAluno = findViewById(R.id.approved);
        cancel = findViewById(R.id.exam);

        //Get Input data
        String nome = nomeEt.getText().toString();
        String n1 = nota1Et.getText().toString();
        String n2 = nota2Et.getText().toString();

        Float notafinal = Float.parseFloat(n1) / Float.parseFloat(n2);

        addAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                if (nome != null ){
                    intent.putExtra("nome", nome);
                }else {
                    Toast.makeText(getApplicationContext(), "Nome é obrigatório!", Toast.LENGTH_LONG).show();
                }
                if (notafinal != null){
                    intent.putExtra("notafinal", notafinal);
                }else{
                    Toast.makeText(getApplicationContext(), "Nome é obrigatório!", Toast.LENGTH_LONG).show();
                }

                setResult(RESULT_OK, intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}