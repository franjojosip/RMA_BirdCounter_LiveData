package ht.ferit.fjjukic.birdcounterlivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClickCounterViewModel : ViewModel() {
    private var countLiveData = MutableLiveData<Int>()
    private var colorLiveData = MutableLiveData<Int>()

    fun getInitColor(): MutableLiveData<Int>{
        this.colorLiveData.value = PreferenceManager().retrieveColor()
        return this.colorLiveData
    }

    fun getInitCount(): MutableLiveData<Int>{
        this.countLiveData.value = PreferenceManager().retrieveCount()
        return this.countLiveData
    }

    fun add(colorId: Int){
        PreferenceManager().saveColor(colorId)
        PreferenceManager().saveCount(PreferenceManager().retrieveCount() + 1)
        this.countLiveData.value = PreferenceManager().retrieveCount()
        this.colorLiveData.value = PreferenceManager().retrieveColor()
    }

    fun resetCount(){
        PreferenceManager().saveCount(0)
        this.countLiveData.value = 0
    }

    fun resetColor(){
        PreferenceManager().saveColor(Colors.Default.colorId)
        this.colorLiveData.value = Colors.Default.colorId
    }
}