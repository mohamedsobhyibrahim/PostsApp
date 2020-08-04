package com.mohamedsobhy.posts.views.addpost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mohamedsobhy.posts.R;
import com.mohamedsobhy.posts.data.model.Post;
import com.mohamedsobhy.posts.data.network.api.ApiClient;
import com.mohamedsobhy.posts.data.network.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPostActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText bodyEditText;
    private EditText userIDEditText;
    private Button addButton;

    private ApiService api;

    private String title;
    private String body;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        api = ApiClient.getInstance(this);

        titleEditText = findViewById(R.id.titleEditText);
        bodyEditText = findViewById(R.id.bodyEditText);
        userIDEditText = findViewById(R.id.userIDEditText);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getInputData())
                    addPost();
            }
        });
    }

    private boolean getInputData() {
        title = titleEditText.getText().toString();
        body = bodyEditText.getText().toString();
        userID = userIDEditText.getText().toString();

        if (title.isEmpty()) {
            titleEditText.setError("Please Enter title");
        }
        if (body.isEmpty()) {
            bodyEditText.setError("Please Enter body");
        }
        if (userID.isEmpty()) {
            userIDEditText.setError("Please Enter user id");
        }

        return true;
    }

    private void addPost() {
        Post post = new Post(Integer.parseInt(userID), title , body);
        api.addPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.v("ADD_POST",response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.v("ADD_POST_ERROR" , t.toString());
            }
        });
    }
}