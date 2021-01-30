package com.disfarse.secondapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

import static com.disfarse.secondapp.MainActivity.alAdapter;

public class AlunoRecyclerList extends AppCompatActivity {

    private final LinkedList<Aluno> ListaDeAlunos = new LinkedList<>();

    private RecyclerView myRecyclerView;
    //private AlunoAdapter alAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_student);


        myRecyclerView.setAdapter(alAdapter);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}