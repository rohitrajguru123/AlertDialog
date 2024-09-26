package com.example.alertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initializeViews();
        intializeListners();

    }
  protected void  initializeViews(){
        btn = findViewById(R.id.btn);
  }
    protected  void intializeListners(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exam From Submit");
                builder.setMessage("Do You Want Submit Exam");

                builder.setPositiveButton("yes", new PostiveButtonClickListner());
                builder.setNegativeButton("No", new NegativeButtonClickListner());
                builder.setNeutralButton("Not Sure", new NeutralButtonClickListner());

                builder.setCancelable(true);
                builder.show();

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private class PostiveButtonClickListner implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Positive Button CLicked ",Toast.LENGTH_LONG).show();
        }
    }

    private class NegativeButtonClickListner implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Negative Button Clicked",Toast.LENGTH_LONG).show();
        }
    }

    private class NeutralButtonClickListner implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"NeutralButtonClicked",Toast.LENGTH_LONG).show();
        }
    }
}
