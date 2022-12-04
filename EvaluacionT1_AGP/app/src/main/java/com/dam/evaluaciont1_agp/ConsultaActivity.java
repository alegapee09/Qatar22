package com.dam.evaluaciont1_agp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class ConsultaActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etpaisacons;
    Button btnfiltrarPais;
    FrameLayout frame1, frame2, frame3, frame4, frame5, frame6, frame7;


    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        etpaisacons.setText(result.getData().getStringExtra(PaisesActivity.EQUIPO_SELEC));
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.frame1, ResultadoFragment.class, null)
                                .setReorderingAllowed(true)
                                .addToBackStack("name") // name can be null
                                .commit();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        etpaisacons = findViewById(R.id.etpaisacons);

        etpaisacons.setFocusable(false);

        btnfiltrarPais = findViewById(R.id.btnfiltrarPais);

        btnfiltrarPais.setOnClickListener(this);

        frame1 = findViewById(R.id.frame1);

        frame2 = findViewById(R.id.frame2);

        frame3 = findViewById(R.id.frame3);

        frame4 = findViewById(R.id.frame4);

        frame5 = findViewById(R.id.frame5);

        frame6 = findViewById(R.id.frame6);

        frame7 = findViewById(R.id.frame7);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnfiltrarPais) {
            filtarpais();
        }else{
            limpiardatos();}
    }

    private void limpiardatos() {

        btnfiltrarPais.setText("SELECCIONAR");

        etpaisacons.setText("");

        frame1.removeAllViews();

        frame2.removeAllViews();

        frame3.removeAllViews();

        frame4.removeAllViews();

        frame5.removeAllViews();

        frame6.removeAllViews();

        frame7.removeAllViews();

    }

    private void filtarpais() {
        Intent i = new Intent(ConsultaActivity.this, PaisesActivity.class);
        resultLauncher.launch(i);

    }
}