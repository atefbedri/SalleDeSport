package com.example.salledesport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class list extends AppCompatActivity {

    protected ListView maListViewPerso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Récupération de la "ListView" créée dans le fichier activity_main.xml
        maListViewPerso = findViewById(R.id.listviewperso);

        // Création de la "ArrayList" qui nous permettra de remplir la "ListView"
        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();

        // On déclare la "HashMap" qui contiendra les informations pour un item
        HashMap<String, String> map;

        // Création d'une "HashMap" pour insérer les informations du premier item de notre "ListView"
        map = new HashMap<>();
        // On insère un élément "titre" que l'on récupérera dans le "TextView titre" créé dans le fichier affichage_item.xml
        map.put("titre", "basicburpees");
        // On insère la "référence" à l'image (convertit en String car normalement c'est un int) que l'on récupérera dans le "ImageView" créé dans le fichier affichage_item.xml
        map.put("img", String.valueOf(R.mipmap.basicburpees));
        // Enfin on ajoute cette "HashMap" dans la "ArrayList"
        listItem.add(map);

        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),
                listItem,
                R.layout.activity_list,
                new String[]{"img", "titre"},
                new int[]{R.id.img, R.id.titre});

        // On attribue à notre "ListView" l'adapter que l'on vient de créer
        maListViewPerso.setAdapter(adapter);


    }
}
