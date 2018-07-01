package com.example.sqlite.rzm.http;

import com.example.sqlite.rzm.http.interfaces.IDataListener;
import com.example.sqlite.rzm.http.interfaces.IHttpListener;
import com.example.sqlite.rzm.http.interfaces.IHttpService;

import java.util.concurrent.FutureTask;


public class Volley {
    /**
     *
     * @param <T>  请求参数类型
     * @param <M>  响应参数类型
     *           暴露给调用层
     */
    public static <T,M> void sendRequest(T  requestInfo, String url,
                                         Class<M> response, IDataListener dataListener)
    {
        RequestHodler<T> requestHodler=new RequestHodler<>();
        requestHodler.setUrl(url);
        IHttpService httpService=new JsonHttpService();
        IHttpListener httpListener=new JsonDealLitener<>(response,dataListener);
        requestHodler.setHttpService(httpService);
        requestHodler.setHttpListener(httpListener);
        //将请求参数赋值
        requestHodler.setRequestInfo(requestInfo);

        HttpTask<T> httpTask=new HttpTask<>(requestHodler);
        try {
            ThreadPoolManager.getInstance().execte(new FutureTask<Object>(httpTask,null));
        } catch (InterruptedException e) {
            dataListener.onErro();
        }
    }

}
