package com.mohamedsobhy.posts.views.postdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohamedsobhy.posts.R;
import com.mohamedsobhy.posts.data.model.Comment;

import java.util.List;


public class CommentAdapter extends RecyclerView.Adapter<CommentHolder>{

    private List<Comment> comments;
    private Context context;

    public CommentAdapter(List<Comment> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new CommentHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        Comment comment = comments.get(position);

        holder.nameTextView.setText(comment.getName());
        holder.emailTextView.setText(comment.getEmail());
        holder.bodyTextView.setText(comment.getBody());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
}
