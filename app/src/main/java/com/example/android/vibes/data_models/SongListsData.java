package com.example.android.vibes.data_models;

import android.content.Context;
import com.example.android.vibes.R;
import java.util.ArrayList;

/**
 * This class is a Data Model Class that stores all the songs' lists basically Dummy Data including the popular songs' list, the trending songs' list,
 * the morning songs' list, the evening songs' list, the relax songs' list, and the driving songs' list.
 */
public class SongListsData {

    /**
     * This method creates and returns the popular songs' list
     *
     * @param context context which allows access to application-specific resources and classes
     * @return ArrayList<Song>: the popularList object Variable
     */
    public static ArrayList<Song> getPopularList(Context context) {

        ArrayList<Song> popularList = new ArrayList<>();

        popularList.add(new Song(context.getString(R.string.popular_song_one_name), context.getString(R.string.popular_song_one_artist), R.drawable.sonet_el_hayah, 1, R.drawable.gradient_purple));

        popularList.add(new Song(context.getString(R.string.popular_song_two_name), context.getString(R.string.popular_song_two_artist), R.drawable.enta_el_nos5a_el_aslya, 2, R.drawable.gradient_green));

        popularList.add(new Song(context.getString(R.string.popular_song_three_name), context.getString(R.string.popular_song_three_artist), R.drawable.saved_my_life, 3, R.drawable.gradient_purple_mix));

        popularList.add(new Song(context.getString(R.string.popular_song_four_name), context.getString(R.string.popular_song_four_artist), R.drawable.skechers_dripreport, 4, R.drawable.gradient_purple));

        popularList.add(new Song(context.getString(R.string.popular_song_five_name), context.getString(R.string.popular_song_five_artist), R.drawable.stuck_with_you, 5, R.drawable.gradient_green));

        popularList.add(new Song(context.getString(R.string.popular_song_six_name), context.getString(R.string.popular_song_six_artist), R.drawable.wassellik_khabar, 6, R.drawable.gradient_purple_mix));

        return popularList;
    }

    /**
     * This method creates and returns the trending songs' list
     *
     * @param context context which allows access to application-specific resources and classes
     * @return ArrayList<Song>: the trendingList object Variable
     */
    public static ArrayList<Song> getTrendingList(Context context) {

        ArrayList<Song> trendingList = new ArrayList<>();

        trendingList.add(new Song(context.getString(R.string.trending_song_one_name), context.getString(R.string.trending_song_one_artist), R.drawable.summer_feelings, 7, R.drawable.gradient_purple));

        trendingList.add(new Song(context.getString(R.string.trending_song_two_name), context.getString(R.string.trending_song_two_artist), R.drawable.higher_ground, 8, R.drawable.gradient_green));

        trendingList.add(new Song(context.getString(R.string.trending_song_three_name), context.getString(R.string.trending_song_three_artist), R.drawable.lose_somebody, 9, R.drawable.gradient_purple_mix));

        trendingList.add(new Song(context.getString(R.string.trending_song_four_name), context.getString(R.string.trending_song_four_artist), R.drawable.time, 10, R.drawable.gradient_purple));

        trendingList.add(new Song(context.getString(R.string.trending_song_five_name), context.getString(R.string.trending_song_five_artist), R.drawable.say_so, 11, R.drawable.gradient_green));

        trendingList.add(new Song(context.getString(R.string.trending_song_six_name), context.getString(R.string.trending_song_six_artist), R.drawable.gooba, 12, R.drawable.gradient_purple_mix));

        return trendingList;
    }

    /**
     * This method creates and returns the morning songs' list
     *
     * @param context context which allows access to application-specific resources and classes
     * @return ArrayList<Song>: the morningList object Variable
     */
    public static ArrayList<Song> getMorningList(Context context) {

        ArrayList<Song> morningList = new ArrayList<>();

        morningList.add(new Song(context.getString(R.string.morning_song_one_name), context.getString(R.string.morning_song_one_artist), R.drawable.sabah_el_kheir, 13, R.drawable.gradient_purple));

        morningList.add(new Song(context.getString(R.string.morning_song_two_name), context.getString(R.string.morning_song_two_artist), R.drawable.shayef_el_bahr, 14, R.drawable.gradient_green));

        morningList.add(new Song(context.getString(R.string.morning_song_three_name), context.getString(R.string.morning_song_three_artist), R.drawable.ana_aysha_hala, 15, R.drawable.gradient_purple_mix));

        morningList.add(new Song(context.getString(R.string.morning_song_four_name), context.getString(R.string.morning_song_four_artist), R.drawable.love_drink_coffee, 16, R.drawable.gradient_purple));

        morningList.add(new Song(context.getString(R.string.morning_song_five_name), context.getString(R.string.morning_song_five_artist), R.drawable.sunshine, 17, R.drawable.gradient_green));

        morningList.add(new Song(context.getString(R.string.morning_song_six_name), context.getString(R.string.morning_song_six_artist), R.drawable.sun_rise, 18, R.drawable.gradient_purple_mix));

        return morningList;
    }

    /**
     * This method creates and returns the evening songs' list
     *
     * @param context context which allows access to application-specific resources and classes
     * @return ArrayList<Song>: the eveningList object Variable
     */
    public static ArrayList<Song> getEveningList(Context context) {

        ArrayList<Song> eveningList = new ArrayList<>();

        eveningList.add(new Song(context.getString(R.string.evening_song_one_name), context.getString(R.string.evening_song_one_artist), R.drawable.affirmation, 19, R.drawable.gradient_purple));

        eveningList.add(new Song(context.getString(R.string.evening_song_two_name), context.getString(R.string.evening_song_two_artist), R.drawable.suspirium, 20, R.drawable.gradient_green));

        eveningList.add(new Song(context.getString(R.string.evening_song_three_name), context.getString(R.string.evening_song_three_artist), R.drawable.jungle, 21, R.drawable.gradient_purple_mix));

        eveningList.add(new Song(context.getString(R.string.evening_song_four_name), context.getString(R.string.evening_song_four_artist), R.drawable.am_going_insane, 22, R.drawable.gradient_purple));

        eveningList.add(new Song(context.getString(R.string.evening_song_five_name), context.getString(R.string.evening_song_five_artist), R.drawable.while_you_wait, 23, R.drawable.gradient_green));

        eveningList.add(new Song(context.getString(R.string.evening_song_six_name), context.getString(R.string.evening_song_six_artist), R.drawable.it_will_end_in_tears, 24, R.drawable.gradient_purple_mix));

        return eveningList;
    }

    /**
     * This method creates and returns the relax songs' list
     *
     * @param context context which allows access to application-specific resources and classes
     * @return ArrayList<Song>: the relaxList object Variable
     */
    public static ArrayList<Song> getRelaxList(Context context) {

        ArrayList<Song> relaxList = new ArrayList<>();

        relaxList.add(new Song(context.getString(R.string.relax_song_one_name), context.getString(R.string.relax_song_one_artist), R.drawable.beyond_this_moment, 25, R.drawable.gradient_purple));

        relaxList.add(new Song(context.getString(R.string.relax_song_two_name), context.getString(R.string.relax_song_two_artist), R.drawable.the_mountain_between_us, 26, R.drawable.gradient_green));

        relaxList.add(new Song(context.getString(R.string.relax_song_three_name), context.getString(R.string.relax_song_three_artist), R.drawable.we_all_complete, 27, R.drawable.gradient_purple_mix));

        relaxList.add(new Song(context.getString(R.string.relax_song_four_name), context.getString(R.string.relax_song_four_artist), R.drawable.when_i_looked_up, 28, R.drawable.gradient_purple));

        relaxList.add(new Song(context.getString(R.string.relax_song_five_name), context.getString(R.string.relax_song_five_artist), R.drawable.fargo_main_theme, 29, R.drawable.gradient_green));

        relaxList.add(new Song(context.getString(R.string.relax_song_six_name), context.getString(R.string.relax_song_six_artist), R.drawable.wonder, 30, R.drawable.gradient_purple_mix));

        return relaxList;
    }

    /**
     * This method creates and returns the driving songs' list
     *
     * @param context context which allows access to application-specific resources and classes
     * @return ArrayList<Song>: the drivingList object Variable
     */
    public static ArrayList<Song> getDrivingList(Context context) {

        ArrayList<Song> drivingList = new ArrayList<>();

        drivingList.add(new Song(context.getString(R.string.driving_song_one_name), context.getString(R.string.driving_song_one_artist), R.drawable.dance_monkey, 31, R.drawable.gradient_purple));

        drivingList.add(new Song(context.getString(R.string.driving_song_two_name), context.getString(R.string.driving_song_two_artist), R.drawable.yummy, 32, R.drawable.gradient_green));

        drivingList.add(new Song(context.getString(R.string.driving_song_three_name), context.getString(R.string.driving_song_three_artist), R.drawable.south_of_the_border, 33, R.drawable.gradient_purple_mix));

        drivingList.add(new Song(context.getString(R.string.driving_song_four_name), context.getString(R.string.driving_song_four_artist), R.drawable.goodbyes, 34, R.drawable.gradient_purple));

        drivingList.add(new Song(context.getString(R.string.driving_song_five_name), context.getString(R.string.driving_song_five_artist), R.drawable.cold, 35, R.drawable.gradient_green));

        drivingList.add(new Song(context.getString(R.string.driving_song_six_name), context.getString(R.string.driving_song_six_artist), R.drawable.happier, 36, R.drawable.gradient_purple_mix));

        return drivingList;
    }
}
