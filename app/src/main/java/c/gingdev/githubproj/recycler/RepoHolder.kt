package c.gingdev.githubproj.recycler

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

class RepoHolder(@LayoutRes parentLayoutRes: Int, parent: ViewGroup, private val callBack: (Any?) -> Unit)
    : BasicHolder(parentLayoutRes, parent, callBack) {

    override fun bind(item: Any?, type: Int) {
        when(type) {
            TypeUser -> {

            }
            TypeRepo -> {

            }
        }
    }

    override fun itemTouched(item: Any?) {
        callBack(item)
    }
}