package com.elkassas.retrofitkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

	// Commit

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface : ApiInterface = retrofit.create(ApiInterface::class.java)

        val call : Call<List<Post>> = apiInterface.getPost(1)
        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>,response: Response<List<Post>>) {
                post_title_txt.text = response.body()?.get(0)?.title
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                post_title_txt.text = t.message
            }
        })
    }
}