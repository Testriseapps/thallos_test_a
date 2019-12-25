package co.riseapps.androidbaseproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.VISIBLE
import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.view.ResultsFragment
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        showResultsFragment()
    }

    fun showToolbar(title: String?) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        tvToolbarTitle?.text =  title?.capitalize()
    }

    private fun showResultsFragment() {
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.clMainRoot, ResultsFragment.newInstance())
        beginTransaction.addToBackStack(ResultsFragment::class.java.simpleName)
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
