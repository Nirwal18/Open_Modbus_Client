package com.nirwal.openmodbusclient.ui.component

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nirwal.openmodbusclient.model.ModBusDeviceType
import com.nirwal.openmodbusclient.model.Project
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    //private val sampleString: String
)
    :ViewModel(){
    private val TAG = "HomeViewModel"

    val _projets = ArrayList<Project>()
    init {
        _projets.add(Project("Project1", ModBusDeviceType.Serial, "device1","",1))
        _projets.add(Project("Project2", ModBusDeviceType.TCP_IP, "device1","",2))
    }


    fun getProjects():List<Project>{
        return _projets
    }

}