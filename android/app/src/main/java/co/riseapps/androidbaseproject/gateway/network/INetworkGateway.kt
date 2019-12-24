package co.riseapps.androidbaseproject.gateway.network

import co.riseapps.androidbaseproject.model.SubjectResult
import io.reactivex.Single

interface INetworkGateway {
    fun getResults(id: String): Single<List<SubjectResult>>
}