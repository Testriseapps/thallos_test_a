package co.riseapps.androidbaseproject.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.activity.MainActivity
import co.riseapps.androidbaseproject.model.entity.CountryEntity
import co.riseapps.androidbaseproject.model.entity.CurrencyEntity
import co.riseapps.androidbaseproject.model.entity.LanguageEntity
import co.riseapps.androidbaseproject.viewModel.CountryViewModel
import kotlinx.android.synthetic.main.country_fragment.*

class CountryFragment : Fragment() {
    companion object {
        fun newInstance() = CountryFragment()
    }

    private lateinit var viewModel: CountryViewModel
    private var selectedCountry: CountryEntity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.country_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        selectedCountry?.let { country ->
            (activity as MainActivity).showToolbar(country.name)
            viewModel.country = country
            tvCountryName.text = country.name
            tvCountryCapitalName.text = country.capital
            tvCountryRegionName.text = country.region
            tvCountrySubRegionName.text = country.subregion
            country.languages?.let {
                tvCountryLanguagesList.text = getLanguagesNamesAsString(it)
            }
            country.currencies?.let {
                tvCountryCurrenciesName.text = getCurrenciesNamesAsString(it)
            }
            country.timezones?.let {
                tvCountryTimezonesList.text = getTimezonesAsString(it)
            }
        }
    }

    private fun getLanguagesNamesAsString(languages: List<LanguageEntity>): String {
        val delimiter = ", "
        val sb = StringBuilder()
        for (lang in languages) {
            sb.append(lang.name)
            sb.append(delimiter)
        }
        return sb.substring(0, sb.length - delimiter.length)
    }

    private fun getCurrenciesNamesAsString(currencies: List<CurrencyEntity>): String {
        val delimiter = ", "
        val sb = StringBuilder()
        for (currency in currencies) {
            sb.append(currency.name)
            sb.append(delimiter)
        }
        return sb.substring(0, sb.length - delimiter.length)
    }

    private fun getTimezonesAsString(timezones: List<String>): String {
        val delimiter = ", "
        val sb = StringBuilder()
        for (timezone in timezones) {
            sb.append(timezone)
            sb.append(delimiter)
        }
        return sb.substring(0, sb.length - delimiter.length)
    }

    fun setCountry(country: CountryEntity) {
        this.selectedCountry = country
    }

}
