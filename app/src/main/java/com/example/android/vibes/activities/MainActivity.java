package com.example.android.vibes.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.android.vibes.R;
import com.example.android.vibes.data_models.UserData;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

/**
 * This class displays the MainActivity Screen that appears after the user has signed in successfully to the app where the user can
 * navigate between different sections including Explore Music Section, Library Section, and Profile Section.
 */
public class MainActivity extends AppCompatActivity {

    //Declaring instances of FirebaseUser and DocumentReference Object Variables
    private FirebaseUser currentUser;

    private DocumentReference userDocumentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaring and initializing the bottomNavigationView object variable
        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);

        //Declaring and initializing the navController object variable
        NavController navController = Navigation.findNavController(this, R.id.fragment_container);

        ///Sets up the bottomNavigationView for use with the mNavController. This will call onNavDestinationSelected(MenuItem, NavController) when a menu item is selected.
        //The selected item in the bottomNavigationView will be automatically updated when the destination changes.
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        //Adds an OnDestinationChangedListener to the navController to receive a callback whenever the getCurrentDestination() or its arguments change.
        //Here we specify if the destination is the EditProfileFragment then hide the bottomNavigationView
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.editProfileFragment) {

                    bottomNavigationView.setVisibility(View.GONE);

                } else {

                    bottomNavigationView.setVisibility(View.VISIBLE);
                }
            }
        });

        //Declaring and initializing an instance of Firebase Auth
        FirebaseAuth auth = FirebaseAuth.getInstance();

        //Declaring and initializing an instance of FirebaseFirestore database
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //Initializing an instance of FirebaseUser then check if the user is already signed in and not null
        currentUser = auth.getCurrentUser();

        //Get the userId from the currentUser and this Id is unique for every user and will be used to store data and get it from FirebaseFirestore database
        String userId = "";

        if (currentUser != null) {

            userId = currentUser.getUid();
        }

        //Check if the user has data stored in Firestore database by initializing a userDocumentReference based on the unique userId,
        //the user data is stored in a document and the name of the document is the unique userId in a collection called "Users"
        userDocumentReference = db.collection("Users").document(userId);

        //Get the user document which contains information including updated name, email, photo, etc.
        userDocumentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                if (e != null) {
                    Log.e("MainActivity", e.toString());
                    return;
                }

                //Retrieve the user data by creating a retrievedData object from the documentSnapshot which is basically a snapshot of the user document
                if (documentSnapshot != null) {

                    UserData retrievedData = documentSnapshot.toObject(UserData.class);

                    //check if there is data stored and not null. If the data is null then this means that the user is new so we will create a user profile
                    //by creating a user document in Firestore so that it will be used to display and store data. However if data is not null, we won't do anything.
                    if (retrievedData == null) {

                        createUserProfile();
                    }
                }
            }
        });
    }

    /**
     * This method creates a user document in the FirebaseFirestore database in case the user is a new one by extracting the user
     * data from the FirebaseAuth instance.
     */
    private void createUserProfile() {

        String userName = currentUser.getDisplayName();

        String userEmail = currentUser.getEmail();

        //check if the user has a photo because if the user has signed up with the email option, he/she won't have a photo to be displayed
        String userProfilePhoto = null;

        if (currentUser.getPhotoUrl() != null) {

            userProfilePhoto = currentUser.getPhotoUrl().toString();
        }

        //Declaring and initializing a userData Object Variable that stores the user name, email, and photo if it exists to be passed to the database
        UserData userData = new UserData(userName, userEmail, userProfilePhoto);

        //Storing UserData by creating a User Document in Firestore database that will include the user name, the email, and the profile photo if it exists.
        //The user data will be stored in a document and the name of the document is the unique userId in a collection called "Users
        userDocumentReference.set(userData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                Log.d("MainActivity", "User data is saved in Firestore successfully");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Log.e("MainActivity", e.toString());
            }
        });
    }
}
