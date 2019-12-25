package co.riseapps.androidbaseproject.presenter

import co.riseapps.androidbaseproject.model.Person
import co.riseapps.androidbaseproject.presenter.implementatioin.ResultsPresenter

interface IResultsPresenter : DisposableStoringPresenter {
    var view: ResultsPresenter.ResultsView

    fun loadAllResults(person: Person)
}