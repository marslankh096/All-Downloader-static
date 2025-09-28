// ViewPagerAdapter.kt
package com.app.alldownloaderstatic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
/*android:background="@drawable/rounded_bg"*/
class ViewPagerAdapter(
    private val context: Context,
    private val pages: List<List<AppMenuItem>>
) : RecyclerView.Adapter<ViewPagerAdapter.PageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pager_item_layout, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        holder.recyclerPage.layoutManager = GridLayoutManager(context, 4)
        holder.recyclerPage.adapter = PagerItemAdapter(context, object : AppPagerItemCallback {
            override fun onAppPagerItemClick(item: AppMenuItem) {
                Toast.makeText(context, "${item.name} clicked", Toast.LENGTH_SHORT).show()
            }
        }, pages[position])
    }

    override fun getItemCount(): Int = pages.size

    class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerPage: RecyclerView = itemView.findViewById(R.id.recyclerPage)
    }
}
