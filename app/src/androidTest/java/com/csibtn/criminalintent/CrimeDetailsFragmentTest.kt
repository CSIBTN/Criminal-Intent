package com.csibtn.criminalintent

import androidx.fragment.app.testing.FragmentScenario

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class CrimeDetailsFragmentTest {

    private lateinit var fragmentScenario : FragmentScenario<CrimeDetailsFragment>

    @Test
    fun testWhetherHookedUpOrNot() {
        fragmentScenario.onFragment{
            assertEquals(it.crime.isSolved,false)
            assertEquals(it.crime.title,"")
        }
    }
}