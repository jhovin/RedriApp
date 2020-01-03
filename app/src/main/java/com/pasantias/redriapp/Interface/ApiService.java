package com.pasantias.redriapp.Interface;

import com.pasantias.redriapp.models.Proyecto;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    String API_BASE_URL="http://172.28.30.123:8080";

    @GET("/proyectos")
    Call<List<Proyecto>>getProyectos();

    @FormUrlEncoded
    @POST("/proyectos")
    Call<Proyecto> createProyecto(@Field("nombre") String nombre,
                                  @Field("nivel") String nivel,
                                  @Field("maquina") String maquina,
                                  @Field("area") String area,
                                  @Field("observacion") String observacion);
    @Multipart
    @POST("/proyectos")
    Call<Proyecto> createProyecto(@Part("nombre") RequestBody nombre,
                                  @Part("nivel") RequestBody nivel,
                                  @Part("maquina")RequestBody maquina,
                                  @Part("area") RequestBody area,
                                  @Part("observacion") RequestBody observacion,
                                  @Part MultipartBody.Part imagen
    );

}
