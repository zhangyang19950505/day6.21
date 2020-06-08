package com.jiyun.frame.api;

import java.util.Map;

import com.google.gson.JsonObject;
import com.jiyun.bean.CourseDrillBean;
import com.jiyun.bean.DataSquadBean;
import com.jiyun.bean.HomeBottomDataBean;
import com.jiyun.bean.HomeTopDataBean;
import com.jiyun.bean.NewsEliteBean;
import com.jiyun.bean.VIPBannerBean;
import com.jiyun.bean.VIPBottomDataBean;
import com.jiyun.frame.bean.BaseInfo;
import com.jiyun.frame.bean.LeadBean;
import com.jiyun.frame.bean.FuliBean;
import com.jiyun.frame.bean.LoginInfo;
import com.jiyun.frame.bean.PersonHeader;
import com.jiyun.frame.bean.SpecialtyBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {
    @FormUrlEncoded
    @POST(".")
        //c=api&a=getList&page_id=0
    Observable<FuliBean> getFuliData(@FieldMap Map<String, Object> map, @Field("page_id") int pageId);

    @FormUrlEncoded
    @POST("ad/getAd")
    Observable<LeadBean> getLeadData(@FieldMap Map<String, Object> map);

    @GET("lesson/getAllspecialty")
    Observable<SpecialtyBean> getSpecialtyData();

    @GET("loginByMobileCode")
    Observable<BaseInfo<String>> getLoginVerify(@Query("mobile") String mobile);

    @GET("loginByMobileCode")
    Observable<BaseInfo<LoginInfo>> loginByVerify(@QueryMap Map<String, Object> params);

    @POST("getUserHeaderForMobile")
    @FormUrlEncoded
    Observable<BaseInfo<PersonHeader>> getHeaderInfo(@FieldMap Map<String, Object> params);

    //课程训练营
    @GET("lesson/getLessonListForApi")
    Observable<CourseDrillBean> getCourseDrillData(@QueryMap Map<String, Object> map);

    //资料，小组
    @GET("group/getGroupList")
    Observable<DataSquadBean> getDataSquadData(@QueryMap Map<String, Object> map);

    //资料，最新精华
    @GET("group/getThreadEssence")
    Observable<NewsEliteBean> getNewsEliteData(@QueryMap Map<String, Object> map);

    //vip
    @GET("lesson/get_new_vip")
    Observable<VIPBannerBean>getVIPBannerData();

    //vip recyclerview接口
    @GET("lesson/getVipSmallLessonList")
    Observable<VIPBottomDataBean>getVIPBottomData(@QueryMap Map<String,Object>map);

    //主页 banner
    @GET("lesson/getCarouselphoto")
    Observable<JsonObject>getHomeTopData(@QueryMap Map<String,Object>map);
    //主页 recyclerview
    @GET("lesson/getIndexCommend")
    Observable<HomeBottomDataBean>getHomeBottomData(@QueryMap Map<String,Object>map);
}
