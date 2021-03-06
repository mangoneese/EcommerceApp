package com.ecommerce.ecommerceapp.Retrofit;


import com.ecommerce.ecommerceapp.Model.Banner;
        import com.ecommerce.ecommerceapp.Model.Category;
        import com.ecommerce.ecommerceapp.Model.CheckUserResponse;
        import com.ecommerce.ecommerceapp.Model.Drink;
import com.ecommerce.ecommerceapp.Model.Order;
import com.ecommerce.ecommerceapp.Model.User;


        import java.util.List;


        import io.reactivex.Observable;
        import okhttp3.MultipartBody;
        import retrofit2.Call;
        import retrofit2.http.Field;
        import retrofit2.http.FormUrlEncoded;
        import retrofit2.http.GET;
        import retrofit2.http.Multipart;
        import retrofit2.http.POST;
        import retrofit2.http.Part;

public interface EcommerceApi {
    @FormUrlEncoded
    @POST("checkuser.php")
    Call<CheckUserResponse> checkUserExists(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("register.php")
    Call<User> registerNewUser(@Field("phone") String phone,
                               @Field("name") String name,
                               @Field("address") String address,
                               @Field("birthdate") String birthdate);
    @FormUrlEncoded
    @POST("getuser.php")
    Call<User> getUserInformation(@Field("phone") String phone);

    @GET("getbanner.php")
    Observable<List<Banner>> getBanners();

    @GET("getmenu.php")
    Observable<List<Category>> getMenu();

    @FormUrlEncoded
    @POST("getdrink.php")
    Observable<List<Drink>> getDrink(@Field("menuid") String menuID);

    @Multipart
    @POST("upload.php")
    Call<String> uploadAvatar(@Part MultipartBody.Part phone, @Part MultipartBody.Part file);

    @GET("getAllDrinks.php")
    Observable<List<Drink>> getAllDrinks();

    @FormUrlEncoded
    @POST("submitorder.php")
    Call<String> submitOrder(@Field("price") float orderPrice,
                             @Field("orderDetail") String orderDetail,
                             @Field("comment")String comment,
                             @Field("address")String address,
                             @Field("phone")String phone);

    @FormUrlEncoded
    @POST("getorders.php")
    Observable<List<Order>> getOrder(@Field("userPhone") String phone,
                                     @Field("status") String status);

}
