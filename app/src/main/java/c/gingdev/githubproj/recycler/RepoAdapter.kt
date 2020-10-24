package c.gingdev.githubproj.recycler

import android.view.ViewGroup
import c.gingdev.githubproj.R


val TypeUser: Int = 0
val TypeRepo: Int = 1
class RepoAdapter(val itemArray: ArrayList<Pair<Int, Any?>>, private val callBack: (Any?) -> Unit)
    : BasicAdapter<BasicHolder>(itemArray) {

    override fun getItemViewType(position: Int): Int {
        return itemArray[position].first
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicHolder {
        return when(viewType) {
            TypeUser -> {
                return RepoHolder(R.layout.layout_user, parent, callBack)
            }
            TypeRepo -> {
                return RepoHolder(R.layout.layout_repo, parent, callBack)
            }
            else -> {
                return RepoHolder(R.layout.layout_repo, parent, callBack)
            }
        }
    }

    fun addItem(item: Pair<Int, Any?>) {
        itemArray.add(item)
    }
}