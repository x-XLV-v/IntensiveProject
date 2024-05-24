package com.example.intensiveproject.main.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intensiveproject.R
import com.example.intensiveproject.crypto.di.ManageViewModels
import com.example.intensiveproject.crypto.presentation.CryptoNavigation
import com.example.intensiveproject.crypto.presentation.CryptoScreen
import com.example.intensiveproject.databinding.ActivityMainBinding
import com.example.intensiveproject.load.presentation.views.LoadNavigation
import com.example.intensiveproject.load.presentation.views.LoadScreen

class MainActivity : AppCompatActivity(), Navigation, ManageViewModels {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = viewModel(MainViewModel::class.java)

        val lastScreen = viewModel.init(savedInstanceState == null)
        navigate(lastScreen)
    }

    override fun clear(clazz: Class<out MyViewModel>) {

    }

    override fun <T : MyViewModel> viewModel(clazz: Class<T>): T {

    }

    override fun navigate(screen: Screen) {
        screen.show(R.id.container, supportFragmentManager)
    }

}

interface Navigation : CryptoNavigation, LoadNavigation {
    fun navigate(screen: Screen)

    override fun navigateFromCryptoScreen() {
        navigate(LoadScreen)
    }

    override fun navigateFromLoad() {
        navigate(CryptoScreen)
    }
}