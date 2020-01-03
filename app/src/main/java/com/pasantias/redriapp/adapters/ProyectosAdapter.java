package com.pasantias.redriapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pasantias.redriapp.Interface.ApiService;
import com.pasantias.redriapp.R;
import com.pasantias.redriapp.models.Proyecto;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProyectosAdapter extends RecyclerView.Adapter<ProyectosAdapter.ViewHolder> {

    private static final String TAG = ProyectosAdapter.class.getSimpleName();

    private List<Proyecto> proyectos;

    public ProyectosAdapter(){
        this.proyectos = new ArrayList<>();
    }

    public void setProyectos(List<Proyecto> proyectos){
        this.proyectos = proyectos;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView fotoImage;
        TextView nombreText;
        TextView precioText;

        ViewHolder(View itemView) {
            super(itemView);
            fotoImage = itemView.findViewById(R.id.foto_image);
            nombreText = itemView.findViewById(R.id.nombreproyecto_text);
            precioText = itemView.findViewById(R.id.nivel_text);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_proyecto, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        final Context context = viewHolder.itemView.getContext();

        Proyecto proyecto = this.proyectos.get(position);

        viewHolder.nombreText.setText(proyecto.getNombre_proyectos());
        viewHolder.precioText.setText(NumberFormat.getCurrencyInstance(new Locale("es", "PE")).format(proyecto.getNivel()));

        String url = ApiService.API_BASE_URL + "/proyectos/images/" + proyecto.getImagen();
        Picasso.with(context).load(url).into(viewHolder.fotoImage);


    }

    @Override
    public int getItemCount() {
        return this.proyectos.size();
    }

}



