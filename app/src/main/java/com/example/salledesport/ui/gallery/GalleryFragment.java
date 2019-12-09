package com.example.salledesport.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salledesport.FirebaseDatabaseHelper;
import com.example.salledesport.R;
import com.example.salledesport.RecyclerView_Config;
import com.example.salledesport.Séance;

import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private RecyclerView mRecyclerView;


    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_activite, container, false);

        mRecyclerView=root.findViewById(R.id.recyclerview_seance);
        new FirebaseDatabaseHelper().readSeance(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Séance> seances, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView,getContext(),seances,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

        return root;
    }
}