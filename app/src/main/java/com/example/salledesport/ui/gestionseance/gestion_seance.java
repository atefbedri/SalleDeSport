package com.example.salledesport.ui.gestionseance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.salledesport.R;
import com.example.salledesport.Seance;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class gestion_seance extends Fragment {

    public gestion_seance() {
        // Required empty public constructor
    }

    EditText date_seance;
    Spinner nom_seance, coach_seance;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    private FirebaseAuth auth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_gestion_seance, container, false);

        date_seance = root.findViewById(R.id.date_de_Seance);
        nom_seance = root.findViewById(R.id.spinner_seance);
        coach_seance = root.findViewById(R.id.spinner_coach);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference().child(user.getUid()+"/Seance");

        root.findViewById(R.id.btn_enregistrer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (date_seance.getText().toString().equals("") || nom_seance.getSelectedItem().toString().equals("") || coach_seance.getSelectedItem().toString().equals(""))
                {
                    Toast.makeText(getContext(), "Erreur", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Seance seance = new Seance(date_seance.getText().toString(), nom_seance.getSelectedItem().toString(), coach_seance.getSelectedItem().toString());
                    reference.push().setValue(seance);
                    Toast.makeText(getContext(), "Seance enregistrée", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

}