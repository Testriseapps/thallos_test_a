package co.riseapps.androidbaseproject.gateway

import co.riseapps.androidbaseproject.model.entity.CountryEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BaseEngine {
    @GET("region/{region}")
    fun getCountriesByRegion(@Path("region") region: String): Single<List<CountryEntity>>

    @GET("all")
    fun getAllCountries(): Single<List<CountryEntity>>

    @GET("alpha/{code}")
    fun getCountryByCode(@Path("code") code: String): Single<CountryEntity>
}