package facci.pml.estudiantesdb.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import facci.pml.estudiantesdb.R;
import facci.pml.estudiantesdb.database.Modelo.Estudiante;

public class EstudianteAdapter extends ArrayAdapter<Estudiante> {

    private Context context;
    private ArrayList<Estudiante> profesorArray;

    public EstudianteAdapter(Context context, ArrayList<Estudiante> profesorArray) {
        super(context, R.layout.list_estudiante);
        this.context = context;
        this.profesorArray = profesorArray;
    }

    @Override
    public int getCount() {
        return profesorArray.size();
    }

    @Override
    public Estudiante getItem(int position) {
        return  profesorArray.get(position);
    }
    @Override
    public long getItemId(int position) {
        return profesorArray.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        final ViewHolder viewHolder;

        if (convertView == null || convertView.getTag() == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.list_estudiante, parent, false);
            viewHolder.mItemName = view.findViewById(R.id.LBLNombre);
            viewHolder.cedula = view.findViewById(R.id.LBLCedula);
            viewHolder.apellido = view.findViewById(R.id.LBLApellido);
            viewHolder.materia = view.findViewById(R.id.LBLFacultad);
            viewHolder.fecha = view.findViewById(R.id.FechaN);
            viewHolder.ciudad = view.findViewById(R.id.LBLCiudad);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

        // Set text with the item name
        viewHolder.mItemName.setText(profesorArray.get(position).getNombre());
        viewHolder.cedula.setText(profesorArray.get(position).getCedula());
        viewHolder.apellido.setText(profesorArray.get(position).getApellidos());
        viewHolder.fecha.setText(profesorArray.get(position).getFecha());
        viewHolder.materia.setText(profesorArray.get(position).getFacultad());
        viewHolder.ciudad.setText(profesorArray.get(position).getCiudad());

        return view;
    }

    static class ViewHolder {
        TextView mItemName, cedula, apellido, fecha, materia, ciudad;
    }
}