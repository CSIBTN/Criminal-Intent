package com.csibtn.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.csibtn.criminalintent.databinding.FragmentCrimeListBinding
import kotlinx.coroutines.launch

class CrimeListFragment : Fragment() {
    private val crimeListViewModel: CrimeListViewModel by viewModels()
    private var _crimeListBinder: FragmentCrimeListBinding? = null
    private val crimeListBinder: FragmentCrimeListBinding
        get() = checkNotNull(_crimeListBinder)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _crimeListBinder = FragmentCrimeListBinding.inflate(layoutInflater)
        crimeListBinder.crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        return crimeListBinder.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _crimeListBinder = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                val crimes = crimeListViewModel.loadCrimes()
                crimeListBinder.crimeRecyclerView.adapter =
                    CrimeListAdapter(crimes)
            }
        }


    }
}