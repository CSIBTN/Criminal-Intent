package com.csibtn.criminalintent


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.csibtn.criminalintent.databinding.ListItemCrimeBinding
import android.text.format.DateFormat as DateFormat

class CrimeListAdapter(private val crimeList: List<Crime>) :
    RecyclerView.Adapter<CrimeListAdapter.CrimeHolder>() {
    inner class CrimeHolder(private val binding: ListItemCrimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(crime: Crime) {
            val formatDate = DateFormat.format("dd/MM/yy",crime.date)
            binding.crimeDate.text = formatDate
            binding.crimeTitle.text = crime.title
            if(crime.isSolved) binding.crimeSolved.visibility = View.VISIBLE else binding.crimeSolved.visibility = View.GONE

            binding.root.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "${crime.title} clicked!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binder = ListItemCrimeBinding.inflate(inflater)
        return CrimeHolder(binder)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimeList[position]
        holder.bind(crime)
    }


    override fun getItemCount(): Int = crimeList.size

}