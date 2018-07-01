package com.example.sqlite.rzm.http.interfaces;


public interface IDataListener<M> {
    /**
     * 回调结果给调用层
     * @param m
     */
     void onSuccess(M m);


      void onErro();
}
