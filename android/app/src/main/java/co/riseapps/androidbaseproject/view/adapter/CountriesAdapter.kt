package co.riseapps.androidbaseproject.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.model.entity.CountryEntity
import kotlinx.android.synthetic.main.country_card_view.view.*

class CountriesAdapter(
    private val countries: List<CountryEntity>,
    private val onCountrySelectedListener: (country: CountryEntity) -> Unit
) :
    RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.country_card_view,
                viewGroup,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(viewHolder: CountriesViewHolder, position: Int) {
        viewHolder.tvName.text = countries[position].name
        viewHolder.tvCapitalName.text = countries[position].capital
        viewHolder.root.setOnClickListener { onCountrySelectedListener(countries[position]) }
    }


    class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.tvCountryCardName
        val tvCapitalName: TextView = itemView.tvCountryCardCapitalName
        val root: LinearLayout = itemView.llCountryCardRoot
    }

}
