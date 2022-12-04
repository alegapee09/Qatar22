package com.dam.evaluaciont1_agp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import datos.ListadoResultados;
import datos.Resultado;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etFecha, etFase, etprimEq, etsegEq, etgolesprimEq, etgolessegEq;
    Button btnSelectPrimerPais, btnSelectSegPais, btnGuardarDatos, btnLimpiarDatos;
    String fecharr, faserr, primeqrr, segeqrr;
    int golesprimrr, golessegrr;
    ListadoResultados lista = new ListadoResultados();

    ActivityResultLauncher<Intent> resultLauncherprimerequipo = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        etprimEq.setText(result.getData().getStringExtra(PaisesActivity.EQUIPO_SELEC));
                    }
                }
            });
    ActivityResultLauncher<Intent> resultLaunchersegundoequipo = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        etsegEq.setText(result.getData().getStringExtra(PaisesActivity.EQUIPO_SELEC));
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);

        btnSelectPrimerPais = findViewById(R.id.btnSelectPrimerPais);

        btnSelectPrimerPais.setOnClickListener(this);

        btnSelectSegPais = findViewById(R.id.btnSelectSegPais);

        btnSelectSegPais.setOnClickListener(this);

        btnGuardarDatos = findViewById(R.id.btnGuardarDatos);

        btnGuardarDatos.setOnClickListener(this);

        btnLimpiarDatos = findViewById(R.id.btnLimpiarDatos);

        btnLimpiarDatos.setOnClickListener(this);

        etFecha = findViewById(R.id.etFecha);

        etFase = findViewById(R.id.etFase);

        etprimEq = findViewById(R.id.etprimEq);

        etprimEq.setFocusable(false);

        etsegEq = findViewById(R.id.etsegEq);

        etsegEq.setFocusable(false);

        etgolesprimEq = findViewById(R.id.etgolesprimEq);

        etgolessegEq = findViewById(R.id.etgolessegEq);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnGuardarDatos){
            if(comprobarDatos()) {
                Toast.makeText(RegistroActivity.this, R.string.todoOKJoseLuis, Toast.LENGTH_SHORT).show();
                guardarDatos();
                borrarTodo();
            }
        }else if( view.getId() == R.id.btnLimpiarDatos){
            borrarTodo();
        }else if (view.getId() == R.id.btnSelectPrimerPais){
            selectprimerpais();
        }else{
            selectsegpais();
        }

    }

    private void guardarDatos() {

        Resultado res = new Resultado(fecharr, faserr, primeqrr, golesprimrr, segeqrr, golessegrr);
        lista.addResultado(res);

    }

    private void selectprimerpais() {

        Intent i = new Intent(RegistroActivity.this, PaisesActivity.class);
        resultLauncherprimerequipo.launch(i);
    }

    private void selectsegpais() {

        Intent i = new Intent(RegistroActivity.this, PaisesActivity.class);
        resultLaunchersegundoequipo.launch(i);

    }

    private void borrarTodo() {
        etFecha.setText("");
        etFase.setText("");
        etprimEq.setText("");
        etsegEq.setText("");
        etgolesprimEq.setText("");
        etgolessegEq.setText("");
    }

    private boolean comprobarDatos() {
        Boolean valido = false;
        Boolean fechaval = comprobarFecha();
        Boolean faseval = comprobarFase();
        Boolean eqval = comprobarEquipos();
        Boolean golesval = comprobarGoles();


       if(!fechaval) {
           Toast.makeText(RegistroActivity.this, R.string.introfechavalida, Toast.LENGTH_LONG).show();
       }else if (!faseval){
           Toast.makeText(RegistroActivity.this, R.string.introfasevalida, Toast.LENGTH_LONG).show();
       }else if(!eqval){
           Toast.makeText(RegistroActivity.this, R.string.introequipos, Toast.LENGTH_LONG).show();
       }else if (golesval){
           Toast.makeText(RegistroActivity.this, R.string.introgoles, Toast.LENGTH_LONG).show();
       }else{
           valido = true;
       }

       return valido;
    }

    private Boolean comprobarGoles() {
        Boolean todoOK = true;
        if(!etgolesprimEq.getText().toString().isEmpty() || !etgolessegEq.getText().toString().isEmpty()){
            todoOK = false;
            golesprimrr = Integer.parseInt(String.valueOf(etgolesprimEq.getText()));
            golessegrr = Integer.parseInt(String.valueOf(etgolessegEq.getText()));
        }

        return todoOK;
    }

    private Boolean comprobarEquipos() {
        Boolean todoOK = false;
        String equipo = String.valueOf(etprimEq.getText());
        String segequipo = String.valueOf(etsegEq.getText());
        if(!equipo.equals(segequipo) && !equipo.equals("") && !segequipo.equals("")){
            todoOK = true;
            primeqrr = equipo;
            segeqrr = segequipo;
        }

        return todoOK;
    }

    private boolean comprobarFase() {
        boolean todoOK = false;
        String fase = String.valueOf(etFase.getText()).toUpperCase();
        if(fase.equals("FASE GRUPOS")||fase.equals("OCTAVOS") ||fase.equals("CUARTOS")||fase.equals("SEMIFINAL") ||fase.equals("TERCER PUESTO") || fase.equals("FINAL")){
            todoOK = true;
            faserr = fase;
        }
        return todoOK;
    }


    private Boolean comprobarFecha() {
        boolean todoOk = false;
        String fecha = String.valueOf(etFecha.getText());
        if(fecha.matches("^([1-9]|([012][0-9])|(3[01]))/([0]{0,1}[1-9]|1[012])/\\d\\d\\d\\d [012]{0,1}[0-9]:[0-6][0-9]$")){
            todoOk = true;
            fecharr = fecha;
        }
        return todoOk;
    }

}