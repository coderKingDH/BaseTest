import com.wangdh.basetest.entity.MovieEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者: wdh <br>
 * 内容摘要: <br>
 * 创建时间:  2016/8/22 17:53<br>
 * 描述:  <br>
 */
public interface MovieService {
    @GET("top250")
    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
}
