package com.example.salledesport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText loginView;
    EditText emailView;
    EditText passwordView;
    EditText passwordView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        //event on click sur le button add user to database
        findViewById(R.id.bSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                loginView = findViewById(R.id.eLogin);
                emailView = findViewById(R.id.eEmail);
                passwordView = findViewById(R.id.eMdp);
                passwordView2 = findViewById(R.id.eCmdp);

                String login = loginView.getText().toString();
                String email = emailView.getText().toString();
                String password = passwordView.getText().toString();
                String confirmPassword = passwordView2.getText().toString();

                if (password != confirmPassword) {
                    Toast.makeText(SignUp.this, "MotPass is not the same", Toast.LENGTH_SHORT).show();

                } else if (password.length() < 8) {
                    Toast.makeText(SignUp.this, "MotPass too short", Toast.LENGTH_SHORT).show();
                } else if (isValidEmail(email)) {
                    Toast.makeText(SignUp.this, "invalid email", Toast.LENGTH_SHORT).show();
                } else {
                    addUser(email, password);
                    goToMain();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    //method add user dans la base
    public void addUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String TAG = "addclient";
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                            //Toast.makeText(SignUp.this, "succ add", Toast.LENGTH_SHORT).show();
                            goToMain();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUp.this, "failed to add", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void goToMain() {
        Intent myIntent = new Intent(this, Main2Activity.class);
        startActivity(myIntent);
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
