package com.thurainx.commonui.recycler_view.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.commonui.recycler_view.adapter.POST_VIEW_TYPE
import com.thurainx.commonui.recycler_view.delegate.PostItemDelegate

open class BasedViewHolder (itemView: View, delegate: PostItemDelegate): RecyclerView.ViewHolder(itemView){

//    init {
//        if(viewType == POST_VIEW_TYPE){
//            itemView.setOnClickListener {
//                delegate.onTap()
//            }
//        }

    }
