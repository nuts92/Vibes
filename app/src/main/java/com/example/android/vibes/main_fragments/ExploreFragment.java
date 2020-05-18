package com.example.android.vibes.main_fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.android.vibes.adapters.CategoryAdapter;
import com.example.android.vibes.R;
import com.example.android.vibes.adapters.SongAdapter;
import com.example.android.vibes.activities.NowPlayingActivity;
import com.example.android.vibes.activities.SongsListActivity;
import com.example.android.vibes.data_models.Category;
import com.example.android.vibes.data_models.Song;
import com.example.android.vibes.data_models.SongListsData;
import java.util.ArrayList;

/**
 * ExploreFragment subclass displays the lists and the categories of songs that are available and is the first fragment screen
 * that is displayed when the MainActivity opens.
 */
public class ExploreFragment extends Fragment {

    //Declaring the popularAdapter and trendingAdapter Object Variables
    private SongAdapter popularAdapter;

    private SongAdapter trendingAdapter;

    public ExploreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_explore, container, false);

        //Declaring and initializing the popularViewButton and the trendingViewAButton object variables
        Button popularViewButton = rootView.findViewById(R.id.popular_view_all_button);

        Button trendingViewAButton = rootView.findViewById(R.id.trending_view_all_button);

        //Declaring and initializing the popularRecyclerView Object Variable
        RecyclerView popularRecyclerView = rootView.findViewById(R.id.popular_recycler_view);

        //Declaring and initializing the popularLayoutManager that the popularRecyclerView will use
        LinearLayoutManager popularLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);

        //Set the popularLayoutManager as the layoutManager that the popularRecyclerView will use
        popularRecyclerView.setLayoutManager(popularLayoutManager);

        //This setting improves performance if the changes in content do not change the layout size of the RecyclerView
        popularRecyclerView.setHasFixedSize(true);

        //Declaring and initializing the trendingRecyclerView Object Variable
        RecyclerView trendingRecyclerView = rootView.findViewById(R.id.trending_recycler_view);

        //Declaring and initializing the trendingLayoutManager that the trendingRecyclerView will use
        LinearLayoutManager trendingLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);

        //Set the trendingLayoutManager as the layoutManager that the trendingRecyclerView will use
        trendingRecyclerView.setLayoutManager(trendingLayoutManager);

        //This setting improves performance if the changes in content do not change the layout size of the RecyclerView
        trendingRecyclerView.setHasFixedSize(true);

        if (getActivity() != null) {

            //Initializing the popularAdapter and the trendingAdapter Object Variables
            popularAdapter = new SongAdapter(SongListsData.getPopularList(getActivity()), R.layout.song_item);

            trendingAdapter = new SongAdapter(SongListsData.getTrendingList(getActivity()), R.layout.song_item);
        }

        //Attaching the popularAdapter to the popularRecyclerView with the setAdapter() method.
        popularRecyclerView.setAdapter(popularAdapter);

        //Attaching the trendingAdapter to the trendingRecyclerView with the setAdapter() method.
        trendingRecyclerView.setAdapter(trendingAdapter);

        //Declaring and initializing an instance of ArrayList<Category> called categories and adding categories' objects to this ArrayList.
        final ArrayList<Category> categories = new ArrayList<>();

        categories.add(new Category(getString(R.string.morning_category_action_bar_title), getString(R.string.morning_category_title), getString(R.string.morning_category_description), R.drawable.morning_background, SongListsData.getMorningList(getActivity())));

        categories.add(new Category(getString(R.string.evening_category_action_bar_title), getString(R.string.evening_category_title), getString(R.string.evening_category_description), R.drawable.evening_background, SongListsData.getEveningList(getActivity())));

        categories.add(new Category(getString(R.string.relax_category_action_bar_title), getString(R.string.relax_category_title), getString(R.string.relax_category_description), R.drawable.relax_background, SongListsData.getRelaxList(getActivity())));

        categories.add(new Category(getString(R.string.driving_category_action_bar_title), getString(R.string.driving_category_title), getString(R.string.driving_category_description), R.drawable.driving_background, SongListsData.getDrivingList(getActivity())));

        //Attaching an OnClickListener to the popularViewButton that determines the behavior that will happen when the user
        //clicks on that button
        popularViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getActivity() != null) {

                    //Declaring and initializing a popular object
                    Category popular = new Category(getString(R.string.popular_category_action_bar_title), getString(R.string.popular_category_title), getString(R.string.popular_category_description), R.drawable.popular_background, SongListsData.getPopularList(getActivity()));

                    //Opening the SongsListActivity using an intent and passing the popular object in this intent through the putExtra method
                    Intent intent = new Intent(getActivity(), SongsListActivity.class);

                    intent.putExtra("category", popular);

                    startActivity(intent);
                }
            }
        });

        //Attaching an OnClickListener to the trendingViewAButton that determines the behavior that will happen when the user
        //clicks on that button
        trendingViewAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getActivity() != null) {

                    //Declaring and initializing a trending object
                    Category trending = new Category(getString(R.string.trending_category_action_bar_title), getString(R.string.trending_category_title), getString(R.string.trending_category_description), R.drawable.trending_background, SongListsData.getTrendingList(getActivity()));

                    //Opening the SongsListActivity using an intent and passing the trending object in this intent through the putExtra method
                    Intent intent = new Intent(getActivity(), SongsListActivity.class);

                    intent.putExtra("category", trending);

                    startActivity(intent);
                }
            }
        });

        //Declaring and initializing the categoriesRecyclerView Object Variable
        RecyclerView categoriesRecyclerView = rootView.findViewById(R.id.categories_recycler_view);

        //Set the layoutManager that the categoriesRecyclerView will use
        categoriesRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        //This setting improves performance if the changes in content do not change the layout size of the RecyclerView
        categoriesRecyclerView.setHasFixedSize(true);

        //Declaring and initializing the categoryAdapter object variable
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);

        //Attaching the categoryAdapter to the categoriesRecyclerView with the setAdapter() method.
        categoriesRecyclerView.setAdapter(categoryAdapter);

        //Setting an OnItemClickListener to the categoryAdapter that determines the behavior that will happen when the user
        //clicks on the view
        categoryAdapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                //Declaring and initializing a category object which is the element at the specified position in the categories.
                Category category = categories.get(position);

                //Opening the SongsListActivity using an intent and passing the category object in this intent through the putExtra method
                Intent intent = new Intent(getActivity(), SongsListActivity.class);

                intent.putExtra("category", category);

                startActivity(intent);
            }
        });

        //Setting an OnItemClickListener to the popularAdapter that determines the behavior that will happen when the user
        //clicks on the view
        popularAdapter.setOnItemClickListener(new SongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                if (getActivity() != null) {

                    //Declaring and initializing a currentSong object which is the element at the specified position in the list.
                    Song currentSong = SongListsData.getPopularList(getActivity()).get(position);

                    //Opening the NowPlayingActivity using an intent and passing the currentSong object in this intent through the putExtra method
                    Intent intent = new Intent(getActivity(), NowPlayingActivity.class);

                    intent.putExtra("song", currentSong);

                    startActivity(intent);
                }
            }
        });

        //Setting an OnItemClickListener to the trendingAdapter that determines the behavior that will happen when the user
        //clicks on the view
        trendingAdapter.setOnItemClickListener(new SongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                if (getActivity() != null) {

                    //Declaring and initializing a currentSong object which is the element at the specified position in the list.
                    Song currentSong = SongListsData.getTrendingList(getActivity()).get(position);

                    //Opening the NowPlayingActivity using an intent and passing the currentSong object in this intent through the putExtra method
                    Intent intent = new Intent(getActivity(), NowPlayingActivity.class);

                    intent.putExtra("song", currentSong);

                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}