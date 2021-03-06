package com.hendraanggrian.widget

import android.content.Context
import android.support.annotation.PluralsRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hendraanggrian.common.view.setVisibleThen
import com.hendraanggrian.socialview.Hashtag
import com.hendraanggrian.socialview.commons.R

/**
 * Default adapter for displaying hashtag in [SocialAutoCompleteTextView].
 *
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class HashtagAdapter @JvmOverloads constructor(
        context: Context,
        @PluralsRes private val countPlural: Int = R.plurals.posts
) : FilteredAdapter<Hashtag>(context, R.layout.socialview_layout_hashtag, R.id.socialview_hashtag) {

    private val filter = object : SocialFilter() {
        override fun convertResultToString(resultValue: Any) = (resultValue as Hashtag).hashtag
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val holder: ViewHolder
        var _convertView = convertView
        if (_convertView == null) {
            _convertView = LayoutInflater.from(context).inflate(R.layout.socialview_layout_hashtag, parent, false)
            holder = ViewHolder(_convertView!!)
            _convertView.tag = holder
        } else {
            holder = _convertView.tag as ViewHolder
        }
        getItem(position)?.let {
            holder.textViewHashtag.text = it.hashtag
            holder.textViewCount.setVisibleThen(it.count != null) {
                holder.textViewCount.text = context.resources.getQuantityString(countPlural, it.count!!, it.count)
            }
        }
        return _convertView
    }

    override fun getFilter() = filter

    private class ViewHolder(itemView: View) {
        val textViewHashtag = itemView.findViewById<TextView>(R.id.socialview_hashtag)!!
        val textViewCount = itemView.findViewById<TextView>(R.id.socialview_hashtag_count)!!
    }
}