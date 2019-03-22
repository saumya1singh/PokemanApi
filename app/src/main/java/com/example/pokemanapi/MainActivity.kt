package com.example.pokemanapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    val  pokArray= arrayListOf<Myclass>()
    private  val url="https://pokeapi.co/api/v2/pokemon/25"
    val gson=Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client= OkHttpClient()
        val request=Request.Builder().url(url).build()
        val call=client.newCall(request)
        call.enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {

                val responseBody:ResponseBody?=response.body()
                val result=responseBody?.string()
                val pokobject=gson.fromJson(result,Myclass::class.java)
                Log.e("TAG",pokobject.name)
                pokArray.add(pokobject)
                runOnUiThread {
                    val pokadapter=PokAdapter(this@MainActivity,pokArray)
                    rv.layoutManager=LinearLayoutManager(baseContext)
                    rv.adapter=pokadapter
                }
            }

        }   )

    }
}
