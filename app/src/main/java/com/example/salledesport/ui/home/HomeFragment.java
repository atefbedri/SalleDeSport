package com.example.salledesport.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.salledesport.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class HomeFragment extends Fragment {

    private FirebaseAuth mAuth;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user =mAuth.getCurrentUser();

        TextView userName =  root.findViewById(R.id.nameUser);
        TextView userEmail = root.findViewById(R.id.emailUser);
        ImageView userImage = root.findViewById(R.id.imageUser);

        if (user != null)
        {
            userName.setText(user.getDisplayName());
            userEmail.setText(user.getEmail());
            assert user.getPhotoUrl() != null;
            //Glide.with(this).load(user.getPhotoUrl().toString()).into(userImage);
            Log.e("HOmefragment", user.getPhotoUrl().toString());
            Picasso.get().load(user.getPhotoUrl().toString()).into(userImage);
        }
        else
        {
            Toast.makeText(getContext(), "Erreur", Toast.LENGTH_SHORT).show();
        }

        return root;
    }
}