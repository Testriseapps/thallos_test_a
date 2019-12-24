package co.riseapps.androidbaseproject.gateway.network

import co.riseapps.androidbaseproject.model.entity.CountryEntity
import io.reactivex.Single

interface INetworkGateway {
    fun getCountries(region: String): Single<List<CountryEntity>>

    fun getCountries(): Single<List<CountryEntity>>

    fun getCountry(code: String): Single<CountryEntity>
}