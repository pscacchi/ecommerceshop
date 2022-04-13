package ar.scacchipa.e_commerce.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ar.scacchipa.e_commerce.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return Navigation.findNavController(this, R.id.nav_graph)
//            .navigateUp()
//                || super.onSupportNavigateUp()
//    }
}