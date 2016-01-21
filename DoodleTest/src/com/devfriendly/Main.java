package com.devfriendly;

import com.devfriendly.data.CreateDoodleData;
import com.devfriendly.data.response.DoodleCreationInformationData;
import com.devfriendly.enums.HttpMethod;
import com.devfriendly.service.JDoodleService;
import com.devfriendly.service.impl.JDoodleServiceImpl;

/**
 * Created by Shinn on 21.01.2016.
 */
public class Main {


    public static void main(String[] args){
        JDoodleService jDoodleService = new JDoodleServiceImpl();
        CreateDoodleData createDoodleRequest = new CreateDoodleData();
        createDoodleRequest.setDoodleTitle("FirstTitle");
        createDoodleRequest.setRequestType(HttpMethod.GET);
        createDoodleRequest.setLocale("de_DE");
        DoodleCreationInformationData informationData = jDoodleService.createDoodle(createDoodleRequest);
        System.out.println(informationData.toString());
    }
}
