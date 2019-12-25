package co.riseapps.androidbaseproject.presenter.implementatioin

import co.riseapps.androidbaseproject.gateway.network.INetworkGateway
import co.riseapps.androidbaseproject.model.Person
import co.riseapps.androidbaseproject.model.SubjectResult
import co.riseapps.androidbaseproject.presenter.IResultsPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ResultsPresenter(private val networkGateway: INetworkGateway) : IResultsPresenter {
    override lateinit var view: ResultsView

    override val disposables: MutableList<Disposable>
        get() = ArrayList()

    override fun loadAllResults(person: Person) {
        add(
            networkGateway
                .getResults(person.id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view.showProgress("Loading") }
                .doFinally { view.hideProgress() }
                .subscribe(
                    {
                        view.onResultsLoaded(it)
                    },
                    {

                    })
        )
    }

    interface ResultsView {
        fun onResultsLoaded(results: List<SubjectResult>)

        fun showProgress(message: String?)

        fun hideProgress()
    }
}