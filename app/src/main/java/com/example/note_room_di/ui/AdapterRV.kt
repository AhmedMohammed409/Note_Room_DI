package com.example.note_room_di.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.note_room_di.OnListItemClick
import com.example.note_room_di.R
import com.example.note_room_di.model.entity.Note
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent



class AdapterRV : Adapter<AdapterRV.Viewholder>() {
    private var data: MutableList<Note> = mutableListOf()
    var onListItemClick: OnListItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class Viewholder(itewview: View) : RecyclerView.ViewHolder(itewview) {

        private var textViewName: TextView = itewview.findViewById(R.id.txt_item_noteName)
        private var textViewNote: TextView = itewview.findViewById(R.id.txt_item_Note)
        private var textviewTime: TextView = itewview.findViewById(R.id.txt_item_Date)
        fun bind(itemOfList: Note) {

            textViewName.text = itemOfList.nameNote
            textViewNote.text = itemOfList.note
            textviewTime.text = itemOfList.timeNote
            itemView.setOnClickListener {
                onListItemClick?.onItemclick(itemOfList)
            }
        }


    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(data: MutableList<Note>) {
        this.data = data
        notifyDataSetChanged()
    }

}

//1-add interface file to connection RV,Activity
//interface OnListItemClick {
//    fun onItemclick(massage: Massage)
//}


/* //2-to action of itemRv

Implement interface //OnListItemClick			in Activity by ,
addapter_name_object.onListItemClick=this	and implement fun in Activity


//3-to action of itemRv in Adapter define at global
var onListItemClick: OnListItemClick? = null

4-
add key word inner in viewholder

//5- to action of itemRv in fun bind at adapter
itemView.setOnClickListener {
    onListItemClick?.onItemclick(massage)
}
*/