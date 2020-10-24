package c.gingdev.githubproj.util

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit

object RetrofitObject {
    private val CONNECTION_TIMEOUT: Long = 10 // Sec
    private val WRITE_TIMEOUT: Long = 10 // Sec
    private val READ_TIMEOUT: Long = 10 // Sec

    var baseUrl: String = "https://api.github.com"

    fun generateRetrofit(app: Application): Retrofit {
        val okHttpClient = generateOkHttpClient(app)
        val gson = provideGson()

        return provideRetrofit(okHttpClient, gson)
    }

    private fun generateOkHttpClient(app: Application): OkHttpClient {
        val cache = provideCache(app)
        val interceptor = provideInterceptor()

        return provideOkHttpClient(cache, interceptor)
    }

    //    Cache
    private fun provideCache(app: Application): Cache {
        val cacheSize = 50 * 1024 * 1024 //50MB
        return Cache(app.cacheDir, cacheSize.toLong())
    }

    //    Gson
    private fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    //    Interceptor
    private fun provideInterceptor(): Interceptor {
        return Interceptor {
            val builder: Request.Builder = it.request().newBuilder()
            builder.header("User-Agent", "Android")
            builder.header("Accept", "*/*")
            builder.header("Connection", "close")

            it.proceed(builder.build())
        }
    }

    private fun provideOkHttpClient(cache: Cache, interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .cookieJar(JavaNetCookieJar(CookieManager(null, CookiePolicy.ACCEPT_ALL)))
            .addInterceptor(interceptor)
            .retryOnConnectionFailure(true)
            .build()
    }

    private fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .build()
    }

}