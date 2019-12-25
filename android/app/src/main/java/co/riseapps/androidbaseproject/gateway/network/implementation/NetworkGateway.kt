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
                SubjectResult(
                    type = SubjectResult.ADAPTIVE,
                    name = "Adaptive",
                    availabilityAge = 20,
                    score = 35
                ),
                SubjectResult(
                    type = SubjectResult.COGNITION,
                    name = "Cognition",
                    availabilityAge = 20,
                    score = 10
                ),
                SubjectResult(
                    type = SubjectResult.FUNCTIONAL_ACADEMIC,
                    name = "Functional academic",
                    availabilityAge = 40,
                    score = 0
                ),
                SubjectResult(
                    name = "Language & Communication",
                    availabilityAge = 20,
                    score = 25,
                    type = SubjectResult.LANGUAGE_AND_COMMUNICATION
                ),
                SubjectResult(
                    name = "Motor Skills",
                    availabilityAge = 20,
                    score = 35,
                    type = SubjectResult.MOTOR_SKILLS
                ),
                SubjectResult(
                    name = "Play Skills",
                    availabilityAge = 20,
                    score = 25,
                    type = SubjectResult.PLAY_SKILLS
                ),
                SubjectResult(
                    name = "Social Skills",
                    availabilityAge = 20,
                    score = 90,
                    type = SubjectResult.SOCIAL_SKILLS
                )
            )
        )
    }

}