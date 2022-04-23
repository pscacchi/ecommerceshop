package ar.scacchipa.e_commerce.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ar.scacchipa.e_commerce.databinding.ActivityMainBinding
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupKoinFragmentFactory()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)

    }

}