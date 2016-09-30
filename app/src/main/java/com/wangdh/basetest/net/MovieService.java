package com.wangdh.basetest.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 作者: wdh <br>
 * 内容摘要: <br>
 * 创建时间:  2016/8/25 15:28<br>
 * 描述:  <br>
 */
public interface MovieService {
    @POST("v2/movie/top250")
    Call<ResponseBody> getTopMovie(@Query("start") int start, @Query("count") int count);
}
