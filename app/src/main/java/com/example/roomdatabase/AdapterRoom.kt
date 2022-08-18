package com.example.roomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRoom() : RecyclerView.Adapter<AdapterRoom.InnerAdapter>() {
    val arrayList : ArrayList<RoomDBEntity> = ArrayList()
private var myOnClickListener : MyClickListener? = null
    inner class InnerAdapter(view: View) : RecyclerView.ViewHolder(view)
    {
        val txtShown = view.findViewById<TextView>(R.id.txtShown)
        val imgDelete = view.findViewById<ImageView>(R.id.imgDelete)

        fun onBindItem(model : RoomDBEntity)
        {
            txtShown.text = model.name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerAdapter {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.inflate1,parent,false)
        return InnerAdapter(layoutInflater)
    }

    override fun onBindViewHolder(holder: InnerAdapter, position: Int) {
        holder.onBindItem(arrayList[holder.adapterPosition])

        holder.imgDelete.setOnClickListener {
            myOnClickListener?.itemClick(arrayList[holder.adapterPosition], position)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun addArray(arrayLis : ArrayList<RoomDBEntity>){
        arrayList.clear()
        arrayList.addAll(arrayLis)
        notifyDataSetChanged()
    }

    fun myClickListener(myClickListener: MyClickListener)
    {
        this.myOnClickListener = myClickListener
    }

    interface MyClickListener {
        fun itemClick(roomDBEntity: RoomDBEntity, position: Int)
    }

}