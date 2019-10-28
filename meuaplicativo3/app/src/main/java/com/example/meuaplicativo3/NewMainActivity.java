package com.example.meuaplicativo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_main);
    }
    //Metodo para trocar a tela quando apertar o botão
    public void trocarDeTela(View view){
        Intent intent = new Intent(this, newFotoActivity.class);
        startActivity(intent);
    }
}
