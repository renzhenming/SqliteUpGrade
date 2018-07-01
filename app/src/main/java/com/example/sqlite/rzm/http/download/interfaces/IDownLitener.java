package com.example.sqlite.rzm.http.download.interfaces;

import com.example.sqlite.rzm.http.interfaces.IHttpListener;
import com.example.sqlite.rzm.http.interfaces.IHttpService;


public interface IDownLitener  extends IHttpListener{

    void setHttpServive(IHttpService  httpServive);


    void  setCancleCalle();


    void  setPuaseCallble();

}
