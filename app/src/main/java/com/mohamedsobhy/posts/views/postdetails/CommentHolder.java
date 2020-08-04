package com.mohamedsobhy.posts.views.postdetails;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohamedsobhy.posts.R;


public class CommentHolder extends RecyclerView.ViewHolder {

    public TextView nameTextView;
    public TextView emailTextView;
    public TextView bodyTextView;

    public CommentHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        emailTextView = itemView.findViewById(R.id.emailTextView);
        bodyTextView = itemView.findViewById(R.id.bodyTextView2);
    }
}
