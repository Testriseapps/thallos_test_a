package co.riseapps.androidbaseproject.view

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
import co.riseapps.androidbaseproject.presenter.IRegionsPresenter
import co.riseapps.androidbaseproject.presenter.implementatioin.RegionsPresenter
import co.riseapps.androidbaseproject.view.adapter.RegionsAdapter
import co.riseapps.androidbaseproject.viewModel.RegionsViewModel
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.regions_fragment.*

class RegionsFragment : Fragment(), RegionsPresenter.RegionsView {

    private lateinit var presenter: IRegionsPresenter
    private lateinit var viewModel: RegionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.regions_fragment, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = (activity!!.application as BaseApp).kodein.instance()
        presenter.view = this
        viewModel = ViewModelProviders.of(this).get(RegionsViewModel::class.java)
        viewModel.regions = ArrayList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideToolbar()
        rvRegions.layoutManager = LinearLayoutManager(context)
        rvRegions.adapter = RegionsAdapter(viewModel.regions) {
            (activity as MainActivity).showCountriesFragment(it)
        }
        presenter.loadRegions()
    }

    override fun onRegionsLoaded(regions: List<Region>) {
        viewModel.regions.clear()
        viewModel.regions.addAll(regions)
        rvRegions.adapter?.notifyDataSetChanged()
    }

    companion object {
        fun newInstance() = RegionsFragment()
    }
}
