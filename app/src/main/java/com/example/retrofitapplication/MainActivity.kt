package com.example.retrofitapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.retrofitapplication.databinding.ActivityMainBinding
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.addButton.setOnClickListener {
            val input=binding.inputEdit.text.toString() //a string representation of object will be passed overhere
            val retrofit = RetrofitClient.getInstance() //so retrofit is activated for making any HTTP request
            val apiInterface = retrofit.create(ChatgptInterface::class.java) //allow the retrofit to make http request using the defined endpoints in the Interface

            apiInterface.getResponse(input).enqueue(object: Callback<JsonPrimitive> {//here enqueue is used to make call to internet and then interface is created
                override fun onResponse(call: Call<JsonPrimitive>, response: Response<JsonPrimitive>) {
                    binding.outputText.text=response.body().toString()//we will get the output here
                }

                override fun onFailure(call: Call<JsonPrimitive>, t: Throwable) {
                    binding.outputText.text=t.toString() //we will get the error here
                }

            })
        }

    }
}