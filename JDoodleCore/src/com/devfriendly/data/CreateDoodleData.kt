package com.devfriendly.data

import com.devfriendly.enums.DoodleLevel
import com.devfriendly.enums.DoodleType
import com.devfriendly.enums.HttpMethod

/**
 * Created by Shinn on 21.01.2016.
 */

data class CreateDoodleData(
        var type: DoodleType = DoodleType.DATE,
        var level: DoodleLevel = DoodleLevel.YES_NO,
        var locale: String?=null,
        val location: String="",
        var description: String="",
        var doodleTitle:String?=null,
        var name:String="",
        var eMailAddress: String?=null,
        var hidden: Boolean = false,
        var requestType: HttpMethod = HttpMethod.POST
) {

}
