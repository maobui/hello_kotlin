package com.me.bui.hikotlin

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list.view.*
import java.util.*

class AnimalAdapter( val items: ArrayList<String>, val context: Context) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder?.tvNameItem?.text = items.get(position)
        holder?.tvNameItem?.setTextColor(Utils.randomColor())
    }

    class AnimalViewHolder( view: View) : RecyclerView.ViewHolder(view) {
        val tvNameItem = view.tv_name_item
    }
}