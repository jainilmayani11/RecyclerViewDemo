package com.example.recyclerviewdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var contactList: ArrayList<ContactModel>
    lateinit var imageList: Array<Int>
    lateinit var nameList: Array<String>
    lateinit var numberList: Array<Int>
    private lateinit var contactAdapter: ContactAdapter

    lateinit var imgDetailsList : Array<Int>
    lateinit var nameDetailsList : Array<String>
    lateinit var numberDetailsList : Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageList = arrayOf(
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
        )
        nameList = arrayOf("Name 1", "Name 2", "Name 3", "Name 4", "Name 5", "Name 6", "Name 7")
        numberList = arrayOf(
            1111111111, 222222222, 333333333, 444444444, 555555555, 666666666, 777777777
        )

        imgDetailsList = arrayOf(
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
        )
        nameDetailsList = arrayOf("Name 1", "Name 2", "Name 3", "Name 4", "Name 5", "Name 6", "Name 7")
        numberDetailsList = arrayOf(
            1234567890, 1234567890, 1234567890, 1234567890, 1234567890, 1234567890, 1234567890
        )

        recyclerView = findViewById(R.id.rvContact)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        contactList = arrayListOf<ContactModel>()
        getData()

        contactAdapter = ContactAdapter(contactList)
        recyclerView.adapter = contactAdapter


        contactAdapter.onItemClick = { contactModel ->
            val intent = Intent(this, ContactDetails::class.java)
            intent.putExtra("image", contactModel.img)
            intent.putExtra("name", contactModel.name)
            intent.putExtra("number", contactModel.number)
            startActivity(intent)
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun getData() {
        for (i in imageList.indices) {
            val contactModel = ContactModel(imageList[i], nameList[i], numberList[i])
            contactList.add(contactModel)
        }
        recyclerView.adapter = ContactAdapter(contactList)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}