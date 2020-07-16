package com.example.busticketonlineboking.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.busticketonlineboking.R
import com.example.busticketonlineboking.model.Trip
import com.example.busticketonlineboking.viewModel.SearchTripVM
import kotlinx.android.synthetic.main.item_car_information.view.*
import kotlinx.android.synthetic.main.item_search_trip.view.*

class SearchTripAdapter(var searchTripList: List<Trip> = emptyList()):
    RecyclerView.Adapter<SearchTripAdapter.SearchTripViewHolder>(){

    var mClickListener: TripAdapter.ClickListener? = null

    fun setClickListener(clickListener: TripAdapter.ClickListener) {
        this.mClickListener = clickListener
    }

    inner class SearchTripViewHolder (item: View): RecyclerView.ViewHolder(item),View.OnClickListener{

        private lateinit var searchTripResult: Trip


        fun bind(searchTrip: Trip) {
            itemView.txtDepartureTime.text = searchTrip.departure_time
            itemView.tripRoute.text = searchTrip.route_id.id.toString()
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClickTripAdapter(searchTripResult)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchTripViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_trip,parent,false)
        return SearchTripViewHolder(view)    }

    override fun getItemCount(): Int {
        return searchTripList.size
    }

    override fun onBindViewHolder(holder: SearchTripViewHolder, position: Int) {
        holder.bind(searchTripList[position])
    }

    fun upDateList(mealList: List<Trip>) {
        this.searchTripList = mealList
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onClickTripAdapter(tripResultList : Trip)
    }
}