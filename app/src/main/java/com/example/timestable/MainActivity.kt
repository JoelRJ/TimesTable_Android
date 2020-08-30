package com.example.timestable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateTable()

        // Add a listener to the SeekBar for user input, update timesList as changed
        var seek = findViewById<SeekBar>(R.id.inputNumber)
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                updateTable(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                updateTable()
            }
        })
    }

    // Function to update the RecyclerView table while the SeekBar is changed or Selected
    fun updateTable(startingNum: Int = inputNumber.progress) {

        // Create array of times tables from value
        var timesList = arrayListOf<Int>(startingNum)
        for (x in 2..10){
            timesList.add(startingNum * x)
        }

        timeTable.layoutManager = LinearLayoutManager(this)
        timeTable.adapter = RecyclerAdapter(timesList, this)
    }


}