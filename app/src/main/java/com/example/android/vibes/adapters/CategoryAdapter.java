package com.example.android.vibes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android.vibes.R;
import com.example.android.vibes.data_models.Category;
import java.util.ArrayList;

/**
 * This Class provides the Adapter to populate items/cards inside of the RecyclerView.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    //Declaring the mListener and mCategoriesList Object Instances
    private CategoryAdapter.OnItemClickListener mListener;

    private ArrayList<Category> mCategoriesList;

    /**
     * This constructor is used to create an instance of the CategoryAdapter using the categoriesList as an input
     *
     * @param categoriesList ArrayList<Category>: the ArrayList of categories' objects which will be passed to the adapter
     */
    public CategoryAdapter(ArrayList<Category> categoriesList) {

        mCategoriesList = categoriesList;
    }

    /**
     * This method is called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
     *
     * @param parent   ViewGroup: The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType int: The view type of the new View.
     * @return CategoryViewHolder: A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);

        return new CategoryViewHolder(itemView);
    }

    /**
     * This method is called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the itemView to reflect the item at the given position.
     *
     * @param holder   CategoryViewHolder: The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position int: The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        Category category = mCategoriesList.get(position);

        holder.categoryImage.setImageResource(category.getCategoryImage());
    }

    /**
     * This method returns the size of the collection/ArrayList that contains the items we want to display.
     *
     * @return int: the number of items in the mCategoriesList
     */
    @Override
    public int getItemCount() {
        return mCategoriesList.size();
    }

    /**
     * This class represents a ViewHolder called CategoryViewHolder that describes an item view and metadata about its place within the RecyclerView.
     */
    class CategoryViewHolder extends RecyclerView.ViewHolder {

        //Declaring the categoryImage Object Variable
        ImageView categoryImage;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            //Initializing the categoryImage Object Variable
            categoryImage = itemView.findViewById(R.id.category_image);

            //Attaching an OnClickListener to the itemView that determines the behavior that will happen when the user
            //clicks on that view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Get the Adapter position of the item represented by this CategoryViewHolder
                    int position = getAdapterPosition();

                    //call onItemClick method on the mListener and pass the position
                    if (position != RecyclerView.NO_POSITION && mListener != null) {

                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }

    /**
     * This interface will be used to send data from the adapter to the underlying activity or fragment that implements this interface
     */
    public interface OnItemClickListener {

        void onItemClick(int position);
    }

    /**
     * This method will be used to set the OnItemClickListener to the CategoryAdapter
     *
     * @param listener CategoryAdapter.OnItemClickListener as an input parameter
     */
    public void setOnItemClickListener(CategoryAdapter.OnItemClickListener listener) {

        mListener = listener;
    }
}
