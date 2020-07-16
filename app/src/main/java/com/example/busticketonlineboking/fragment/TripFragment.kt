package com.example.busticketonlineboking.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.busticketonlineboking.R
import com.example.busticketonlineboking.adapter.RouteAdapter
import com.example.busticketonlineboking.model.Trip
import com.example.busticketonlineboking.model.TripX
import com.example.busticketonlineboking.viewModel.SearchTripVM
import com.example.busticketonlineboking.viewModel.TripViewModel
import kotlinx.android.synthetic.main.fragment_trip.*

class TripFragment : Fragment(), RouteAdapter.ClickListener {

    private lateinit var srarchViewModel: SearchTripVM
    private var routeAdapter: RouteAdapter = RouteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_trip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        srarchViewModel = ViewModelProvider(this).get(SearchTripVM::class.java)
        var data = arguments.let { TripFragmentArgs.fromBundle(it!!) }
        var resultDepartureTime = data.departureTime
        var routeId = data.routeId
        srarchViewModel.loadSearch(resultDepartureTime, routeId)
        recycler.apply {
            adapter = routeAdapter
            layoutManager = LinearLayoutManager(context)
        }
        srarchViewModel.getSearchTrip().observe(
            viewLifecycleOwner,
            Observer {
                routeAdapter.setClickListener(this)
                routeAdapter.updateList(it)
            }
        )
    }

    override fun onClickTripAdapter(tripResultList: TripX) {
        Log.e("TRIP TYPE", tripResultList.class_name)
        if (tripResultList.class_name=="VIP"){
            findNavController().navigate(R.id.vipFragment2)
        }
        if (tripResultList.class_name=="Standard"){
            findNavController().navigate(R.id.standardFragment2)
        }
    }
}