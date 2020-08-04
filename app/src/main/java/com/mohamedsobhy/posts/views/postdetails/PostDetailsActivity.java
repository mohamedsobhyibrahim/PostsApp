package com.mohamedsobhy.posts.views.postdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mohamedsobhy.posts.R;
import com.mohamedsobhy.posts.data.model.Comment;
import com.mohamedsobhy.posts.data.model.Post;
import com.mohamedsobhy.posts.data.network.api.ApiClient;
import com.mohamedsobhy.posts.data.network.api.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDetailsActivity extends AppCompatActivity {

    private int postID;
    private ApiService api;

    private TextView titleTextView;
    private TextView userIdTextView;
    private TextView bodyTextView;

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        titleTextView = findViewById(R.id.title);
        userIdTextView = findViewById(R.id.userID);
        bodyTextView = findViewById(R.id.body);
        recyclerView = findViewById(R.id.commentRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        postID = getIntent().getIntExtra("ID" ,0);

        api = ApiClient.getInstance(this);

        getPost();
        getComments();
    }

    private void getPost() {

        api.getPostByID(postID).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                titleTextView.setText(response.body().getTitle());
                userIdTextView.setText(response.body().getUserId()+"");
                bodyTextView.setText(response.body().getBody());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.v("ERROR" , t.toString());
            }
        });

    }

    private void getComments() {
        api.getComments(postID).enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                CommentAdapter commentAdapter = new CommentAdapter(response.body() , getApplicationContext());
                recyclerView.setAdapter(commentAdapter);
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Log.v("ERROR" , t.toString());
            }
        });
    }
}