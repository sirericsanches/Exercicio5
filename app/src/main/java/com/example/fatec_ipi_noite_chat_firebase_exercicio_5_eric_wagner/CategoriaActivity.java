package com.example.fatec_ipi_noite_chat_firebase_exercicio_5_eric_wagner;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoriaActivity extends AppCompatActivity {

    private RecyclerView categoriasRecyclerView;
    private CategoriaAdapter adapter;
    private List<Categoria> categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        categoriasRecyclerView = findViewById(R.id.categoriaRecyclerView);

        categorias = new ArrayList<>();
        adapter = new CategoriaAdapter(categorias, this);
        categoriasRecyclerView.setAdapter(adapter);
        Categoria c1 = new Categoria();
        Categoria c2 = new Categoria();
        Categoria c3 = new Categoria();
        Categoria c4 = new Categoria();

        c1.setCategoria("Cinema");
        c2.setCategoria("Novidades");
        c3.setCategoria("Tecnologia");
        c4.setCategoria("Economia");
        categorias.add(c1);
        categorias.add(c2);
        categorias.add(c3);
        categorias.add(c4);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        categoriasRecyclerView.setLayoutManager(linearLayoutManager);

    }
}

class CategoriaViewHolder extends RecyclerView.ViewHolder {
    TextView categoriaTextView;

    CategoriaViewHolder(View raiz) { // poupando computação
        super(raiz);
        this.categoriaTextView = raiz.findViewById(R.id.categoriaTextView);
    }
}

class CategoriaAdapter extends RecyclerView.Adapter<CategoriaViewHolder> {
    private List<Categoria> categorias;
    private Context context;
    CategoriaAdapter (List <Categoria> categorias, Context context) {
        this.categorias = categorias;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View raiz = inflater.inflate(R.layout.list_item_categoria, parent, false);
        return new CategoriaViewHolder(raiz);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        Categoria c = categorias.get(position);
        holder.categoriaTextView.setText(c.getCategoria());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ChatActivity.class);
                i.putExtra("CATEGORIA", c.getCategoria());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.categorias.size();
    }

}