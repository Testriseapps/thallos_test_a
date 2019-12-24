package co.riseapps.androidbaseproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.VISIBLE
import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.view.CountriesFragment
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        showCountriesFragment()
    }

    fun showToolbar(title: String?) {
        tvToolbarTitle?.text = title?.capitalize()
        toolbar_container.visibility = VISIBLE
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

}
