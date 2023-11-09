package net.unboxit.massrfid.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.unboxit.massrfid.R
import net.unboxit.massrfid.databinding.AdapterRecentlyJobBinding
import net.unboxit.massrfid.model.RecentlyJobModel
import javax.inject.Inject

class RecentlyJobAdapter @Inject constructor() : RecyclerView.Adapter<RecentlyJobAdapter.RecentlyJobViewHolder>() {
    class RecentlyJobViewHolder(val view: AdapterRecentlyJobBinding): RecyclerView.ViewHolder(view.root)
    interface OnClickListener {
        fun onClick(position: Int, model: RecentlyJobModel)
    }
    private var onClickListener: OnClickListener? = null
    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }
    private var jobs = mutableListOf<RecentlyJobModel>()

    fun updateJobs(jobs: List<RecentlyJobModel>) {
        this.jobs = jobs.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentlyJobViewHolder {
        val binding = AdapterRecentlyJobBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return RecentlyJobViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return jobs.size
    }

    override fun onBindViewHolder(holder: RecentlyJobViewHolder, position: Int) {
        val job = jobs[position]
        holder.view.tvName.text = job.name

//        holder.view.tvDatetime.text = job.create.toString()
        if(job.done) {
            holder.view.ivDone.setImageResource(R.drawable.baseline_check_circle_24)
        } else {
            holder.view.ivDone.setImageResource(R.drawable.baseline_cancel_24)
            holder.view.vwJobContainer.setOnClickListener {
                onClickListener?.onClick(position, job)
            }
        }
    }
}