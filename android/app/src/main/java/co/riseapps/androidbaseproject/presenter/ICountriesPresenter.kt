package co.riseapps.androidbaseproject.presenter

import co.riseapps.androidbaseproject.presenter.implementatioin.CountriesPresenter

interface ICountriesPresenter : DisposableStoringPresenter {
    var view: CountriesPresenter.CountriesView

    fun loadAllCountries()
}