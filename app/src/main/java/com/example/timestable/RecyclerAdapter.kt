package com.example.timestable

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_adapter.view.*

class RecyclerAdapter(val list: ArrayList<Int>, val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_view_adapter, parent, false)
        return ViewHolder(view).listen { pos, type ->
            val item = list.get(pos)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.listType.text = list.get(position).toString()
    }
}




// ViewHolder class holds list view
class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val listType = view.list_text
}

// ViewHolder function listens for click
fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}