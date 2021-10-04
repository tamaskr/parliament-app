package com.tamask.parliamentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home2,
                R.id.partyListFragment,
                R.id.filteredMemberListFragment,
                R.id.memberDataFragment2,
                R.id.constituencyListFragment
            )
        )

        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment), appBarConfiguration)
    }
}