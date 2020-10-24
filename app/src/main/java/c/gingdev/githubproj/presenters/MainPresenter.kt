package c.gingdev.githubproj.presenters

import android.content.Context
import android.util.Log
import c.gingdev.githubproj.MainActivity
import c.gingdev.githubproj.constracts.Constract
import c.gingdev.githubproj.retrofit.model.UserModel
import c.gingdev.githubproj.retrofit.service.UserService
import c.gingdev.githubproj.util.RetrofitObject
import io.reactivex.schedulers.Schedulers

class MainPresenter(private val view: MainActivity): Constract.presenter {

    private val retrofit = RetrofitObject.generateRetrofit(view.application)
    private val userService = retrofit.create(UserService::class.java)

    override fun requestUser(userName: String) {
        userService.run {
            getUser(userName)
                .retry(3)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.i("user", "${it.login}")
                    view.responseUser(userModel = it)
                }, {
                    Log.e("err", it.message)
                }, {

                })
        }
    }

    override fun requestUserRepo(userName: String) {
        Log.i("test","test")
        userService.run {
            getUserRepo(userName)
                .retry(3)
                .subscribeOn(Schedulers.io())
                .subscribe({

                },{
                    Log.e("err", "${it.message}")
                },{

                })
        }
    }
}