package com.devfriendly.validator

import com.devfriendly.data.CreateDoodleData
import com.devfriendly.enums.HttpMethod

/**
 * Created by Shinn on 21.01.2016.
 */
class CreateDoodleRequestValidator {

    fun validate(createDoodleRequest: CreateDoodleData){
        checkNotNull(createDoodleRequest.doodleTitle){ "DoodleName is not but not allowed to be null" };
        when(createDoodleRequest.requestType){
           HttpMethod.POST -> checkNotNull(createDoodleRequest.eMailAddress){ "If request type is Post, e-mail address can't be null" };
        }
        checkNotNull(createDoodleRequest.locale){ "Locale is always required, there is no default." };
    }
}
