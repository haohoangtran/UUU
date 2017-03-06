package com.example.haohoang.microsofttest.services;

import com.example.haohoang.microsofttest.classlistdata.ClassStudent;
import com.example.haohoang.microsofttest.databases.model.request.UrlImage;
import com.example.haohoang.microsofttest.databases.model.respon.PersionFaceId;
import com.example.haohoang.microsofttest.databases.model.respon.PersionId;
import com.example.haohoang.microsofttest.sutudentdata.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by tranh on 3/5/2017.
 */

public interface PersionService  {
    @POST("{personGroupId}/persons")
    Call<PersionId> createPersion(@Path("personGroupId") String personGroupId, Student student);
    @POST("{personGroupId}/persons/{personId}/persistedFaces")
    Call<PersionFaceId> addPersionFace(@Path("personGroupId") String personGroupId, @Path("personId") String personId, @Body UrlImage url);
    @GET("{personGroupId}/persons")
    Call<List<Student>> getAllPersonInGroup(@Path("personGroupId")String personGroupId);


}
