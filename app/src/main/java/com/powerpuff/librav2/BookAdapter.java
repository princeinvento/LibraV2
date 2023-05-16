package com.powerpuff.librav2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {

    Context context;
    ArrayList<Books> book,bookfull;

    public BookAdapter(Context context, ArrayList<Books> book) {
        this.context = context;
        this.book = book;
        bookfull = new ArrayList<>(book);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.book_name.setText(book.get(position).getBook_name());
        holder.author.setText(book.get(position).getAuthor());
        holder.content.setText(book.get(position).getContent());
        Glide.with(context).asBitmap().load(book.get(position).getImgurl()).into(holder.imageView);
        String path = String.valueOf(book.get(position).getPath());
        holder.open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PDFactivity.class);
                intent.putExtra("path",path);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return book.size();
    }

    @Override
    public Filter getFilter() {
        return bookFilter;
    }

    private Filter bookFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Books> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(bookfull);
            }
            else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Books book : bookfull){
                    if(book.getBook_name().toLowerCase().contains(filterPattern)){
                        filteredList.add(book);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            book.clear();
            book.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };
}
