package com.pasantias.redriapp.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.pasantias.redriapp.R;
import com.pasantias.redriapp.models.User;
import com.pasantias.redriapp.repositories.UserRepository;

import java.util.Calendar;


public class RegisterActivity extends AppCompatActivity {

    private EditText supervisorInput;
    private EditText dni1Input;
    private EditText ubicacionInput;
    private EditText codigoInput;
    private EditText tecnico1Input;
    private EditText tecnico2Input;
    private EditText dnitec1Input;
    private EditText dnitec2Input;
    private EditText maquinaInput;
    private EditText modeloInput;
    private EditText serieInput;
    private EditText fechainicioInput;
    private EditText fechafinInput;
    private EditText horainicioInput;
    private EditText horafinInput;
    private Button saveButton;

    //Calendario
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    private int mYearIni1, mMonthIni1, mDayIni1, sYearIni1, sMonthIni1, sDayIni1;
    static final int DATE_ID = 0;
    static final int DATE_ID1 = 1;
    Calendar C = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        supervisorInput = findViewById(R.id.supervisor_input);
        dni1Input = findViewById(R.id.dnil_input);
        ubicacionInput = findViewById(R.id.ubicacion_input);
        codigoInput=findViewById(R.id.codigo_input);
        tecnico1Input=findViewById(R.id.tecnico1_input);
        tecnico2Input=findViewById(R.id.tecnico2_input);
        dnitec1Input=findViewById(R.id.dnitec1_input);
        dnitec2Input=findViewById(R.id.dnitec2_input);
        fechainicioInput=findViewById(R.id.fech_inicio);
        fechafinInput=findViewById(R.id.fech_fin);
        horainicioInput=findViewById(R.id.horainicio_input);
        horafinInput=findViewById(R.id.horafin_input);
        maquinaInput=findViewById(R.id.maquina_input);
        modeloInput=findViewById(R.id.modelo_input);
        serieInput=findViewById(R.id.serie_input);

        saveButton=findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });


    }



    private void save() {

        String supervisor=supervisorInput.getText().toString().toUpperCase();
        String dnisupervisor =dni1Input.getText().toString().toUpperCase();
        String ubicacion = ubicacionInput.getText().toString();
        String cod=codigoInput.getText().toString();
        String tec1=tecnico1Input.getText().toString().toUpperCase();
        String tec2=tecnico2Input.getText().toString();
        String dni_tec1=dnitec1Input.getText().toString();
        String dni_tec2=dnitec2Input.getText().toString();
        String maquina=maquinaInput.getText().toString().toUpperCase();
        String modelo=modeloInput.getText().toString();
        String serie=serieInput.getText().toString();
        String fechainicio=fechainicioInput.getText().toString();
        String fechafin=fechafinInput.getText().toString();
        String horainicio=horainicioInput.getText().toString();
        String horafin=horafinInput.getText().toString();

        User user = new User();
        user.setSupervisor(supervisor);
        user.setDnisupervisor(dnisupervisor);
        user.setUbicacion(ubicacion);
        user.setCodigo(cod);
        user.setTecnico1(tec1);
        user.setTecnico2(tec2);
        user.setDnitec1(dni_tec1);
        user.setDnitec2(dni_tec2);
        user.setMaquina(maquina);
        user.setModelo(modelo);
        user.setSerie(serie);
        user.setFechainicio(fechainicio);
        user.setFechafin(fechafin);
        user.setHorainicio(horainicio);
        user.setHorafin(horafin);


        if (supervisor.isEmpty()||dnisupervisor.isEmpty()||ubicacion.isEmpty()||cod.isEmpty()||
                tec1.isEmpty()||dni_tec1.isEmpty()||maquina.isEmpty()||modelo.isEmpty()||serie.isEmpty()){
            Toast.makeText(this, "¡Ingrese todos los campos!", Toast.LENGTH_SHORT).show();
            return;
        }if (supervisor.isEmpty()){
            Toast.makeText(this,"El campo de Supervisor es necesario",Toast.LENGTH_SHORT).show();
            return;
        }if (dnisupervisor.isEmpty()){
            Toast.makeText(this,"Es necesario colocar el DNI del Supervisor",Toast.LENGTH_SHORT).show();
            return;
        }if (tec1.isEmpty()){
            Toast.makeText(this,"Es necesario colocar como mínimo un Tecnico",Toast.LENGTH_SHORT).show();
            return;
        }if (dni_tec1.isEmpty()){
            Toast.makeText(this,"Es necesario colocar un DNI como mínimo ",Toast.LENGTH_SHORT).show();
            return;

        }else {
            UserRepository.save(user);
            Toast.makeText(this, "Usuario registrado con exito!", Toast.LENGTH_SHORT).show();
        }
        Intent intent=new Intent(this,DuracionActivity.class);
        startActivity(intent);
        setResult(RESULT_OK);
        finish();

    }

}



