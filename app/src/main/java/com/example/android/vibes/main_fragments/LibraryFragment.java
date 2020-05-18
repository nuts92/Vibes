package com.example.android.vibes.main_fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.vibes.R;
import com.example.android.vibes.activities.NowPlayingActivity;
import com.example.android.vibes.adapters.SongAdapter;
import com.example.android.vibes.data_models.Song;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;

/**
 * LibraryFragment subclass displays the list of the user's favorite songs liked by the user.
 */
public class LibraryFragment extends Fragment {

    //Declaring the adapter, the favoriteList, and the recyclerView Object Variables
    private SongAdapter adapter;

    private ArrayList<Song> favoriteList;

    private RecyclerView recyclerView;

    public LibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_library, container, false);

        //Declaring and Initializing the emptyInfoTextView Object Variable
        final TextView emptyInfoTextView = rootView.findViewById(R.id.empty_info_text_view);

        //Declaring and Initializing an instance of FirebaseFirestore database
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //Declaring and Initializing an instance of FirebaseAuth
        FirebaseAuth auth = FirebaseAuth.getInstance();

        //Declaring and Initializing an instance of FirebaseUser then check if the user is already signed in and not null
        FirebaseUser currentUser = auth.getCurrentUser();

        //Get the userId from the currentUser and this Id is unique for every user and will be used to store data and get it from FirebaseFirestore database
        String userId = "";

        if (currentUser != null) {

            userId = currentUser.getUid();
        }

        //Initializing the favoriteList Object Variable
        favoriteList = new ArrayList<>();

        //Declaring and initializing the recyclerView Object Variable.
        recyclerView = rootView.findViewById(R.id.library_recycler_view);

        //Declaring and initializing the layoutManager that the recyclerView will use
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        //Set the layoutManager that the recyclerView will use
        recyclerView.setLayoutManager(layoutManager);

        //This setting improves performance if the changes in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        //Declaring and initializing a query object that displays the data from Firestore ordered by timestamp where the user's favorite songs are stored
        //in a collection called "Songs" inside the user document which is named after the user's uniqueId and all users' documents are stored in a collection called "Users"
        Query query = db.collection("Users").document(userId).collection("Songs").orderBy("timestamp", Query.Direction.DESCENDING);

        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                if (e != null) {

                    Log.e("LibraryFragment", e.toString());
                    return;
                }

                if (queryDocumentSnapshots != null) {

                    //If the number of songs in the "Songs" collection is zero then display the emptyInfoTextView
                    if (queryDocumentSnapshots.getDocuments().size() == 0) {

                        emptyInfoTextView.setVisibility(View.VISIBLE);
                    }

                    //Clear the songs from the favoriteList before starting the loop
                    if (favoriteList.size() > 0) {

                        favoriteList.clear();
                    }

                    //Retrieve all the songs in the user's "Songs" Collection and then add them to the favoriteList
                    for (QueryDocumentSnapshot queryDocumentSnapshot : queryDocumentSnapshots) {

                        Song currentSong = queryDocumentSnapshot.toObject(Song.class);

                        favoriteList.add(currentSong);
                    }

                    //Initializing the adapter object variable
                    adapter = new SongAdapter(favoriteList, R.layout.list_item);

                    //Attaching the adapter to the recyclerView with the setAdapter() method.
                    recyclerView.setAdapter(adapter);

                    //Setting an OnItemClickListener to the adapter that determines the behavior that will happen when the user
                    //clicks on the playButton
                    adapter.setOnItemClickListener(new SongAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {

                            //Declaring and initializing a currentSong object which is the element at the specified position in the favoriteList.
                            Song currentSong = favoriteList.get(position);

                            //Opening the NowPlayingActivity using an intent and passing the currentSong object in this intent through the putExtra method
                            Intent intent = new Intent(getActivity(), NowPlayingActivity.class);

                            intent.putExtra("song", currentSong);

                            startActivity(intent);
                        }
                    });
                }
            }
        });

        return rootView;
    }
}
