package com.example.meuaplicativo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class newFotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_foto);
    }
    public void voltar(View view){
        finish();
    }

    // método para carrega a imagem no imageView
    public void carregarImagem(View view){
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        EditText editText = (EditText) findViewById(R.id.editText);
        Picasso.get().load(editText.getText().toString()).into(imageView);
    }
}
