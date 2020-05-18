package com.example.android.vibes.data_models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.firestore.ServerTimestamp;
import java.util.Date;

/**
 * This class is a Data Model Class that stores the Song Data and it follows the JavaBean naming pattern which allows Firestore
 * to automatically map values when getting and setting data. The rules that the pattern follows are that:
 * Getter and Setter methods are defined which are strictly named to what variable they correspond to (for example: getName() provides the name field).
 * An extra empty constructor is also defined which lets Firestore do the automatic data mapping.
 * Note that even if there are methods that appear as if they are not used, they are actually used by Firestore for example getTimestamp and setTimestamp
 */
public class Song implements Parcelable {

    private String songName;

    private String artistName;

    private int albumCover;

    private int songId;

    private int songBackground;

    private Date timestamp;

    public Song() {
        //empty constructor is required for Firestore's automatic data mapping.
    }

    public Song(String songName, String artistName, int albumCover, int songId, int songBackground) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumCover = albumCover;
        this.songId = songId;
        this.songBackground = songBackground;
    }

    protected Song(Parcel in) {
        songName = in.readString();
        artistName = in.readString();
        albumCover = in.readInt();
        songId = in.readInt();
        songBackground = in.readInt();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(int albumCover) {
        this.albumCover = albumCover;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getSongBackground() {
        return songBackground;
    }

    public void setSongBackground(int songBackground) {
        this.songBackground = songBackground;
    }

    @ServerTimestamp
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(songName);
        dest.writeString(artistName);
        dest.writeInt(albumCover);
        dest.writeInt(songId);
        dest.writeInt(songBackground);
    }
}

