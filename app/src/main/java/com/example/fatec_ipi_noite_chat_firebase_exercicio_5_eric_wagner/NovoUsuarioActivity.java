package com.example.fatec_ipi_noite_chat_firebase_exercicio_5_eric_wagner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class NovoUsuarioActivity extends AppCompatActivity {

    private EditText loginNovoUsuarioEditText;
    private EditText senhaNovoUsuarioEditText;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        loginNovoUsuarioEditText = findViewById(R.id.loginNovoUsuarioEditText);
        senhaNovoUsuarioEditText = findViewById(R.id.senhaNovoUsuarioEditText);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void criarNovoUsuario (View view) {
        String login = loginNovoUsuarioEditText.getText().toString();
        String senha = senhaNovoUsuarioEditText.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(login, senha).addOnSuccessListener((result) -> { // lambda
            Toast.makeText(this, getString(R.string.cadastro_sucesso), Toast.LENGTH_SHORT).show();
            finish();
        }).addOnFailureListener((error) -> {
            Toast.makeText(this, getString(R.string.cadastro_falha), Toast.LENGTH_SHORT).show();
            finish(); // voltar para tela.
        });
    }
}
