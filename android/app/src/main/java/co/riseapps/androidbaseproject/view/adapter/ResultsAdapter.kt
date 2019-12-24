package co.riseapps.androidbaseproject.view.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import co.riseapps.androidbaseproject.R
import co.riseapps.androidbaseproject.model.Person
import co.riseapps.androidbaseproject.model.SubjectResult
import co.riseapps.androidbaseproject.model.SubjectResult.Companion.ADAPTIVE
import co.riseapps.androidbaseproject.model.SubjectResult.Companion.COGNITION
import co.riseapps.androidbaseproject.model.SubjectResult.Companion.FUNCTIONAL_ACADEMIC
import co.riseapps.androidbaseproject.model.SubjectResult.Companion.LANGUAGE_AND_COMMUNICATION
import co.riseapps.androidbaseproject.model.SubjectResult.Companion.MOTOR_SKILLS
import co.riseapps.androidbaseproject.model.SubjectResult.Companion.PLAY_SKILLS
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import kotlinx.android.synthetic.main.result_card_view.view.*

class ResultsAdapter(
    private val results: List<SubjectResult>,
    private val person: Person
) :
    RecyclerView.Adapter<ResultsAdapter.AbstractResultViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AbstractResultViewHolder {
        return when (viewType) {
            AVAILABLE -> ResultViewHolder(
                LayoutInflater.from(viewGroup.context).inflate(
                    R.layout.result_card_view,
                    viewGroup,
                    false
                )
            )
            else -> {
                ResultUnavailableViewHolder(
                    LayoutInflater.from(viewGroup.context).inflate(
                        R.layout.result_unavailable_card,
                        viewGroup,
                        false
                    )
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (results[position].isAvailableFor(this.person)) {
            AVAILABLE
        } else {
            UNAVAILABLE
        }
    }


    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(viewHolder: AbstractResultViewHolder, position: Int) {
        val result = results[position]
        val context = viewHolder.tvName.context
        viewHolder.tvName.text = result.name
       loadImage(result, viewHolder.ivPicture)
        if (viewHolder is ResultViewHolder) {
            setScore(viewHolder, result, context)
            viewHolder.score20.findViewById<TextView>(R.id.tvScoreItemDescription).text =
                context.getString(R.string.delayed)
            viewHolder.score80.findViewById<TextView>(R.id.tvScoreItemDescription).text =
                context.getString(R.string.tracking)
            viewHolder.score100.findViewById<TextView>(R.id.tvScoreItemDescription).text =
                context.getString(R.string.advanced)
        }
    }


    fun setScore(viewHolder: ResultViewHolder, result: SubjectResult, ctx: Context) {
        when {
            result.score >= 11 -> setUp20(viewHolder, ctx)
            result.score >= 31 -> setUp40(viewHolder, ctx)
            result.score >= 51 -> setUp60(viewHolder, ctx)
            result.score >= 71 -> setUp80(viewHolder, ctx)
            result.score >= 91 -> setUp100(viewHolder, ctx)
        }
    }

    fun setUp20(viewHolder: ResultViewHolder, ctx: Context) {
        viewHolder.score20.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(getDrawable(ctx))
    }

    fun setUp40(viewHolder: ResultViewHolder, ctx: Context) {
        val drawable = getDrawable(ctx)
        viewHolder.score20.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(drawable)
        viewHolder.score40.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(drawable)
    }

    fun setUp60(viewHolder: ResultViewHolder, ctx: Context) {
        val drawable = getDrawable(ctx)
        viewHolder.score20.findViewById<ImageView>(R.id.ivScoreItemPicture).setImageDrawable(
            drawable
        )
        viewHolder.score40.findViewById<ImageView>(R.id.ivScoreItemPicture).setImageDrawable(
            drawable
        )
        viewHolder.score60.findViewById<ImageView>(R.id.ivScoreItemPicture).setImageDrawable(
            drawable
        )
    }

    fun setUp80(viewHolder: ResultViewHolder, ctx: Context) {
        val drawable = getDrawable(ctx)
        viewHolder.score20.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(drawable)
        viewHolder.score40.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(drawable)
        viewHolder.score60.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(drawable)
        viewHolder.score80.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(drawable)
    }

    fun setUp100(viewHolder: ResultViewHolder, ctx: Context) {
        val drawable = getDrawable(ctx)
        viewHolder.score20.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(drawable)
        viewHolder.score40.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(drawable)
        viewHolder.score60.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(drawable)
        viewHolder.score80.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(drawable)
        viewHolder.score100.findViewById<ImageView>(R.id.ivScoreItemPicture)
            .setImageDrawable(drawable)
    }

    fun loadImage(result: SubjectResult, image: ImageView) {
        val imageId = when (result.type) {
            ADAPTIVE -> R.drawable.icon_adaptive
            COGNITION -> R.drawable.icon_cognition
            FUNCTIONAL_ACADEMIC -> R.drawable.icon_functional
            LANGUAGE_AND_COMMUNICATION -> R.drawable.icon_language_communication
            MOTOR_SKILLS -> R.drawable.icon_motor
            PLAY_SKILLS -> R.drawable.icon_play
            else -> R.drawable.icon_social
        }
        Picasso.get()
            .load(imageId)
            .resize(150, 150)
            .into(image)
    }


    fun getDrawable(ctx: Context): Drawable? {
        return ctx.getDrawable(R.drawable.ic_pill_filled)
    }

    abstract class AbstractResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.tvResultCardName
        val ivPicture: ImageView = itemView.ivItemPicture
    }

    class ResultViewHolder(itemView: View) : AbstractResultViewHolder(itemView) {
        val score20: ConstraintLayout = itemView.findViewById(R.id.clScore20)
        val score40: ConstraintLayout = itemView.findViewById(R.id.clScore40)
        val score60: ConstraintLayout = itemView.findViewById(R.id.clScore60)
        val score80: ConstraintLayout = itemView.findViewById(R.id.clScore80)
        val score100: ConstraintLayout = itemView.findViewById(R.id.clScore100)
    }

    class ResultUnavailableViewHolder(itemView: View) : AbstractResultViewHolder(itemView)

    companion object {
        const val AVAILABLE: Int = 1061
        const val UNAVAILABLE: Int = 1062
    }

}
