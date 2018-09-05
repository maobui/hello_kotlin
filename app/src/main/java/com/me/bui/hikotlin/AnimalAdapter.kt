package com.me.bui.hikotlin

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list.view.*

class AnimalAdapter(val callback: AnimalClickCallback) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private var animalList: ArrayList<String>? = null

    fun setAnimalList(animalList: ArrayList<String>) {
        if(this.animalList == null) {
            this.animalList = animalList;
            notifyItemRangeInserted(0, animalList.size)
        } else {
            val result = DiffUtil.calculateDiff(DiffCallback(animalList))
            this.animalList = animalList
            result.dispatchUpdatesTo(this)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return animalList?.size ?: 0
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animalList!!.get(position), position, callback)
    }

    class AnimalViewHolder( view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: String, position: Int, callback: AnimalClickCallback) {
            itemView.tv_name_item?.text = item
            itemView.tv_name_item?.setTextColor(Utils.randomColor())
            itemView.img_icon_item.setImageResource(getImage(position))
            // On click listener.
            itemView.setOnClickListener { callback.onClick(item) }
        }

        fun  getImage(position: Int): Int = when(position % 5) {
            0 -> android.R.drawable.presence_busy
            1 -> android.R.drawable.presence_offline
            2 -> android.R.drawable.presence_online
            else -> android.R.drawable.presence_audio_online
        }

    }

    private inner class DiffCallback(val newList: List<String>) : DiffUtil.Callback(){

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = animalList!![oldItemPosition] == newList[newItemPosition]

        override fun getOldListSize() = animalList!!.size

        override fun getNewListSize() = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true//animalList!![oldItemPosition] == newList[newItemPosition]

    }
}