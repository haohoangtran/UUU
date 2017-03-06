package com.example.haohoang.microsofttest.services;

import com.example.haohoang.microsofttest.classlistdata.ClassStudent;
import com.example.haohoang.microsofttest.databases.model.JSON.GetPersionGroupResponJSON;
import com.example.haohoang.microsofttest.databases.model.JSON.GetPersonGroupTrainingStatusJSON;
import com.example.haohoang.microsofttest.databases.model.bodies.AddNewGroupBody;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by haohoang on 3/1/17.
 */

public interface FaceGroupService {
    @PUT("{personGroupId}")
    Call<String> addNewGroupFace(@Path("personGroupId") String personGroupId, @Body AddNewGroupBody addNewGroupBody);
    @DELETE("{personGroupId}")
    Call<String> deleteGroupFace(@Path("personGroupId") String personGroupId);
    @GET("{personGroupId}")
    Call<GetPersionGroupResponJSON> getGroupFace(@Path("personGroupId")String personGroupId );
    @GET("{personGroupId}/training")
    Call<GetPersonGroupTrainingStatusJSON> getPersonGroupTrainingStatus(@Path("personGroupId") String personGroupId);
    @POST("{personGroupId}/train")
    Call<Void> trainAI(@Path("personGroupId") String personGroupId);
    @GET
    Call<List<ClassStudent>> getAllGroup(@Url String URL);

}
