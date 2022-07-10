package com.example.guessanimal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView animalImage;
    boolean isDog,isCat,isGiraffe;
    Button resultBtn;
    String animal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animalImage = findViewById(R.id.animalImage);
        resultBtn = findViewById(R.id.resultBtn);

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("key",animal);
                startActivity(intent);
            }
        });
    }

    public void changeImage(View view) {
        switch (view.getId()){
            case R.id.dogBtn:
               animalImage.setImageResource(R.drawable.dog);
               isDog = true;
               isCat = false;
               isGiraffe = false;

                break;
            case R.id.catBtn:
                animalImage.setImageResource(R.drawable.cat);
                isCat = true;
                isDog = false;
                isGiraffe= false;
                break;

            case R.id.giraffeBtn:
                animalImage.setImageResource(R.drawable.giraffe);
                isGiraffe = true;
                isDog = false;
                isCat = false;
                break;
        }
    }
    void checkAnswer(){
        if (isGiraffe){
            Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show();
        }else if (isCat){
            Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show();
        }
    }

    public void answer(View view) {
        switch (view.getId()) {
            case R.id.thisDogBtn:
                if (isDog){
                    Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Не верно", Toast.LENGTH_SHORT).show();
                }
                checkAnswer();
                break;

            case R.id.thisCatBtn:
                if (isCat){
                    Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Не верно", Toast.LENGTH_SHORT).show();
                }
                checkAnswer();
                break;

            case R.id.thisGiraffeBtn:
                if (isGiraffe){
                    Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Не верно", Toast.LENGTH_SHORT).show();
                }
                checkAnswer();
                break;
        }
        switch (view.getId()){
            case R.id.thisDogBtn:
                animal = "that dog";
        }
        switch (view.getId()){
            case R.id.thisCatBtn:
                animal = "that cat";
        }
        switch (view.getId()){
            case R.id.thisGiraffeBtn:
                animal = "that giraffe";
        }
    }
}