package com.me.bui.hikotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG: String? = MainActivity::class.java.simpleName
    }

    private val animalList: ArrayList<String> = ArrayList()
    private val callback: AnimalClickCallback? = object : AnimalClickCallback {
        override fun onClick(animal: String) {
            Log.d(TAG, "onClick here " + animal)
        }
    }
    private val animalAdapter: AnimalAdapter = AnimalAdapter(callback as AnimalClickCallback)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        rc_list.layoutManager = LinearLayoutManager(this)
        rc_list.adapter = animalAdapter
        animalAdapter.setAnimalList(animalList)

    }

    fun initData() {
        animalList.add("dog")
        animalList.add("cat")
        animalList.add("owl")
        animalList.add("cheetah")
        animalList.add("raccoon")
        animalList.add("bird")
        animalList.add("snake")
        animalList.add("lizard")
        animalList.add("hamster")
        animalList.add("bear")
        animalList.add("lion")
        animalList.add("tiger")
        animalList.add("horse")
        animalList.add("frog")
        animalList.add("fish")
        animalList.add("shark")
        animalList.add("turtle")
        animalList.add("elephant")
        animalList.add("cow")
        animalList.add("beaver")
        animalList.add("bison")
        animalList.add("porcupine")
        animalList.add("rat")
        animalList.add("mouse")
        animalList.add("goose")
        animalList.add("deer")
        animalList.add("fox")
        animalList.add("moose")
        animalList.add("buffalo")
        animalList.add("monkey")
        animalList.add("penguin")
        animalList.add("parrot")
    }
}