package com.wangdh.basetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wangdh.basetest.dao.GreenDaoManager;
import com.wangdh.basetest.dao.UserDao;
import com.wangdh.basetest.dao.imp.UserDaoImpl;
import com.wangdh.basetest.entity.User;
import com.wangdh.basetest.net.MovieService;
import com.wangdh.basetest.utils.TLog;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TLog.l("MainActivity");
        resultTV = (TextView) findViewById(R.id.resultTV);

    }
    public void click3(View view) {
        List<User> all = UserDaoImpl.getAll();
        if(all!=null){
            for(User u:all){
                TLog.l(u.toString());
            }
        }else{
           TLog.l("无数据");
        }
    }
    public void click4(View view) {
        UserDaoImpl.sql();
    }
    private static int anInt = 0;
    public void click2(View view) {
        insertUser("小明"+anInt);
    }

    /**
     * 本地数据里添加一个User
     * @param name  名字
     */
    private void insertUser(String name) {
        UserDao userDao = GreenDaoManager.getInstance().getSession().getUserDao();
        User user = new User();
        user.setName(name);
        userDao.insert(user);
    }

    public void click1(View view) {
        TLog.l("click12");
        String baseUrl = "https://api.douban.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        MovieService movieService = retrofit.create(MovieService.class);
        Call<ResponseBody> call = movieService.getTopMovie(0, 10);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    resultTV.setText("onResponse" + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                resultTV.setText("onFailure" + t.getMessage());
            }
        });
    }

}
