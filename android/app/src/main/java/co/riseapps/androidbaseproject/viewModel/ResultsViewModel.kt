package co.riseapps.androidbaseproject.viewModel

import android.arch.lifecycle.ViewModel
import co.riseapps.androidbaseproject.model.SubjectResult

class ResultsViewModel : ViewModel() {
    lateinit var countries: MutableList<SubjectResult>
}
