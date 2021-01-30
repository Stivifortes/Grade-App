package com.disfarse.secondapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder> {

    Context context;
    private final LinkedList<Aluno> studentList;

    private LayoutInflater mInflater;

    public AlunoAdapter(Context context, LinkedList<Aluno> list) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.studentList = list;
    }

    @NonNull
    @Override
    public AlunoAdapter.AlunoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.aluno_item, parent, false);

        return new AlunoViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull AlunoViewHolder holder, int position) {
        Aluno aluno = studentList.get(position);
        holder.name.setText(aluno.getNome());
        holder.notafinal.setText(String.valueOf(aluno.getNotaFinal()));

        if (aluno.isApproved()){
            holder.status.setText("Exam");
        }else{
            holder.status.setText("Approved");
        }

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }



    public class AlunoViewHolder extends RecyclerView.ViewHolder {

        public TextView name, notafinal, status;
        final AlunoAdapter alunoAdapterAdapter;


        public AlunoViewHolder(View itemView, AlunoAdapter alunoAdapterAdapter) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_nome);
            notafinal = itemView.findViewById(R.id.tv_notafinal);
            status = itemView.findViewById(R.id.tv_status);

            this.alunoAdapterAdapter = alunoAdapterAdapter;
        }


    }
}




