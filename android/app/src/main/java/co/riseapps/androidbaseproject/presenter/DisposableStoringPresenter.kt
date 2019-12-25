package co.riseapps.androidbaseproject.presenter

import io.reactivex.disposables.Disposable

interface DisposableStoringPresenter {
    val disposables: MutableList<Disposable>

    fun add(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun dispose() {
        for (disposable in disposables) {
            disposable.dispose()
        }
        disposables.clear()
    }
}