package com.qiscus.internship.sudutnegeri.data.network;

import com.google.gson.JsonObject;
import com.qiscus.internship.sudutnegeri.data.model.UploadObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by vizyan on 02/01/18.
 */

public interface Api {

    @Headers("Content-Type: application/json")

    @GET("api/users")
    Call<JsonObject> getAllUser();

    @GET("api/projects")
    Call<JsonObject> getAllPorject();

    @GET("api/landings")
    Call<JsonObject> getPorjectTime();

    @GET("api/donation")
    Call<JsonObject> getDonation();

    //Get unverified user
    @GET("api/users/verify/{verify}")
    Call<JsonObject> getUserByVerify(
            @Path("verify") String verify
    );

    //Get unverified project
    @GET("api/projects/verify/{verify}")
    Call<JsonObject> getProjectByVerify(
            @Path("verify") String verify
    );

    @GET("api/users/{id}")
    Call<JsonObject> getUser(
            @Path("id") int id
    );

    @GET("api/projects/{id}")
    Call<JsonObject> getProject(
            @Path("id") int id
    );

    @GET("api/details/creator/{id}")
    Call<JsonObject> getProjectByUser(
            @Path("id") int id
    );

    //Update user
    @FormUrlEncoded
    @PUT("api/users/{id}")
    Call<JsonObject> putUser(
            @Path("id") int id,
            @Field("name") String name,
            @Field("address") String address,
            @Field("phone") String phone,
            @Field("verify") String no
    );

    //Update project
    @FormUrlEncoded
    @PUT("api/projects/{id}")
    Call<JsonObject> putProject(
            @Path("id") int id,
            @Field("name_project") String name_project,
            @Field("verify") String verify,
            @Field("location") String location,
            @Field("target_at") String target,
            @Field("information") String information,
            @Field("photo") String urlPhoto,
            @Field("id_user") int id_user,
            @Field("funds") int funds
    );

    @FormUrlEncoded
    @POST("api/register")
    Call<JsonObject> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("password_confirmation") String retypePassword,
            @Field("identity_number") String noIdentity,
            @Field("address") String address,
            @Field("phone") String phone,
            @Field("verify") String verify,
            @Field("photo") String photo
    );

    @FormUrlEncoded
    @POST("api/projects")
    Call<JsonObject> postProject(
            @Field("name_project") String name_project,
            @Field("verify") String verify,
            @Field("location") String location,
            @Field("target_at") String target,
            @Field("information") String information,
            @Field("photo") String urlPhoto,
            @Field("id_user") int id_user,
            @Field("funds") int funds,
            @Field("target_funds") int target_funds
    );

    //login user
    //generate token
    @FormUrlEncoded
    @POST("api/login/user")
    Call<JsonObject> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );

    //not generate token
    @FormUrlEncoded
    @POST("api/login/user/cek")
    Call<JsonObject> cekLoginUser(
            @Field("email") String email,
            @Field("password") String password
    );

    //login admin
    @FormUrlEncoded
    @POST("api/login/admin")
    Call<JsonObject> loginAdmin(
            @Field("email") String email,
            @Field("password") String password
    );

    @Multipart
    @POST("images/ImageUpload.php")
    Call<UploadObject> uploadFile(
            @Part MultipartBody.Part file,
            @Part("name") RequestBody name
    );

    @FormUrlEncoded
    @POST("api/logout")
    Call<JsonObject> logout(
            @Field("email") String email,
            @Field("password") String password
    );

    //Unverify user
    @DELETE("api/users/{id}")
    Call<JsonObject> deleteUser(
            @Path("id") int id
    );

    //Unverify project
    @DELETE("api/projects/{id}")
    Call<JsonObject> deleteProject(
            @Path("id") int id
    );
}
