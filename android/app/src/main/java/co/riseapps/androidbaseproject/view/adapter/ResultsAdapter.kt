package co.riseapps.androidbaseproject.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.model.SubjectResult
import kotlinx.android.synthetic.main.result_card_view.view.*

class ResultsAdapter(
    private val results: List<SubjectResult>
) :
    RecyclerView.Adapter<ResultsAdapter.ResultViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.result_card_view,
                viewGroup,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(viewHolder: ResultViewHolder, position: Int) {
        viewHolder.tvName.text = results[position].name
        viewHolder.tvCapitalName.text = results[position].score.toString()
    }


    class ResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.tvCountryCardName
        val tvCapitalName: TextView = itemView.tvCountryCardCapitalName
        val root: LinearLayout = itemView.llCountryCardRoot
    }

}
