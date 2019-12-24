package co.riseapps.androidbaseproject.presenter

import co.riseapps.androidbaseproject.model.Region
import co.riseapps.androidbaseproject.presenter.implementatioin.CountriesPresenter

interface ICountriesPresenter : DisposableStoringPresenter {
    var view: CountriesPresenter.CountriesView

    fun loadCountries(region: Region)

    fun loadAllCountries()
}