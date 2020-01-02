package com.pasantias.redriapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.pasantias.redriapp.R;
import com.pasantias.redriapp.models.User;
import com.pasantias.redriapp.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserAdapter() {
        users = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,  final int position) {
       final User user = this.users.get(position);

        viewHolder.supervisorText.setText(user.getSupervisor());
        viewHolder.dnisupervisorText.setText(user.getDnisupervisor());
        viewHolder.tecnico1Text.setText(user.getTecnico1());
        viewHolder.maquinaText.setText(user.getMaquina());
        viewHolder.modeloText.setText(user.getModelo());
        viewHolder.serieText.setText(user.getSerie());
        viewHolder.fechauser.setText(user.getFechafin());
        viewHolder.horauser.setText(user.getHorainicio());

        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserRepository.delete(user.getId());
                users.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView pictureImage;
        TextView supervisorText;
        TextView dnisupervisorText;
        TextView tecnico1Text;
        TextView maquinaText;
        TextView modeloText;
        TextView serieText;
        TextView fechauser;
        TextView horauser;

        ImageButton button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pictureImage = itemView.findViewById(R.id.picture_image);
            supervisorText = itemView.findViewById(R.id.supervisor_text);
            dnisupervisorText = itemView.findViewById(R.id.dnisupervisor_text);
            tecnico1Text=itemView.findViewById(R.id.tecnico1_text);
            maquinaText=itemView.findViewById(R.id.maquina_text);
            modeloText=itemView.findViewById(R.id.modelo_text);
            serieText=itemView.findViewById(R.id.serie_text);
            fechauser=itemView.findViewById(R.id.fecha_user);
            horauser=itemView.findViewById(R.id.hora_user);
            button = (ImageButton) itemView.findViewById(R.id.delete_button);
        }
    }

}

