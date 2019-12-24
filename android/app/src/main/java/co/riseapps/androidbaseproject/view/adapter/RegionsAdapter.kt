package co.riseapps.androidbaseproject.view.adapter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.model.Region
import kotlinx.android.synthetic.main.region_holder_layout.view.*

class RegionsAdapter(
    private val regions: List<Region>,
    private val onRegionSelectedListener: (Region) -> Unit
) : RecyclerView.Adapter<RegionsAdapter.RegionsViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RegionsViewHolder {
        return RegionsViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.region_holder_layout,
                viewGroup,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return regions.size
    }

    override fun onBindViewHolder(viewHolder: RegionsViewHolder, position: Int) {
        viewHolder.image.setImageResource(regions[position].drawableId)
        viewHolder.text.text = regions[position].name.capitalize()
        viewHolder.root.setOnClickListener { onRegionSelectedListener(regions[position]) }
    }

    class RegionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.tvRegionName
        val image: ImageView = itemView.ivRegionImage
        val root: ConstraintLayout = itemView.rRegionRoot
    }
}