package co.riseapps.androidbaseproject.gateway.network.implementation

import co.riseapps.androidbaseproject.gateway.BaseEngine
import co.riseapps.androidbaseproject.gateway.network.INetworkGateway
import co.riseapps.androidbaseproject.model.entity.CountryEntity
import io.reactivex.Single

class NetworkGateway(private val baseEngine: BaseEngine) :
    INetworkGateway {
    override fun getCountries(region: String): Single<List<CountryEntity>> = baseEngine.getCountriesByRegion(region)

    override fun getCountries(): Single<List<CountryEntity>> = baseEngine.getAllCountries()

    override fun getCountry(code: String): Single<CountryEntity> = baseEngine.getCountryByCode(code)
}