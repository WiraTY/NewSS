package com.example.schooter

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("v2/everything?q=tesla&from=2022-06-02&sortBy=publishedAt&apiKey=60712a670562466a9e26c2981f9bf19b")
    fun getPosts(): Call<ArrayList<PostResponse>>
}