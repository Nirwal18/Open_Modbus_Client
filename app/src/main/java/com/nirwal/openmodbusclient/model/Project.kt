package com.nirwal.openmodbusclient.model

data class Project(
    var title:String,
    var comType: String,
    var device:String,
    var communicationAddress:String,
    var deviceId:Int,
){
    fun updateCurrent(arg:Project){
        title = arg.title
        comType =arg.comType
        device = arg.device
        communicationAddress = arg.communicationAddress
        deviceId = arg.deviceId
    }
}

object  ModBusDeviceType{
    val Serial = "Serial"
    val TCP_IP = "TCP_IP"

    val toList= listOf("Select below Device type",Serial, TCP_IP)
}