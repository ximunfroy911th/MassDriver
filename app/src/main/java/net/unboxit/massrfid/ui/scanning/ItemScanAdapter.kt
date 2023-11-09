package net.unboxit.massrfid.ui.scanning

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.unboxit.massrfid.R
import net.unboxit.massrfid.databinding.AdapterItemCheckBinding
import net.unboxit.massrfid.databinding.AdapterRecentlyJobBinding
import net.unboxit.massrfid.model.ItemBox
import javax.inject.Inject

class ItemScanAdapter @Inject constructor() : RecyclerView.Adapter<ItemScanAdapter.ItemScanViewHolder>() {
    class ItemScanViewHolder(val view: AdapterItemCheckBinding): RecyclerView.ViewHolder(view.root)
    private var items = mutableListOf<ItemBox>()

    fun updateItems(items: List<ItemBox>) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemScanViewHolder {
        val binding = AdapterItemCheckBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemScanViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemScanViewHolder, position: Int) {
        val item = items[position]
        holder.view.tvName.text = item.code

//        holder.view.tvDatetime.text = job.create.toString()
        if(item.checked) {
            holder.view.ivDone.setImageResource(R.drawable.baseline_check_circle_24)
        } else {
            holder.view.ivDone.setImageResource(R.drawable.baseline_cancel_24)
        }
    }
}