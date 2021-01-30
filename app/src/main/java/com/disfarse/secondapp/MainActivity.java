package com.disfarse.secondapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    Button approvedBtn, examBtn, registerBtn;
    public static final int REQUEST_CODE = 1;
    private final LinkedList<Aluno> ListaDeAlunos = new LinkedList<>();
    public static AlunoAdapter alAdapter;
    public String studentName;
    public Float finalGrade;
    public Aluno myAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register();
        /*approved();
        exam();
        */

    }

    public void register (){
        registerBtn = findViewById(R.id.register);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(getApplicationContext(), RegisterStudent.class);
                startActivityForResult(registerIntent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK){
                studentName = data.getStringExtra("nome");
                finalGrade = Float.parseFloat(data.getStringExtra("notafinal"));

                myAluno = new Aluno(studentName, finalGrade);

                if (finalGrade >= 12) {
                    myAluno.setApproved(true);
                }

                ListaDeAlunos.add(myAluno);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Error: Didn't Get The Data", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void approved (){
        approvedBtn = findViewById(R.id.approved);
        approvedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Aluno aluno = new Aluno(studentName, finalGrade);
                //Fazer Um Filtro na lista: check if isApproved = True;
                LinkedList<Aluno> listaApproved = filtroApproved(ListaDeAlunos, myAluno);

                //Iniciar o adapter com listaApproved
                alAdapter = new AlunoAdapter(getApplicationContext(), listaApproved);


                Intent approvedIntent = new Intent(getApplicationContext(), AlunoRecyclerList.class);
                startActivity(approvedIntent);
            }
        });

    }
    public void exam () {
        examBtn = findViewById(R.id.exam);
        examBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Aluno aluno = new Aluno(studentName, finalGrade);
                //Fazer Um Filtro na lista: Check if is approved = false
                LinkedList<Aluno> listaExam = filtroExam(ListaDeAlunos, myAluno);

                //inicializar o adaptar com a listaExam
                alAdapter = new AlunoAdapter(getApplicationContext(), listaExam);
                Intent approvedIntent = new Intent(getApplicationContext(), AlunoRecyclerList.class);
                startActivity(approvedIntent);
            }
        });
    }

    public LinkedList filtroApproved (LinkedList<?> list, Aluno aluno){
        while (list.size() != 0){
            if (aluno.isApproved())
            list.remove(aluno);
        }

        return list;
    }

    public LinkedList filtroExam (LinkedList<?> list, Aluno aluno){
        while (list.size() != 0){
            if (!aluno.isApproved())
                list.remove(aluno);
        }



        return list;
    }


}