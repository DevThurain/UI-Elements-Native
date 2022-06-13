package com.thurainx.commonui.recycler_view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.commonui.R
import com.thurainx.commonui.recycler_view.delegate.PostItemDelegate
import com.thurainx.commonui.recycler_view.view_holder.AdsViewHolder
import com.thurainx.commonui.recycler_view.view_holder.BasedViewHolder
import com.thurainx.commonui.recycler_view.view_holder.PostViewHolder

val POST_VIEW_TYPE = 1
val ADS_VIEW_TYPE = 2
class PostAdapter(private val delegate: PostItemDelegate) : RecyclerView.Adapter<BasedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasedViewHolder {
        when(viewType){
            1 -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_post,parent,false)
                return PostViewHolder(itemView, delegate)
            }
            else -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_ads,parent,false)
                return AdsViewHolder(itemView, delegate)
            }
        }


    }

    override fun onBindViewHolder(holder: BasedViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 14
    }

    override fun getItemViewType(position: Int): Int {
        return when(position !=0 && position % 3 == 0){
            true -> ADS_VIEW_TYPE
            else -> POST_VIEW_TYPE
        }
    }

}