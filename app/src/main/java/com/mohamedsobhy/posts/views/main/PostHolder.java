package com.mohamedsobhy.posts.views.main;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mohamedsobhy.posts.R;


public class PostHolder extends RecyclerView.ViewHolder {

    public TextView titleTextView;
    public TextView bodyTextView;
    public CardView container;

    public PostHolder(@NonNull View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.titleTextView);
        bodyTextView = itemView.findViewById(R.id.bodyTextView);
        container = itemView.findViewById(R.id.container);
    }
}
