package c.gingdev.githubproj.retrofit.service

import c.gingdev.githubproj.retrofit.model.UserModel
import c.gingdev.githubproj.retrofit.model.UserRepoModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("/users/{user_name}")
    fun getUser(@Path("user_name")userName: String): Observable<UserModel>

    @GET("users/{user_name}/repos")
    fun getUserRepo(@Path("user_name")userName: String): Observable<List<UserRepoModel>>
}