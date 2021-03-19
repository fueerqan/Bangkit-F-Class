package com.muhammadfurqan.bangkitfclass

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author by furqan on 19/03/2021
 */
abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(element: BaseModel)
}