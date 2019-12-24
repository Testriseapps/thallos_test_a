package co.riseapps.androidbaseproject.viewModel

import android.arch.lifecycle.ViewModel;
import co.riseapps.androidbaseproject.model.Region

class RegionsViewModel : ViewModel() {
    lateinit var regions: MutableList<Region>
}
