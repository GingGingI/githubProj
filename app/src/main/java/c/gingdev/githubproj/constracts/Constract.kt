package c.gingdev.githubproj.constracts

import c.gingdev.githubproj.MainActivity

interface Constract {
    interface view {
        fun responseUser()
        fun responseUserRepo()
    }

    interface presenter {
        fun requestUser(userName: String)
        fun requestUserRepo(userName: String)
    }
}