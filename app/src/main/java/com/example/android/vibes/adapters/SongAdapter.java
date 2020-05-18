package com.example.android.vibes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.vibes.R;
import com.example.android.vibes.data_models.Song;
import java.util.ArrayList;

/**
 * This Class provides the Adapter to populate items/cards inside of the RecyclerView.
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    //Declaring the mListener, mSongsList, and mItemLayout Object Instances
    private OnItemClickListener mListener;

    private ArrayList<Song> mSongsList;

    private int mItemLayout;

    /**
     * This constructor is used to create an instance of the SongAdapter using two inputs which are the songsList and the itemLayout
     *
     * @param songsList  ArrayList<Song>: the ArrayList of songs' objects which will be passed to the adapter
     * @param itemLayout int: the item layout that will be passed based on whether the items that will be displayed are in the
     *                   ExploreFragment or in the SongsListActivity
     */
    public SongAdapter(ArrayList<Song> songsList, int itemLayout) {

        mSongsList = songsList;

        mItemLayout = itemLayout;
    }

    /**
     * This method is called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
     *
     * @param parent   ViewGroup: The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType int: The view type of the new View.
     * @return SongViewHolder: A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);

        return new SongViewHolder(itemView);
    }

    /**
     * This method is called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the itemView to reflect the item at the given position.
     *
     * @param holder   SongViewHolder: The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position int: The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {

        Song song = mSongsList.get(position);

        //The reason why I check if the reference to the objects is null or not is because we will use two different XML layouts so
        //some objects' instances will be null
        if (holder.albumCover != null) {

            holder.albumCover.setImageResource(song.getAlbumCover());
        }

        if (holder.songName != null) {

            holder.songName.setText(song.getSongName());
        }

        if (holder.artistName != null) {

            holder.artistName.setText(song.getArtistName());
        }

        if (holder.listItemImage != null) {

            holder.listItemImage.setImageResource(song.getAlbumCover());
        }

        if (holder.listItemSongName != null) {

            holder.listItemSongName.setText(song.getSongName());
        }

        if (holder.listItemArtistName != null) {

            holder.listItemArtistName.setText(song.getArtistName());
        }
    }

    /**
     * This method returns the size of the collection/ArrayList that contains the items we want to display.
     *
     * @return int: the number of items in the mSongsList
     */
    @Override
    public int getItemCount() {

        return mSongsList.size();
    }

    /**
     * This class represents a ViewHolder called SongViewHolder that describes an item view and metadata about its place within the RecyclerView.
     */
    class SongViewHolder extends RecyclerView.ViewHolder {

        //Declaring all Object Variables
        ImageView albumCover;

        TextView songName;

        TextView artistName;

        //Declaring object variables of the layout list_item
        ImageView listItemImage;

        TextView listItemSongName;

        TextView listItemArtistName;

        ImageView playButton;

        public SongViewHolder(@NonNull final View itemView) {
            super(itemView);

            //Initializing all object variables
            albumCover = itemView.findViewById(R.id.album_cover);

            songName = itemView.findViewById(R.id.song_name);

            artistName = itemView.findViewById(R.id.artist_name);

            //Initializing object variables of the layout list_item and these can be null if the passed layout is the song_item layout
            listItemImage = itemView.findViewById(R.id.list_item_image);

            listItemSongName = itemView.findViewById(R.id.list_item_song_name);

            listItemArtistName = itemView.findViewById(R.id.list_item_artist_name);

            playButton = itemView.findViewById(R.id.list_item_play_button);

            if (playButton != null) {

                //Attaching an OnClickListener to the playButton that determines the behavior that will happen when the user
                //clicks on that button
                playButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Get the Adapter position of the item represented by this SongViewHolder
                        int position = getAdapterPosition();

                        //call onItemClick method on the mListener and pass the position
                        if (position != RecyclerView.NO_POSITION && mListener != null) {

                            mListener.onItemClick(position);
                        }
                    }
                });
            } else {

                //Attaching an OnClickListener to the itemView that determines the behavior that will happen when the user
                //clicks on that view
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Get the Adapter position of the item represented by this SongViewHolder
                        int position = getAdapterPosition();

                        //call onItemClick method on the mListener and pass the position
                        if (position != RecyclerView.NO_POSITION && mListener != null) {

                            mListener.onItemClick(position);
                        }
                    }
                });
            }
        }
    }

    /**
     * This interface will be used to send data from the adapter to the underlying activity or fragment that implements this interface
     */
    public interface OnItemClickListener {

        void onItemClick(int position);
    }

    /**
     * This method will be used to set the OnItemClickListener to the SongAdapter
     *
     * @param listener SongAdapter.OnItemClickListener as an input parameter
     */
    public void setOnItemClickListener(OnItemClickListener listener) {

        mListener = listener;
    }
}
