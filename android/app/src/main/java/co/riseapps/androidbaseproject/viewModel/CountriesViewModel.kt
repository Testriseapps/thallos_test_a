package co.riseapps.androidbaseproject.viewModel

import android.arch.lifecycle.ViewModel
import co.riseapps.androidbaseproject.model.entity.CountryEntity

class CountriesViewModel : ViewModel() {
    lateinit var countries: MutableList<CountryEntity>
}
