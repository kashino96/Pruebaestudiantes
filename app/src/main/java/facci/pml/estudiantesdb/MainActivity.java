package facci.pml.estudiantesdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.QuickContactBadge;

import java.util.ArrayList;

import facci.pml.estudiantesdb.adaptador.EstudianteAdapter;
import facci.pml.estudiantesdb.database.AGG;
import facci.pml.estudiantesdb.database.Modelo.Estudiante;
import facci.pml.estudiantesdb.database.entities.EstudianteItemDB;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button agg;
    private EstudianteItemDB estudianteItemDB;
    private EstudianteAdapter estudianteAdapter;
    private ArrayList<Estudiante> estudianteArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.ListViewE);

        agg = (Button)findViewById(R.id.AggE);
        estudianteItemDB = new EstudianteItemDB(this);

        estudianteArrayList.addAll(estudianteItemDB.getAllItems());

        estudianteAdapter = new EstudianteAdapter(this, estudianteArrayList);

        listView.setAdapter(estudianteAdapter);

        agg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AGG.class));
            }
        });


    }
}
