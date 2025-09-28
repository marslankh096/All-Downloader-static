// PagerItemAdapter.kt
package com.app.alldownloaderstatic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PagerItemAdapter(
    private val context: Context,
    private val appPagerItemCallback: AppPagerItemCallback,
    private val appMenuItems: List<AppMenuItem>
) : RecyclerView.Adapter<PagerItemAdapter.GuideHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.items_socialbuttons, parent, false)
        return GuideHolder(view)
    }

    override fun onBindViewHolder(holder: GuideHolder, position: Int) {
        holder.image.setImageResource(appMenuItems[position].drawable)
        holder.text_V.text = appMenuItems[position].name
        holder.image.setOnClickListener {
            appPagerItemCallback.onAppPagerItemClick(appMenuItems[position])
        }
    }

    override fun getItemCount(): Int = appMenuItems.size

    class GuideHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageV)
        val text_V: TextView = itemView.findViewById(R.id.text_V)
    }
}
