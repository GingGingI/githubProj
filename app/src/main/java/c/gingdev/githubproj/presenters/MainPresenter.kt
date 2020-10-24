package c.gingdev.githubproj.presenters

import android.content.Context
import c.gingdev.githubproj.MainActivity
import c.gingdev.githubproj.constracts.Constract
import c.gingdev.githubproj.util.RetrofitObject

class MainPresenter(private val view: MainActivity): Constract.presenter {

    private val retrofitInstance = RetrofitObject.generateRetrofit(view.application)

    override fun requestUser(userName: String) {

    }

    override fun requestUserRepo(userName: String) {

    }
}