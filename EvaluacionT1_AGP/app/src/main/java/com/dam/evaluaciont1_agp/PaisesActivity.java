package com.dam.evaluaciont1_agp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaisesActivity extends AppCompatActivity implements View.OnClickListener{


    public static final String EQUIPO_SELEC = "";
    Button btnaccept, btncanc;
    EditText etEqSelec;
    Button btnarg, btnara, btnale,btnaus,btnbel,btnbra,btncam,btncan,btncor,btncos,btncro,btndin,btnecu,btnesp,btnusa,btnfra,
            btngal,btngha,btnhol, btning,btnira,btnjap,btnmar,btnmex,btnpol,btnpor,btnqat,btnsen,btnser,btnsui,btntun,btnuru;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);

        btnaccept = findViewById(R.id.btnaccept);

        btnaccept.setOnClickListener(this);

        btncanc = findViewById(R.id.btncanc);

        btncanc.setOnClickListener(this);

        etEqSelec = findViewById(R.id.etEqSelec);

        btnarg = findViewById(R.id.btnarg);
        btnarg.setOnClickListener(this);
        btnara = findViewById(R.id.btnara);
        btnara.setOnClickListener(this);
        btnale = findViewById(R.id.btnale);
        btnale.setOnClickListener(this);
        btnaus = findViewById(R.id.btnaus);
        btnaus.setOnClickListener(this);
        btnbel = findViewById(R.id.btnbel);
        btnbel.setOnClickListener(this);
        btnbra = findViewById(R.id.btnbra);
        btnbra.setOnClickListener(this);
        btncam = findViewById(R.id.btncam);
        btncam.setOnClickListener(this);
        btncan = findViewById(R.id.btncan);
        btncan.setOnClickListener(this);
        btncor = findViewById(R.id.btncor);
        btncor.setOnClickListener(this);
        btncos = findViewById(R.id.btncos);
        btncos.setOnClickListener(this);
        btncro = findViewById(R.id.btncro);
        btncro.setOnClickListener(this);
        btndin = findViewById(R.id.btndin);
        btndin.setOnClickListener(this);
        btnecu = findViewById(R.id.btnecu);
        btnecu.setOnClickListener(this);
        btnesp = findViewById(R.id.btnesp);
        btnesp.setOnClickListener(this);
        btnusa = findViewById(R.id.btnusa);
        btnusa.setOnClickListener(this);
        btnfra = findViewById(R.id.btnfra);
        btnfra.setOnClickListener(this);
        btngal = findViewById(R.id.btngal);
        btngal.setOnClickListener(this);
        btngha = findViewById(R.id.btngha);
        btngha.setOnClickListener(this);
        btnhol = findViewById(R.id.btnhol);
        btnhol.setOnClickListener(this);
        btning = findViewById(R.id.btning);
        btning.setOnClickListener(this);
        btnira = findViewById(R.id.btnira);
        btnira.setOnClickListener(this);
        btnjap = findViewById(R.id.btnjap);
        btnjap.setOnClickListener(this);
        btnmar = findViewById(R.id.btnmar);
        btnmar.setOnClickListener(this);
        btnmex = findViewById(R.id.btnmex);
        btnmex.setOnClickListener(this);
        btnpol = findViewById(R.id.btnpol);
        btnpol.setOnClickListener(this);
        btnpor = findViewById(R.id.btnpor);
        btnpor.setOnClickListener(this);
        btnqat = findViewById(R.id.btnqat);
        btnqat.setOnClickListener(this);
        btnsen = findViewById(R.id.btnsen);
        btnsen.setOnClickListener(this);
        btnser = findViewById(R.id.btnser);
        btnser.setOnClickListener(this);
        btnsui = findViewById(R.id.btnsui);
        btnsui.setOnClickListener(this);
        btntun = findViewById(R.id.btntun);
        btntun.setOnClickListener(this);
        btnuru = findViewById(R.id.btnuru);
        btnuru.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String pais ="";
        if(view.getId() == R.id.btnaccept){
            Intent intent = new Intent();
            intent.putExtra(EQUIPO_SELEC, etEqSelec.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }else if(view.getId() == R.id.btncanc){
            finish();
        }else{
            etEqSelec.setText(((Button) view).getText());

        }
    }
}