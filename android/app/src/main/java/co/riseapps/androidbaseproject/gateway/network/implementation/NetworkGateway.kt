package co.riseapps.androidbaseproject.gateway.network.implementation

import co.riseapps.androidbaseproject.gateway.BaseEngine
import co.riseapps.androidbaseproject.gateway.network.INetworkGateway
import co.riseapps.androidbaseproject.model.SubjectResult
import io.reactivex.Single

class NetworkGateway(private val baseEngine: BaseEngine) :
    INetworkGateway {
    override fun getResults(id: String): Single<List<SubjectResult>> {
        return Single.just(
            listOf(
                SubjectResult(name = "Adaptive", availabilityAge = 20, score = 35, picture = ""),
                SubjectResult(name = "Cognition", availabilityAge = 20, score = 10, picture = ""),
                SubjectResult(
                    name = "Functional academic",
                    availabilityAge = 40,
                    score = 0,
                    picture = ""
                ),
                SubjectResult(
                    name = "Language & Communication",
                    availabilityAge = 20,
                    score = 25,
                    picture = ""
                ),
                SubjectResult(
                    name = "Motor Skills",
                    availabilityAge = 20,
                    score = 35,
                    picture = ""
                ),
                SubjectResult(name = "Play Skills", availabilityAge = 20, score = 25, picture = ""),
                SubjectResult(
                    name = "Social Skills",
                    availabilityAge = 20,
                    score = 90,
                    picture = ""
                )
            )
        )
    }

}