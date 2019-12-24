package co.riseapps.androidbaseproject.presenter.implementatioin

import co.riseapps.androidbaseproject.gateway.network.INetworkGateway
import co.riseapps.androidbaseproject.model.Region
import co.riseapps.androidbaseproject.model.entity.CountryEntity
import co.riseapps.androidbaseproject.presenter.ICountriesPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CountriesPresenter(private val networkGateway: INetworkGateway) : ICountriesPresenter {
    override lateinit var view: CountriesView

    override val disposables: MutableList<Disposable>
        get() = ArrayList()

    override fun loadCountries(region: Region) {
        add(
            networkGateway
                .getCountries(region.name)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view.showProgress("Loading") }
                .doFinally { view.hideProgress() }
                .subscribe(
                    {
                        view.onCountriesLoad(it)
                    },
                    {

                    })
        )
    }

    override fun loadAllCountries() {
        add(
            networkGateway
                .getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view.showProgress("Loading") }
                .doFinally { view.hideProgress() }
                .subscribe(
                    {
                        view.onCountriesLoad(it)
                    },
                    {

                    })
        )
    }

    interface CountriesView {
        fun onCountriesLoad(countries: List<CountryEntity>)

        fun showProgress(message: String?)

        fun hideProgress()
    }
}