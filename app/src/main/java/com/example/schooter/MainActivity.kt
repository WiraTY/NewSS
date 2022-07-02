package com.example.schooter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schooter.databinding.ActivityMainBinding
//import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback


//class MainActivity : AppCompatActivity() {
//    private val list = ArrayList<PostResponse>()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        testPost.setHasFixedSize(true)
//        testPost.layoutManager = LinearLayoutManager(this)
//
////        Retrofit retrofit = new Retrofit.Builder()
////            .baseUrl("https://newsapi.org/")
////            .addCallAdapterFactory(GsonConverterFactory.create())
////            .build()
////
//
//        RetrofitClient.instance.getPosts().enqueue(object : retrofit2.Callback<ArrayList<PostResponse>> {
//            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable){
//
//            }
//
//            override fun onResponse(
//                call: Call<ArrayList<PostResponse>>,
//                response: Response<ArrayList<PostResponse>>
//            ){
//                val responseCode = response.code().toString()
//                txView.text = responseCode
//                response.body()?.let { list.addAll(it) }
//                val adapter = PostAdapter(list)
//                testPost.adapter = adapter
//            }
//        })
//     }
//}

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val list = ArrayList<PostResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.testPost.setHasFixedSize(true)
        binding.testPost.layoutManager = LinearLayoutManager(this)


        RetrofitClient.instance.getPosts().enqueue(object : retrofit2.Callback<ArrayList<PostResponse>> {
            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable){

            }

            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ){
                val responseCode = response.code().toString()
                binding.txView.text = responseCode
                response.body()?.let { list.addAll(it) }
                val adapter = PostAdapter(list)
                binding.testPost.adapter = adapter
            }
        })
    }
}
