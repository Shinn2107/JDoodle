package com.devfriendly.service.impl

import com.devfriendly.data.CreateDoodleData
import com.devfriendly.data.CreateDoodleHttpRequest
import com.devfriendly.data.response.DoodleCreationInformationData
import com.devfriendly.enums.DoodleCreatedType
import com.devfriendly.enums.HttpMethod
import com.devfriendly.service.JDoodleService
import com.devfriendly.service.builder.CreateDoodleHttpRequestBuilder
import com.devfriendly.service.exception.DoodleCreationException
import com.devfriendly.validator.CreateDoodleRequestValidator
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by Shinn on 21.01.2016.
 */
class JDoodleServiceImpl : JDoodleService{

    var doodleValidator: CreateDoodleRequestValidator = CreateDoodleRequestValidator();
    var createRequestBuilder: CreateDoodleHttpRequestBuilder = CreateDoodleHttpRequestBuilder();

    override fun createDoodle(createDoodleRequest: CreateDoodleData): DoodleCreationInformationData {
        doodleValidator.validate(createDoodleRequest)

        val httpRequest = createRequestBuilder.buildRequestData(createDoodleRequest);

        val url = URL(httpRequest.url)
        val con:HttpURLConnection = url.openConnection() as HttpURLConnection
        con.requestMethod = httpRequest.requestType;
        con.requestProperties.map { httpRequest.requestProperties }
        con.doOutput= true

        val outputStream : DataOutputStream = DataOutputStream(con.outputStream)
        outputStream.writeBytes(httpRequest.urlParams)
        outputStream.flush()
        outputStream.close()

        val responseCode = con.responseCode
        System.out.println("\nSending '${httpRequest.requestType}' request to URL : " + url);
        System.out.println("${httpRequest.requestType} parameters : " + httpRequest.urlParams);
        System.out.println("Response Code : " + responseCode);

        if(responseCode!=200) throw DoodleCreationException("Doodle did not respond with a 200 Code, which means someting went wrong. Response code was:"+responseCode)

        when(createDoodleRequest.requestType){
            HttpMethod.POST -> return DoodleCreationInformationData(httpRequest.url+"?"+httpRequest.urlParams,"Doodle has been successfully created", DoodleCreatedType.DOODLE_CREATED)
            else -> return DoodleCreationInformationData(httpRequest.url+"?"+httpRequest.urlParams,"Doodle is ready to be edited, redirect to the given url", DoodleCreatedType.DOODLE_EDITABLE)
        }

    }

    override fun getDoodleInformation() {

    }


}
