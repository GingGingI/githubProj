package c.gingdev.githubproj.constracts

import c.gingdev.githubproj.MainActivity
import c.gingdev.githubproj.retrofit.model.UserModel
import c.gingdev.githubproj.retrofit.model.UserRepoModel

interface Constract {
    interface view {
        fun responseUser(userModel: UserModel)
        fun responseUserRepo(userRepoModel: List<UserRepoModel>)
    }

    interface presenter {
        fun requestUser(userName: String)
        fun requestUserRepo(userName: String)
    }
}