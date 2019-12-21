package com.example.salledesport.ui.gymnastique;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.salledesport.R;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class gymnastique extends Fragment {

    private ListView listGym;

    public gymnastique() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_gymnastique, container, false);


        // Récupération de la "ListView" créée dans le fichier activity_main.xml
        listGym = root.findViewById(R.id.list_gym);

        // Création de la "ArrayList" qui nous permettra de remplir la "ListView"
        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();

        // On déclare la "HashMap" qui contiendra les informations pour un item
        HashMap<String, String> item;

        // Création d'une "HashMap" pour insérer les informations du premier item de notre "ListView"
        String[] title = new String[]{
                getResources().getString(R.string.atr1),
                getResources().getString(R.string.atr2),
                getResources().getString(R.string.appui1),
                getResources().getString(R.string.appui2)};
        // Icones (images) des items
        String[] icon = new String[]{
                String.valueOf(R.drawable.atr_ventre_au_mur),
                String.valueOf(R.drawable.atr_forcee),
                String.valueOf(R.drawable.en_appui_faciale),
                String.valueOf(R.drawable.en_appui_faciale_bassin_haut)};


        // Creation des items de la liste
        for (int i = 0; i < 4; i++) {
            item = new HashMap<>();
            // Titre
            item.put("title", title[i]);

            // Icone
            item.put("icon", icon[i]);
            listItem.add(item);

            SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                    listItem,
                    R.layout.activity_list,
                    new String[]{"title", "icon"},
                    new int[]{R.id.titre, R.id.img});
            // Association de l’adapter à la liste
            listGym.setAdapter(adapter);
        }

        listGym.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap item = (HashMap) listGym.getItemAtPosition(position);
                Toast.makeText(getActivity(), "" + item.get("title"), Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

}
