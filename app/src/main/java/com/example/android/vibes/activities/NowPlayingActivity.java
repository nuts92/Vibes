package com.example.android.vibes.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.example.android.vibes.R;
import com.example.android.vibes.data_models.Song;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

/**
 * This class displays the NowPlayingActivity Screen where the user can listen to the song of his/her choice.
 */
public class NowPlayingActivity extends AppCompatActivity {

    //Declaring the songName, the currentSong, and the songsCollectionReference Object Variables
    private String songName;

    private Song currentSong;

    private CollectionReference songsCollectionReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //Declaring and initializing all the Object Variables
        ConstraintLayout rootView = findViewById(R.id.now_playing_root_view);

        ImageView albumCoverView = findViewById(R.id.album_two_photo);

        TextView songNameView = findViewById(R.id.song_two_title);

        //Set the checked state of the songNameView to true.
        songNameView.setSelected(true);

        TextView artistNameView = findViewById(R.id.artist_two_title);

        final ToggleButton likeButton = findViewById(R.id.like_button);

        final ToggleButton playButton = findViewById(R.id.play_button);

        // Set whether home should be displayed as an "up" affordance. Set this to true if selecting "home" returns up by a single level in your UI
        // rather than back to the top level or front page.
        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //Get the intent that started this activity and store it inside an intent object variable.
        Intent intent = getIntent();

        //Retrieve extended data from the intent which is the song object.
        currentSong = intent.getParcelableExtra("song");

        //Declaring and initializing the albumResourceId, songName, artistName, and songBackground variables
        int albumResourceId = 0;

        songName = "";

        String artistName = "";

        int songBackground = 0;

        if (currentSong != null) {

            albumResourceId = currentSong.getAlbumCover();

            songName = currentSong.getSongName();

            artistName = currentSong.getArtistName();

            songBackground = currentSong.getSongBackground();
        }

        //Setting the right background for the rootView layout and the right text and images on these object variables
        rootView.setBackgroundResource(songBackground);

        albumCoverView.setImageResource(albumResourceId);

        songNameView.setText(songName);

        artistNameView.setText(artistName);

        //Attaching an OnCheckedChangeListener to the playButton that determines the behavior that will happen when the user
        //clicks on that button. This registers a callback to be invoked when the checked state of this button changes.
        playButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    playButton.setBackgroundResource(R.drawable.ic_pause);

                } else {

                    playButton.setBackgroundResource(R.drawable.ic_play_white);
                }
            }
        });

        //Declaring and initializing an instance of FirebaseFirestore database
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //Declaring and initializing an instance of Firebase Auth
        FirebaseAuth auth = FirebaseAuth.getInstance();

        //Initializing an instance of FirebaseUser then check if the user is already signed in and not null
        FirebaseUser currentUser = auth.getCurrentUser();

        String userId = "";

        if (currentUser != null) {

            //Get the userId from the currentUser and this Id is unique for every user and will be used to store data and retrieve it from FirebaseFirestore database
            userId = currentUser.getUid();
        }

        //Initializing an instance of a CollectionReference called songsCollectionReference which references a collection called
        //"Songs" that stores all the favorite songs of the current user. The "Songs" collection is stored inside the user document
        // which is named after the unique userId and all users' documents are stored in a collection called "Users"
        songsCollectionReference = db.collection("Users").document(userId).collection("Songs");

        //If the current song displayed already exists in the Songs Collection of this user then the likeButton will be displayed as checked
        songsCollectionReference.document(songName).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                if (e != null) {

                    Log.e("NowPlayingActivity", e.toString());
                    return;
                }

                if (documentSnapshot != null) {

                    Song retrievedSong = documentSnapshot.toObject(Song.class);

                    if (retrievedSong != null) {

                        if (currentSong.getSongId() == retrievedSong.getSongId()) {

                            likeButton.setChecked(true);

                            likeButton.setBackgroundResource(R.drawable.ic_like);
                        }
                    }
                }
            }
        });

        //Attaching an OnCheckedChangeListener to the likeButton that determines the behavior that will happen when the user
        //clicks on that button. If the user clicks on the likeButton then the current song will be stored in the Firestore database
        //and will be displayed in the user's library. However, if the user unchecked the likeButton then the song will be removed from the database and from the user library
        likeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    likeButton.setBackgroundResource(R.drawable.ic_like);

                    songsCollectionReference.document(songName).set(currentSong).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                            Log.d("NowPlayingActivity", "song is saved successfully in database");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Log.e("NowPlayingActivity", e.toString());
                        }
                    });

                } else {

                    likeButton.setBackgroundResource(R.drawable.ic_unlike);

                    songsCollectionReference.document(songName).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                            Log.d("NowPlayingActivity", "song is deleted successfully from database");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Log.e("NowPlayingActivity", e.toString());
                        }
                    });
                }
            }
        });
    }

    /**
     * This method is called whenever an item in the options menu is selected.
     *
     * @param item MenuItem: The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            onBackPressed();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
