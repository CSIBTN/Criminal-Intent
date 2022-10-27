package com.csibtn.criminalintent

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

private const val TAG = "CrimeListViewModel"

class CrimeListViewModel : ViewModel() {

    @WorkerThread
    suspend fun loadCrimes(): List<Crime> {
        return CrimeRepository.get().getCrimes()
    }

}