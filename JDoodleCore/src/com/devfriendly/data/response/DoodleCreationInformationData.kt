package com.devfriendly.data.response

import com.devfriendly.enums.DoodleCreatedType

/**
 * Created by Shinn on 21.01.2016.
 */

data class DoodleCreationInformationData(
        val doodleUrl: String,
        val information: String,
        val doodleCreatedType: DoodleCreatedType
)
