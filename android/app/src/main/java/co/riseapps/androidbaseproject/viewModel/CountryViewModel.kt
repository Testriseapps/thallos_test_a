package co.riseapps.androidbaseproject.viewModel

import android.arch.lifecycle.ViewModel;
import co.riseapps.androidbaseproject.model.entity.CountryEntity

class CountryViewModel : ViewModel() {
    lateinit var country: CountryEntity

}
