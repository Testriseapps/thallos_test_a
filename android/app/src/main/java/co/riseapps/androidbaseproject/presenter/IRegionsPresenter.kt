package co.riseapps.androidbaseproject.presenter

import co.riseapps.androidbaseproject.presenter.implementatioin.RegionsPresenter

interface IRegionsPresenter {
    var view: RegionsPresenter.RegionsView
    fun loadRegions()
}