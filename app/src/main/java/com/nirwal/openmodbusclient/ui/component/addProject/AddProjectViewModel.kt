package com.nirwal.openmodbusclient.ui.component.addProject

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nirwal.openmodbusclient.model.ModBusDeviceType
import com.nirwal.openmodbusclient.model.Project
import javax.inject.Inject

class AddProjectViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
)
    :ViewModel() {

    private var _project:Project = Project("New Project", ModBusDeviceType.Serial,
        "dd01","//dd",1
    )

    fun getProject(): Project {
        return _project
    }

    fun updateProject(project:Project){
        _project = project
    }

}