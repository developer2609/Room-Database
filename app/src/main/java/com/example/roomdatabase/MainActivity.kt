package com.example.roomdatabase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomdatabase.Db.AppDabase
import com.example.roomdatabase.Db.MyContact
import com.example.roomdatabase.Db.RvAdapter
import com.example.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appDabase: AppDabase
    private lateinit var rvAdapter: RvAdapter
    private lateinit var list: ArrayList<MyContact>
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        appDabase=AppDabase.getInstance(this)
        list= ArrayList()
        list.addAll(appDabase.myContactDao().getAllContacts())

        rvAdapter= RvAdapter(list)
        binding.rv.adapter=rvAdapter



        binding.buttonSave.setOnClickListener {
            val myContact=MyContact(

                binding.edtName.text.toString(),
                binding.edtNumber.text.toString()
            )

            appDabase.myContactDao().addContact(myContact)
            rvAdapter.list=appDabase.myContactDao().getAllContacts()
            rvAdapter.notifyDataSetChanged()

            Toast.makeText(this, "save", Toast.LENGTH_SHORT).show()

        }
    }
}