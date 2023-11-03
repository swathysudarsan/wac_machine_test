package com.example.sampleappwac

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.sampleappwac.databinding.ActivityMainBinding
import com.example.sampleappwac.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private var navControl: NavController? = null
    lateinit var binding: ActivityMainBinding
    lateinit var sharedViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navControl = (supportFragmentManager.findFragmentById(R.id.navContainer) as NavHostFragment).navController
        val navController = (supportFragmentManager.findFragmentById(R.id.navContainer) as NavHostFragment).navController
        val graph = navController.navInflater.inflate(R.navigation.main_navigation)
        navController.setGraph(graph, intent?.extras)
        bottomMenu()


    }


    fun bottomMenu() {
        binding.bottomNavLL.root.apply {

            val IMs = arrayOf(
                binding.bottomNavLL.homeBtn,
                binding.bottomNavLL.categoryBtn,
                binding.bottomNavLL.offerBtn,
                binding.bottomNavLL.cartBtn,
                binding.bottomNavLL.accountBtn,
            )
            fun bottomMenuOnSelection() {


                IMs.forEachIndexed { index, img ->
                    img.setOnClickListener {
                        sharedViewModel.bottomNavigationIndex.value = index
                        bottomMenuOnSelection()
                        gotoBottomNavigationpages()
                    }

                }
            }


            sharedViewModel.bottomNavigationIndex.observe(this@MainActivity) {
                bottomMenuOnSelection()
            }

        }


    }


    fun gotoBottomNavigationpages() {

        when (sharedViewModel.bottomNavigationIndex.value) {
            0 -> navControl?.navigate(R.id.homeFragment)
            1 -> navControl?.navigate(R.id.categoryFragment)
            2 -> navControl?.navigate(R.id.offerFragment)
            3 -> navControl?.navigate(R.id.cartFragment)
            4 -> navControl?.navigate(R.id.accountFragment)
        }

    }
}