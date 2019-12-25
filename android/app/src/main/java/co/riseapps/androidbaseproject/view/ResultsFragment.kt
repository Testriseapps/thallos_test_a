package co.riseapps.androidbaseproject.view

import android.app.ProgressDialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.riseapps.androidbaseproject.BaseApp
import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.model.Person
import co.riseapps.androidbaseproject.model.SubjectResult
import co.riseapps.androidbaseproject.presenter.IResultsPresenter
import co.riseapps.androidbaseproject.presenter.implementatioin.ResultsPresenter
import co.riseapps.androidbaseproject.view.adapter.ResultsAdapter
import co.riseapps.androidbaseproject.viewModel.ResultsViewModel
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.info_layout.*
import kotlinx.android.synthetic.main.results_fragment.*

class ResultsFragment : Fragment(), ResultsPresenter.ResultsView {
    private lateinit var viewModel: ResultsViewModel

    private lateinit var presenter: IResultsPresenter
    private lateinit var progressDialog: ProgressDialog
    private var person: Person = Person().apply {
        name = "John"
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
        viewModel.results = ArrayList()
        rvResults.layoutManager = LinearLayoutManager(context)
        rvResults.adapter = ResultsAdapter(viewModel.results, person)
        presenter = (activity!!.application as BaseApp).kodein.instance()
        presenter.view = this

        presenter.loadAllResults(person)
    }

    override fun onResultsLoaded(results: List<SubjectResult>) {
        showInfoMessage(2, results.size)
        viewModel.results.clear()
        viewModel.results.addAll(results)
        rvResults.adapter?.notifyDataSetChanged()
    }

    private fun showInfoMessage(gapsNumber: Int, resultsLength: Int) {
        val infoText = """<font color=#000000>${getString(
            R.string.info_message,
            person.name
        )}</font> <font color=#cc0029>${getString(
            R.string.info_message_1,
            gapsNumber,
            resultsLength
        )}</font> <font color=#000000>${getString(R.string.info_message_2)}</font> <font color=#cc0029>${person.ageMonths} months</font> <font color=#000000>${getString(
            R.string.info_message_3
        )}</font>"""
        tvInfo.text = Html.fromHtml(infoText)
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
