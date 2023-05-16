package com.powerpuff.librav2;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class LastReadAdapter  extends RecyclerView.Adapter<LastReadHolder> {
    Context context;
    ArrayList<BooksLastRead> book,bookfull;

    public LastReadAdapter(Context context, ArrayList<BooksLastRead> books) {
        this.book = books;
        this.context = context;
        bookfull = new ArrayList<>(book);
    }

    @NonNull
    @Override
    public LastReadHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LastReadHolder(LayoutInflater.from(context).inflate(R.layout.last_read_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LastReadHolder holder, int position) {
        holder.book_name.setText(book.get(position).getBookname());
        holder.type.setText(book.get(position).getType());
        String path = String.valueOf(book.get(position).getPath());
        holder.book_name.setOnClickListener(v -> {
            Intent intent = new Intent(context,PDFactivity.class);
            intent.putExtra("path",path);
            context.startActivity(intent);
        });
        Glide.with(context).asBitmap().load(book.get(position).getImgurl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return book.size();
    }

    public Filter getFilter() {
        return bookFilter;
    }

    private Filter bookFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<BooksLastRead> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(bookfull);
            }
            else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(BooksLastRead book : bookfull){
                    if(book.getBookname().toLowerCase().contains(filterPattern)){
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
