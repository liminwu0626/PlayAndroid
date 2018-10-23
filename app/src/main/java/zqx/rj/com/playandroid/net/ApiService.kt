package zqx.rj.com.playandroid.net

import retrofit2.http.*
import rx.Observable
import zqx.rj.com.mvvm.http.response.BaseResponse
import zqx.rj.com.playandroid.account.data.bean.response.LoginRsp
import zqx.rj.com.playandroid.home.data.bean.*
import zqx.rj.com.playandroid.navigation.data.bean.NaviCategoryRsp
import zqx.rj.com.playandroid.system.data.bean.TopTreeRsp
import zqx.rj.com.playandroid.system.data.bean.TreeArticleRsp

/**
 * author：  HyZhan
 * created： 2018/10/10 16:43
 * desc：    Api  (来自 hongyang大神的玩Android Api -> http://www.wanandroid.com/blog/show/2 )
 */
interface ApiService {

    @POST("/user/login")
    fun getLogin(@Query("username") username: String,
                 @Query("password") password: String): Observable<BaseResponse<LoginRsp>>

    @GET("/banner/json")
    fun getBanner(): Observable<BaseResponse<List<BannerRsp>>>

    @GET("/article/list/{page}/json")
    fun getHomeArticle(@Path("page") page: Int): Observable<BaseResponse<HomeArticleRsp>>

    @GET("/hotkey/json")
    fun getHotKey(): Observable<BaseResponse<List<HomeHotKeyRsp>>>

    @POST("/article/query/{page}/json")
    fun search(@Path("page") page: Int, @Query("k") key: String): Observable<BaseResponse<HomeSearchRsp>>

    @GET("/friend/json")
    fun getCommonWeb(): Observable<BaseResponse<List<CommonWebRsp>>>

    @GET("/navi/json")
    fun getCategory(): Observable<BaseResponse<List<NaviCategoryRsp>>>

    @GET("/tree/json")
    fun getTree(): Observable<BaseResponse<List<TopTreeRsp>>>

    @GET("/article/list/{page}/json")
    fun getTreeArticle(@Path("page") page: Int, @Query("cid") id: Int): Observable<BaseResponse<TreeArticleRsp>>
}