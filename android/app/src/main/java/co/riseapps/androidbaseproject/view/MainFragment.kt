package co.riseapps.androidbaseproject.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.activity.MainActivity
import co.riseapps.androidbaseproject.viewModel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        rlAllLayout.setOnClickListener {
            (activity as MainActivity).showCountriesFragment()
        }
        rlByRegionLayout.setOnClickListener {
            (activity as MainActivity).showRegionsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideToolbar()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
