package edu.msudenver.cs3013.trailfinder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrailViewModel : ViewModel() {

    private val _trails = MutableLiveData<List<Trail>>()

    val trails: LiveData<List<Trail>> = _trails

    init {
        _trails.value = listOf(
            Trail(0, "Bear Creek Trail", "Denver, CO", "3.2 mi", "Easy", "Scenic creekside path through Bear Creek Lake Park."),
            Trail(1, "Green Mountain Loop", "Lakewood, CO", "6.8 mi", "Moderate", "Panoramic views of Denver and the Front Range."),
            Trail(2, "Red Rocks Trail", "Morrison, CO", "1.4 mi", "Easy", "Short trail through iconic red sandstone formations."),
            Trail(3, "Mount Falcon Loop", "Morrison, CO", "5.0 mi", "Moderate", "Classic loop with sweeping views of Mount Evans."),
            Trail(4, "South Table Mountain", "Golden, CO", "4.2 mi", "Easy", "Flat mesa-top trail above Golden with great views."),
            Trail(5, "Roxborough State Park", "Littleton, CO", "3.0 mi", "Moderate", "Dramatic trail through towering red rock fins.")
        )
    }

    fun getTrailById(id: Int): Trail? = _trails.value?.find { it.id == id }
}