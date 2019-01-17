package facci.pml.estudiantesdb.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import facci.pml.estudiantesdb.R;
import facci.pml.estudiantesdb.database.entities.EstudianteItemDB;

public class AGG extends AppCompatActivity {

    private EditText cedula, nombres, apellidos, fechaNac, facultad, ciudad;
    private Button agg;
    private EstudianteItemDB estudianteItemDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agg);

        cedula = findViewById(R.id.LBLCedula);
        nombres = findViewById(R.id.LBLnombre);
        apellidos = findViewById(R.id.LBLapellidos);
        fechaNac = findViewById(R.id.LBLfechaNac);
        facultad = findViewById(R.id.LBLmateria);
        ciudad = findViewById(R.id.LBLCiudad);
        agg = findViewById(R.id.agg);
        estudianteItemDB = new EstudianteItemDB(this);

        agg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cedula.getText().toString().isEmpty()){
                }if (nombres.getText().toString().isEmpty()){
                }if (apellidos.getText().toString().isEmpty()){
                }if (fechaNac.getText().toString().isEmpty()) {
                }if (facultad.getText().toString().isEmpty()){
                }else if (ciudad.getText().toString().isEmpty()){

                }else {
                    estudianteItemDB.inserProf(cedula.getText().toString(), nombres.getText().toString(), apellidos.getText().toString(), fechaNac.getText().toString(), facultad.getText().toString(), ciudad.getText().toString());
                    Toast.makeText(AGG.this, "PROFESOR INSERTADO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
