package com.pasantias.redriapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.pasantias.redriapp.R;

public class IminaLimaActivity extends AppCompatActivity {

    private Spinner spinnerIMina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imina_lima);

        spinnerIMina=(Spinner) findViewById(R.id.spinner_IM);
        spinnerIMina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),"Usted ha Seleccionado : " + parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?>arg){

            }
        });
    }

    public void IrseleccionarMina(View view) {
        String item=(String)spinnerIMina.getSelectedItem();
        Toast.makeText(this, "Usted ha Seleccionado: "+item, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(IminaLimaActivity.this,OrdenIMActivity.class);
        startActivity(intent);
    }
}
