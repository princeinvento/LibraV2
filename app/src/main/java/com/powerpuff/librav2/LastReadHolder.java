package com.powerpuff.librav2;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LastReadHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView book_name,type;

    public LastReadHolder(@NonNull View itemView, ImageView imageView, TextView book_name, TextView type) {
        super(itemView);
        this.imageView = imageView;
        this.book_name = book_name;
        this.type = type;
    }

    public LastReadHolder(@NonNull View itemView) {

        super(itemView);
        imageView = itemView.findViewById(R.id.img);
        book_name = itemView.findViewById(R.id.book_name);
        type = itemView.findViewById(R.id.type);
    }


}
