package ir.alirezanazari.vehicles.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.alirezanazari.vehicles.R
import ir.alirezanazari.vehicles.data.net.entity.Vehicle
import ir.alirezanazari.vehicles.internal.ImageLoader
import kotlinx.android.synthetic.main.row_vehicle.view.*


class VehiclesAdapter(
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<VehiclesAdapter.VehiclesViewHolder>() {

    private val items = ArrayList<Vehicle>()

    fun setItems(data: List<Vehicle>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesViewHolder {
        return VehiclesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_vehicle, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VehiclesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class VehiclesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Vehicle) {
            itemView.apply {
                tvType.text = "Snapp ${item.type}"
                imageLoader.load(ivImage, item.imageUrl)
            }
        }
    }
}