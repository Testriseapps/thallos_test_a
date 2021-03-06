package co.riseapps.androidbaseproject

import android.app.Application
import co.riseapps.androidbaseproject.gateway.network.INetworkGateway
import co.riseapps.androidbaseproject.gateway.network.createService
import co.riseapps.androidbaseproject.gateway.network.implementation.NetworkGateway
import co.riseapps.androidbaseproject.presenter.IResultsPresenter
import co.riseapps.androidbaseproject.presenter.implementatioin.ResultsPresenter
import com.crashlytics.android.Crashlytics
import com.github.salomonbrys.kodein.*
import io.fabric.sdk.android.Fabric


class BaseApp : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        bind<INetworkGateway>() with singleton { NetworkGateway(createService(BASE_URL)) }
        bind<IResultsPresenter>() with singleton { ResultsPresenter(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
    }

    companion object {
        const val BASE_URL = "https://restcountries.eu/rest/v2/"
    }
}