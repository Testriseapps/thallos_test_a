package co.riseapps.androidbaseproject.presenter.implementatioin

import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.model.*
import co.riseapps.androidbaseproject.presenter.IRegionsPresenter

class RegionsPresenter : IRegionsPresenter {
    override lateinit var view: RegionsView

    override fun loadRegions() {
        val regions =
            listOf(
                Region(AFRICA, R.drawable.africa),
                Region(AMERICAS, R.drawable.america),
                Region(ASIA, R.drawable.asia),
                Region(EUROPE, R.drawable.europe),
                Region(OCEANIA, R.drawable.oceania)
            )
        view.onRegionsLoaded(regions)
    }

    interface RegionsView {
        fun onRegionsLoaded(regions: List<Region>)
    }
}