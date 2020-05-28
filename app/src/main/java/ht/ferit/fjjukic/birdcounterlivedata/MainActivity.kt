package ht.ferit.fjjukic.birdcounterlivedata

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import ht.ferit.fjjukic.birdcounterlivedata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var btnRedBird: Button
    private lateinit var btnBlueBird: Button
    private lateinit var btnGreenBird: Button
    private lateinit var btnYellowBird: Button
    private lateinit var btnResetColor: Button
    private lateinit var btnResetCount: Button
    private lateinit var clickCounterViewModel: ClickCounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){
        setBinding()
        this.btnRedBird = findViewById(R.id.btnRed)
        this.btnBlueBird = findViewById(R.id.btnBlue)
        this.btnGreenBird = findViewById(R.id.btnGreen)
        this.btnYellowBird = findViewById(R.id.btnYellow)
        this.btnResetColor = findViewById(R.id.btnResetColor)
        this.btnResetCount = findViewById(R.id.btnResetCount)
        setButtonListener()
    }

    private fun setBinding() {
        this.clickCounterViewModel = ViewModelProviders.of(this).get(ClickCounterViewModel::class.java)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = this.clickCounterViewModel
        binding.lifecycleOwner = this
    }

    private fun setButtonListener() {
        this.btnRedBird.setOnClickListener{
            this.clickCounterViewModel.add(Colors.Red.colorId)
        }
        this.btnBlueBird.setOnClickListener{
            this.clickCounterViewModel.add(Colors.Blue.colorId)
        }
        this.btnGreenBird.setOnClickListener{
            this.clickCounterViewModel.add(Colors.Green.colorId)
        }
        this.btnYellowBird.setOnClickListener{
            this.clickCounterViewModel.add(Colors.Yellow.colorId)
        }
        this.btnResetColor.setOnClickListener{
            this.clickCounterViewModel.resetColor()
        }
        this.btnResetCount.setOnClickListener{
            this.clickCounterViewModel.resetCount()
        }
    }
}
