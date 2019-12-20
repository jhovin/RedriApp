package com.pasantias.redriapp.activities;

import android.content.Intent;
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

public class OrdenActivity extends AppCompatActivity {

    private static final int REGISTER_REQUEST_CODE = 100;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserAdapter());

        cargarLista();

        FloatingActionButton fab = findViewById(R.id.add_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRegister();
            }
        });
    }

    private void cargarLista() {
        UserAdapter adapter = (UserAdapter) recyclerView.getAdapter();
        List<User> users = UserRepository.list();
        adapter.setUsers(users);
        adapter.notifyDataSetChanged();
    }

    private void callRegister() {

        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REGISTER_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                cargarLista();
            }
        }
    }
}