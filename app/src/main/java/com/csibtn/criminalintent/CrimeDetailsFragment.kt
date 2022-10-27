package com.csibtn.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.csibtn.criminalintent.databinding.FragmentCrimeDetailBinding
import java.util.*

class CrimeDetailsFragment : Fragment() {

    lateinit var crime: Crime
    private var _crimeFrBinder: FragmentCrimeDetailBinding? = null
    private val crimeFrBinder: FragmentCrimeDetailBinding
    get() = checkNotNull(_crimeFrBinder){
        "Cannot access binding. Is the view visible?"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _crimeFrBinder = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        return crimeFrBinder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crimeFrBinder.apply {
            crimeTitle.doOnTextChanged { text, _, _, _ ->
                crime = crime.copy(title = text.toString())
            }
            crimeDate.apply {
                text = crime.date.toString()
                isEnabled = false
            }
            crimeSolved.setOnCheckedChangeListener { _, isChecked ->
                crime = crime.copy(isSolved = isChecked)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _crimeFrBinder = null
    }
}