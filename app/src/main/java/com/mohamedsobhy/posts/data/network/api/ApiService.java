package com.mohamedsobhy.posts.data.network.api;


import com.mohamedsobhy.posts.data.model.Comment;
import com.mohamedsobhy.posts.data.model.Post;
import com.mohamedsobhy.posts.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET(Constants.GET_ALL_POSTS)
    Call<List<Post>> getAllPosts();

    @GET(Constants.SPESEFIC_POST)
    Call<Post> getPostByID(@Path("id") int postID);

    @GET(Constants.GET_COMMENTS)
    Call<List<Comment>> getComments(@Path("id") int postID);

    @POST(Constants.ADD_POST)
    Call<Post> addPost(@Body Post post);

}
