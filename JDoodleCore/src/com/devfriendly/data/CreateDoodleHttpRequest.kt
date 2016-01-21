package com.devfriendly.data

import java.util.*

/**
 * Created by Shinn on 21.01.2016.
 */

data class CreateDoodleHttpRequest(

        var url: String,
        val  requestType: String,
        var requestProperties: Map<String,List<String>> = HashMap<String,List<String>>(),
        var  urlParams:String? = ""
)
