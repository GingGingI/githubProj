package c.gingdev.githubproj.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BasicHolder(@LayoutRes parentLayoutRes: Int, parent: ViewGroup, callBack: (Any?) -> Unit)
    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(parentLayoutRes, parent, false)) {
    protected val context = parent.context

    abstract fun bind(item: Any?, Type: Int)
    abstract fun itemTouched(item: Any?)
}