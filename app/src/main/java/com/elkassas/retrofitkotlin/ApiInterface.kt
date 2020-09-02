package com.elkassas.retrofitkotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("posts/")
    open fun getPost(@Query("userId") userId : Int): Call<List<Post>>

}