package com.example.busticketonlineboking.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.busticketonlineboking.R
import com.example.busticketonlineboking.adapter.SearchTripAdapter
import com.example.busticketonlineboking.adapter.TripAdapter
import com.example.busticketonlineboking.model.Trip
import com.example.busticketonlineboking.viewModel.CityViewModel
import com.example.busticketonlineboking.viewModel.SearchTripVM
import kotlinx.android.synthetic.main.fragment_search_trip.*

class SearchTripFragment : Fragment(), TripAdapter.ClickListener {

    lateinit var searchTripViewModel: SearchTripVM
    private lateinit var searchTripAdapter: SearchTripAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_trip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchTripAdapter = SearchTripAdapter()
        recyclerSearchTirp.apply {
            adapter = searchTripAdapter
            layoutManager = LinearLayoutManager(context)
        }
        obserViewModel()

    }

    override fun onResume() {
        super.onResume()
        searchTripViewModel.loadSearch("departure_time","route_id")
    }

    fun obserViewModel() {
        searchTripViewModel = ViewModelProvider(this).get(SearchTripVM::class.java)

        searchTripViewModel.getSearchTrip().observe(viewLifecycleOwner,
            Observer {
                searchTripAdapter.upDateList(it)
            })
    }

    override fun onClickTripAdapter(tripResultList: Trip) {

    }


}