package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var addBtn: Button
    private lateinit var recycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn = findViewById(R.id.addBtn)
        recycler = findViewById(R.id.recycler)

        val list: ArrayList<Data> = ArrayList()

        recycler.adapter = ListAdapter(list){ data, position ->
            list.removeAt(position)
            Toast.makeText(this, "폐점", Toast.LENGTH_SHORT).show()
            recycler.adapter?.notifyItemRemoved(position)

        }

        addBtn.setOnClickListener {
            val randomInt = Random.nextInt(100)
            list.add(Data("슈의 라면가게 개점", randomInt.toString()+"호점"))
            recycler.adapter?.notifyItemInserted(list.size-1)
        }

        val sum : (a : Int, b : Int) -> Int = {a, b ->
            a+b
        }
    }
}