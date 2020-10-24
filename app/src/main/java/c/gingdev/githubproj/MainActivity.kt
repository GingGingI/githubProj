package c.gingdev.githubproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import c.gingdev.githubproj.constracts.Constract
import c.gingdev.githubproj.presenters.MainPresenter
import c.gingdev.githubproj.recycler.RepoAdapter
import c.gingdev.githubproj.recycler.TypeRepo
import c.gingdev.githubproj.recycler.TypeUser
import c.gingdev.githubproj.retrofit.model.UserModel
import c.gingdev.githubproj.retrofit.model.UserRepoModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), Constract.view {

	private val presenter: MainPresenter by lazy { MainPresenter(this) }
	private val userName: String = "GingGingI"

	private lateinit var adapter: RepoAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		initAdapter()
		loadDatas()
	}

	private fun initAdapter() {
		adapter = RepoAdapter(ArrayList()) {
//			ClickEvent
		}

		gitRecycler.adapter = adapter
		gitRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
	}

	private fun loadDatas() {
		presenter.requestUser(userName)
		presenter.requestUserRepo(userName)
	}

	override fun responseUser(userModel: UserModel) {
		adapter.addItem(Pair(TypeUser, userModel))
	}

	override fun responseUserRepo(userRepoModel: List<UserRepoModel>) {
		userRepoModel.forEach {
			adapter.addItem(Pair(TypeRepo, it))
		}
	}
}