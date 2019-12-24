package co.riseapps.androidbaseproject.view

import android.app.ProgressDialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.riseapps.androidbaseproject.BaseApp
import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.activity.MainActivity
import co.riseapps.androidbaseproject.model.Person
import co.riseapps.androidbaseproject.model.SubjectResult
import co.riseapps.androidbaseproject.presenter.IResultsPresenter
import co.riseapps.androidbaseproject.presenter.implementatioin.ResultsPresenter
import co.riseapps.androidbaseproject.view.adapter.ResultsAdapter
import co.riseapps.androidbaseproject.viewModel.ResultsViewModel
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.results_fragment.*

class ResultsFragment : Fragment(), ResultsPresenter.ResultsView {
    private lateinit var viewModel: ResultsViewModel

    private lateinit var presenter: IResultsPresenter
    private lateinit var progressDialog: ProgressDialog
    private var person: Person = Person().apply {
        id = "Qsdfhjl-adfa223r-12fajefaw-2or1jlj2hr1k2lrhr"
        ageMonths = 28
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.results_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!this::progressDialog.isInitialized) {
            progressDialog = ProgressDialog(context)
        }
        viewModel = ViewModelProviders.of(this).get(ResultsViewModel::class.java)
        viewModel.countries = ArrayList()
        rvCountries.layoutManager = LinearLayoutManager(context)
        rvCountries.adapter = ResultsAdapter(viewModel.countries, person)
        presenter = (activity!!.application as BaseApp).kodein.instance()
        presenter.view = this

        (activity as MainActivity).showToolbar(getString(R.string.all))
        presenter.loadAllResults(person)
    }

    override fun onResultsLoaded(countries: List<SubjectResult>) {
        viewModel.countries.clear()
        viewModel.countries.addAll(countries)
        rvCountries.adapter?.notifyDataSetChanged()
    }

    override fun showProgress(message: String?) {
        progressDialog.setMessage(message)
        progressDialog.show()
    }

    override fun hideProgress() {
        progressDialog.dismiss()
    }

    companion object {
        fun newInstance() = ResultsFragment()
    }

}
