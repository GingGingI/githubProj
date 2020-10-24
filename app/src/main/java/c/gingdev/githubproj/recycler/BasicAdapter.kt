package c.gingdev.githubproj.recycler

import androidx.recyclerview.widget.RecyclerView

abstract class BasicAdapter<HOLDER : BasicHolder>(private var itemArray: ArrayList<Pair<Int, Any?>>) : RecyclerView.Adapter<HOLDER>() {
    override fun getItemCount(): Int = itemArray.size
    override fun onBindViewHolder(holder: HOLDER, position: Int) {
        holder.bind(itemArray[position].second, itemArray[position].first)
    }
}