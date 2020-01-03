package com.pasantias.redriapp.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.pasantias.redriapp.Interface.ApiService;
import com.pasantias.redriapp.Interface.ApiServiceGenerator;
import com.pasantias.redriapp.R;
import com.pasantias.redriapp.models.Proyecto;

import java.io.ByteArrayOutputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterProyectoActivity extends AppCompatActivity {

    private static final String TAG = RegisterProyectoActivity.class.getSimpleName();

    private ImageView imagenPreview;

    private EditText nombreInput;
    private EditText precioInput;
    private EditText detallesInput;
    private EditText areaInput;
    private EditText observacionInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_proyecto);


        imagenPreview = findViewById(R.id.imagen_preview);
        nombreInput = findViewById(R.id.nombre_input);
        precioInput = findViewById(R.id.precio_input);
        detallesInput = findViewById(R.id.detalles_input);
        areaInput=findViewById(R.id.area_input);
        observacionInput=findViewById(R.id.observacion_input);

    }
    private static final int REQUEST_CAMERA = 100;

    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private Bitmap bitmap;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAMERA) {
            if (resultCode == RESULT_OK) {
                bitmap = (Bitmap) data.getExtras().get("data");
                bitmap = scaleBitmapDown(bitmap, 800);  // Redimensionar
                imagenPreview.setImageBitmap(bitmap);
            }
        }
    }

    public void callRegister(View view){

        String nombre = nombreInput.getText().toString();
        String nivel = precioInput.getText().toString();
        String maquina = detallesInput.getText().toString();
        String area=areaInput.getText().toString();
        String observacion=observacionInput.getText().toString();

        if (nombre.isEmpty() ||nivel.isEmpty()||maquina.isEmpty()||area.isEmpty()||observacion.isEmpty()) {
            Toast.makeText(this, "Todos los campos requeridos", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<Proyecto> call;

        if(bitmap == null){
            call = service.createProyecto(nombre, nivel,maquina,area,observacion);
        } else {

            // De bitmap a ByteArray
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            // ByteArray a MultiPart
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), byteArray);
            MultipartBody.Part imagenPart = MultipartBody.Part.createFormData("imagen", "photo.jpg", requestFile);

            // Paramestros a Part
            RequestBody nombrePart = RequestBody.create(MultipartBody.FORM, nombre);
            RequestBody precioPart = RequestBody.create(MultipartBody.FORM, nivel);
            RequestBody detallesPart = RequestBody.create(MultipartBody.FORM, maquina);
            RequestBody areaPart=RequestBody.create(MultipartBody.FORM,area);
            RequestBody observacionPart=RequestBody.create(MultipartBody.FORM,observacion);

            call = service.createProyecto(nombrePart, precioPart, detallesPart,areaPart,observacionPart,imagenPart);
        }

        call.enqueue(new Callback<Proyecto>() {
            @Override
            public void onResponse(@NonNull Call<Proyecto> call, @NonNull Response<Proyecto> response) {
                try {
                    if(response.isSuccessful()) {

                        Proyecto proyecto = response.body();
                        Log.d(TAG, "proyecto: " + proyecto);

                        Toast.makeText(RegisterProyectoActivity.this, "Registro guardado satisfactoriamente", Toast.LENGTH_SHORT).show();

                        setResult(RESULT_OK);

                        finish();

                    }else{
                        throw new Exception(ApiServiceGenerator.parseError(response).getMessage());
                    }
                } catch (Throwable t) {
                    Log.e(TAG, "onThrowable: " + t.getMessage(), t);
                    Toast.makeText(RegisterProyectoActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Proyecto> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t);
                Toast.makeText(RegisterProyectoActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    // Redimensionar una imagen bitmap
    private Bitmap scaleBitmapDown(Bitmap bitmap, int maxDimension) {

        int originalWidth = bitmap.getWidth();
        int originalHeight = bitmap.getHeight();
        int resizedWidth = maxDimension;
        int resizedHeight = maxDimension;

        if (originalHeight > originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = (int) (resizedHeight * (float) originalWidth / (float) originalHeight);
        } else if (originalWidth > originalHeight) {
            resizedWidth = maxDimension;
            resizedHeight = (int) (resizedWidth * (float) originalHeight / (float) originalWidth);
        } else if (originalHeight == originalWidth) {
            resizedHeight = maxDimension;
            resizedWidth = maxDimension;
        }
        return Bitmap.createScaledBitmap(bitmap, resizedWidth, resizedHeight, false);
    }

}
