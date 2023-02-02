package com.example.newsassessmentapplication.view.adapter
import android.R
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.widget.ANImageView
import com.example.newsassessmentapplication.model.NewsDataClass
import com.example.newsassessmentapplication.view.DetailScreen


class NewsListtAdapter(private val mContext: Context, list: ArrayList<NewsDataClass>) :
    RecyclerView.Adapter<NewsListtAdapter.ViewHolder>() {
    private val mArrayList: ArrayList<NewsDataClass>

    init {
        mArrayList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.news_adapter_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsDataClass: NewsDataClass = mArrayList[position]



        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, DetailScreen::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("url_key", newsDataClass.url)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // declaring the views
        private val title: TextView
        private val description: TextView
        private val contributordate: TextView

        init {
            // assigning views to their ids
            title = itemView.findViewById(R.id.title_id)
            description = itemView.findViewById(R.id.description_id)
            contributordate = itemView.findViewById(R.id.contributordate_id)
        }
    }

    companion object {
        private val TAG = "NewsListtAdapter"
    }
}
