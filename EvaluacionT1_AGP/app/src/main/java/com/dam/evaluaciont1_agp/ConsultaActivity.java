package com.dam.evaluaciont1_agp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ConsultaActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etpaisacons;


    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        etpaisacons.setText(result.getData().getStringExtra(PaisesActivity.EQUIPO_SELEC));
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        etpaisacons = findViewById(R.id.etpaisacons);

        etpaisacons.setFocusable(false);

    }

    @Override
    public void onClick(View view) {

    }
}