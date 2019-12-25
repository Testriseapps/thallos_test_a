package co.riseapps.androidbaseproject.gateway

import co.riseapps.androidbaseproject.model.SubjectResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BaseEngine {
    @GET("")
    fun getResultsById(@Path("id") region: String): Single<List<SubjectResult>>

}