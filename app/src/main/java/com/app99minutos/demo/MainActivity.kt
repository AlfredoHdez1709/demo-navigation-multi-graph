package com.app99minutos.demo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.app99minutos.core.databinding.BottomSheetLayoutBinding
import com.app99minutos.demo.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener{ _, destination, _ ->
            when(destination.id) {
                com.app99minutos.user.R.id.registerFragment,
                com.app99minutos.user.R.id.loginFragment -> {
                    binding.bottomNavigation.visibility = View.GONE
                }

                else -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                com.app99minutos.core.R.id.actionMenu -> {
                    showBottomSheetDialog()
                    true
                }
                else -> {
                    navController.navigate(it.itemId)
                    true
                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun showBottomSheetDialog() {
        val dialogBinding = BottomSheetLayoutBinding.inflate(layoutInflater)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(dialogBinding.root)
        bottomSheetDialog.show()

        dialogBinding.opc1.setOnClickListener {
            bottomSheetDialog.dismiss()
            navController.navigate(com.app99minutos.mi_unidad.R.id.vehicle_nav_graph)
        }
    }
}