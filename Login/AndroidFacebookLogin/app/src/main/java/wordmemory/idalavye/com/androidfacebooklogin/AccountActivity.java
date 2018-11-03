package wordmemory.idalavye.com.androidfacebooklogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity {

    private Button mLogoutButton;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        mLogoutButton = findViewById(R.id.logout);

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                LoginManager.getInstance().logOut();

                updateUI();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser ==null){
            updateUI();
        }
    }

    private void updateUI() {

        Intent accountIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(accountIntent);
        finish();
    }
}
