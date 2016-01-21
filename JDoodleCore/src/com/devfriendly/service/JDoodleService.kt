package com.devfriendly.service

import com.devfriendly.data.CreateDoodleData
import com.devfriendly.data.response.DoodleCreationInformationData

/**
 * Created by Shinn Fey on 21.01.2016.
 */
interface JDoodleService{
    fun createDoodle(createDoodleRequest: CreateDoodleData): DoodleCreationInformationData
    fun getDoodleInformation()
}

