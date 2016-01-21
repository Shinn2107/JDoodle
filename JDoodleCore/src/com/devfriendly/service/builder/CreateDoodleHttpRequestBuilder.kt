package com.devfriendly.service.builder

import com.devfriendly.data.CreateDoodleData
import com.devfriendly.data.CreateDoodleHttpRequest
import com.devfriendly.enums.HttpMethod

/**
 * Created by Shinn on 21.01.2016.
 */
class CreateDoodleHttpRequestBuilder {

    private val url : String = "http://doodle.com/create";
    private val userAgent : String = "Mozilla/5.0";
    private var buffer: StringBuffer = StringBuffer();

    fun buildRequestData(createDoodleRequestData: CreateDoodleData): CreateDoodleHttpRequest {
        val httpRequest = CreateDoodleHttpRequest(url,createDoodleRequestData.requestType.name)
        httpRequest.requestProperties.map { "User-Agent"; userAgent }

        addRequestParameter("type",createDoodleRequestData.type.name);
        addRequestParameter("levels",""+createDoodleRequestData.level.value)
        addRequestParameter("locale", createDoodleRequestData.locale!!)
        addRequestParameter("title", createDoodleRequestData.doodleTitle!!)
        addRequestParameter("location", createDoodleRequestData.location)
        addRequestParameter("description", createDoodleRequestData.description)
        addRequestParameter("name",createDoodleRequestData.name)
        when(createDoodleRequestData.requestType){
            HttpMethod.POST ->  addRequestParameter("emailAddress",createDoodleRequestData.eMailAddress!!)
        }
        addRequestParameter("hidden",""+createDoodleRequestData.hidden)

        httpRequest.urlParams = buffer.toString();
        return httpRequest
    }


    private fun addRequestParameter(name:String, value:String){
        if(buffer.length>0) buffer.append("&")
        buffer.append(name+"="+value)
    }
}
