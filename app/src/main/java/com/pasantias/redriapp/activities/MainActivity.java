package com.pasantias.redriapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pasantias.redriapp.R;
import com.pasantias.redriapp.adapters.UserAdapter;
import com.pasantias.redriapp.models.User;
import com.pasantias.redriapp.repositories.UserRepository;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void IrFormulario(View view) {
        Intent intent = new Intent(MainActivity.this, OTLimaActivity.class);
        startActivity(intent);
    }

    public void IrPagina(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.redrilsa.com.pe/"));
        startActivity(browserIntent);
    }







}