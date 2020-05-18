package com.example.android.vibes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android.vibes.R;
import com.example.android.vibes.adapters.SongAdapter;
import com.example.android.vibes.data_models.Category;
import com.example.android.vibes.data_models.Song;
import java.util.ArrayList;

/**
 * This class displays the SongsListActivity Screen that displays a list of songs based on the category that the user has chosen
 * in the Explore Section
 */
public class SongsListActivity extends AppCompatActivity {

    //Declaring the songsList Object variable
    private ArrayList<Song> songsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);

        //Declaring and initializing all Object Variables
        ImageView displayedImage = findViewById(R.id.songs_list_introduction_image);

        TextView displayedTitle = findViewById(R.id.songs_list_introduction_title);

        TextView displayedDescription = findViewById(R.id.songs_list_introduction_description);

        //Get the intent that started this activity and store it inside an intent object variable.
        Intent intent = getIntent();

        //Retrieve extended data from the intent which is the category object.
        Category category = intent.getParcelableExtra("category");

        //Declaring and initializing the categoryImage, actionBarTitle, categoryTitle, and categoryDescription variables
        int categoryImage = 0;

        String actionBarTitle = "";

        String categoryTitle = "";

        String categoryDescription = "";

        if (category != null) {

            actionBarTitle = category.getActionBarTitle();

            categoryImage = category.getCategoryImage();

            categoryTitle = category.getCategoryTitle();

            categoryDescription = category.getCategoryDescription();

            songsList = category.getSongsList();
        }

        //Setting the right title text on the activity's action bar
        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle(actionBarTitle);
        }

        //Setting the right image and the right text on these object variables
        displayedImage.setImageResource(categoryImage);

        displayedTitle.setText(categoryTitle);

        displayedDescription.setText(categoryDescription);

        //Declaring and initializing the recyclerView Object Variable.
        RecyclerView recyclerView = findViewById(R.id.songs_list_recycler_view);

        //Declaring and initializing the layoutManager that the recyclerView will use
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        //Set the layoutManager that the recyclerView will use
        recyclerView.setLayoutManager(layoutManager);

        //This setting improves performance if the changes in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        //Declaring and initializing the adapter object variable
        SongAdapter adapter = new SongAdapter(songsList, R.layout.list_item);

        //Attaching the adapter to the recyclerView with the setAdapter() method.
        recyclerView.setAdapter(adapter);

        //Setting an OnItemClickListener to the adapter that determines the behavior that will happen when the user
        //clicks on the playButton
        adapter.setOnItemClickListener(new SongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                //Declaring and initializing a currentSong object which is the element at the specified position in the songsList.
                Song currentSong = songsList.get(position);

                //Opening the NowPlayingActivity using an intent and passing the currentSong object in this intent through the putExtra method
                Intent intent = new Intent(SongsListActivity.this, NowPlayingActivity.class);

                intent.putExtra("song", currentSong);

                startActivity(intent);
            }
        });
    }
}
