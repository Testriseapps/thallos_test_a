package co.riseapps.androidbaseproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.model.Region
import co.riseapps.androidbaseproject.model.entity.CountryEntity
import co.riseapps.androidbaseproject.view.CountriesFragment
import co.riseapps.androidbaseproject.view.CountryFragment
import co.riseapps.androidbaseproject.view.MainFragment
import co.riseapps.androidbaseproject.view.RegionsFragment
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvToolbarCancel.setOnClickListener { onBackPressed() }
    }

    override fun onStart() {
        super.onStart()
        showCountriesFragment()
    }

    fun showToolbar(title: String?) {
        tvToolbarTitle?.text = title?.capitalize()
        toolbar_container.visibility = VISIBLE
    }

    fun hideToolbar() {
        toolbar_container.visibility = GONE
    }

    private fun showMainFragment() {
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.clMainRoot, MainFragment.newInstance())
        beginTransaction.commit()
    }

    fun showRegionsFragment() {
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.clMainRoot, RegionsFragment.newInstance())
        beginTransaction.addToBackStack(RegionsFragment::class.java.simpleName)
        beginTransaction.commit()
    }

    fun showCountryFragment(country: CountryEntity) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        val countryFragment = CountryFragment.newInstance()
        countryFragment.setCountry(country)
        beginTransaction.replace(R.id.clMainRoot, countryFragment)
        beginTransaction.addToBackStack(CountryFragment::class.java.simpleName)
        beginTransaction.commit()
    }

    fun showCountriesFragment() {
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.clMainRoot, CountriesFragment.newInstance())
        beginTransaction.addToBackStack(CountriesFragment::class.java.simpleName)
        beginTransaction.commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    fun showCountriesFragment(selectedRegion: Region) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        val countriesFragment = CountriesFragment.newInstance()
        countriesFragment.setRegion(selectedRegion)
        beginTransaction.replace(R.id.clMainRoot, countriesFragment)
        beginTransaction.addToBackStack(CountriesFragment::class.java.simpleName)
        beginTransaction.commit()
    }
}
