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
import co.riseapps.androidbaseproject.model.Region
import co.riseapps.androidbaseproject.model.entity.CountryEntity
import co.riseapps.androidbaseproject.presenter.ICountriesPresenter
import co.riseapps.androidbaseproject.presenter.implementatioin.CountriesPresenter
import co.riseapps.androidbaseproject.view.adapter.CountriesAdapter
import co.riseapps.androidbaseproject.viewModel.CountriesViewModel
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.countries_fragment.*

class CountriesFragment : Fragment(), CountriesPresenter.CountriesView {
    private lateinit var viewModel: CountriesViewModel

    private lateinit var presenter: ICountriesPresenter
    private var selectedRegion: Region? = null
    private lateinit var progressDialog: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.countries_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!this::progressDialog.isInitialized) {
            progressDialog = ProgressDialog(context)
        }
        viewModel = ViewModelProviders.of(this).get(CountriesViewModel::class.java)
        viewModel.countries = ArrayList()
        rvCountries.layoutManager = LinearLayoutManager(context)
        rvCountries.adapter = CountriesAdapter(viewModel.countries) {
            (activity as MainActivity).showCountryFragment(it)
        }
        presenter = (activity!!.application as BaseApp).kodein.instance()
        presenter.view = this

        if (selectedRegion != null) {
            selectedRegion?.let {
                presenter.loadCountries(it)
                (activity as MainActivity).showToolbar(it.name)
            }
        } else {
            (activity as MainActivity).showToolbar(getString(R.string.all))
            presenter.loadAllCountries()
        }
    }

    fun setRegion(selectedRegion: Region) {
        this.selectedRegion = selectedRegion
    }

    override fun onCountriesLoad(countries: List<CountryEntity>) {
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
        fun newInstance() = CountriesFragment()
    }

}
