package com.mohamedsobhy.posts.util;

public class Constants {
    //////////////////////////////// Network ///////////////////////////////////////////
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static final String GET_ALL_POSTS = BASE_URL + "posts/";
    public static final String ADD_POST = BASE_URL + "posts/";

    public static final String SPESEFIC_POST = GET_ALL_POSTS + "{id}/";

    public static final String GET_COMMENTS = GET_ALL_POSTS + "{id}/comments/";

}