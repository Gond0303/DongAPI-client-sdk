package com.dong.dongapiclientsdk.service;

import com.dong.dongapiclientsdk.client.DongApiClient;
import com.dong.dongapiclientsdk.exception.ApiException;
import com.dong.dongapiclientsdk.model.request.*;
import com.dong.dongapiclientsdk.model.response.LoveResponse;
import com.dong.dongapiclientsdk.model.response.ResultResponse;

/**
 * 所有接口
 */
public interface ApiService {
    /**
     * 通用请求
     *
     * @param request 要求
     * @throws ApiException 业务异常
     */

    <O, T extends ResultResponse> T request(BaseRequest<O, T> request) throws ApiException;

    /**
     * 通用请求
     *
     * @param dongApiClient dong api客户端
     * @param request     要求
     * @return {@link T}
     * @throws ApiException 业务异常
     */
    <O, T extends ResultResponse> T request(DongApiClient dongApiClient, BaseRequest<O, T> request) throws ApiException;

    /**
     * 1.随意情话
     *
     * @return {@link LoveResponse}
     * @throws ApiException 业务异常
     */
    LoveResponse randomLoveTalk() throws ApiException;

    /**
     * 随意情话携带客户端
     *
     * @param dongApiClient dong api客户端
     * @return {@link LoveResponse}
     * @throws ApiException 业务异常
     */
    LoveResponse randomLoveTalk(DongApiClient dongApiClient) throws ApiException;


    /**
     * 2.抖音视频
     * @return
     * @throws ApiException 业务异常
     */
    ResultResponse dyResponse(DyRequest dyRequest) throws ApiException;


    /**
     * 抖音视频携带客户端
     * @param dongApiClient
     * @return
     * @throws ApiException
     */
    ResultResponse dyResponse(DongApiClient dongApiClient,DyRequest dyRequest) throws ApiException;


    /**
     * 3.网易云音乐
     * @return
     * @throws ApiException
     */
    ResultResponse wyyMusicResponse(WyyMusicRequest wyyMusicRequest) throws ApiException;


    /**
     * 网易云音乐携带客户端
     * @param dongApiClient
     * @return
     * @throws ApiException
     */
    ResultResponse wyyMusicResponse(DongApiClient dongApiClient,WyyMusicRequest wyyMusicRequest) throws ApiException;


    /**
     * 4.全网短剧
     * @return
     * @throws ApiException
     */
    ResultResponse bddjResponse(BddjRequest bddjRequest) throws  ApiException;


    /**
     * 全网短剧携带客户端
     * @param dongApiClient
     * @return
     * @throws ApiException
     */
    ResultResponse bddjResponse(DongApiClient dongApiClient,BddjRequest bddjRequest) throws ApiException;


    /**
     * 5.小众头像
     * @return
     * @throws ApiException
     */
    ResultResponse avatarResponse(AvatarRequest avatarRequest) throws ApiException;

    /**
     * 小众头像携带客户端
     * @param dongApiClient
     * @return
     * @throws ApiException
     */
    ResultResponse avatarResponse(DongApiClient dongApiClient,AvatarRequest avatarRequest) throws ApiException;


    /**
     * 6.一周天气
     * @return
     * @throws ApiException
     */
    ResultResponse  weatherResponse(WeatherRequest weatherRequest) throws  ApiException;


    /**
     * 一周天气携带客户端
     * @param dongApiClient
     * @return
     * @throws ApiException
     */
    ResultResponse  weatherResponse(DongApiClient dongApiClient,WeatherRequest weatherRequest) throws ApiException;



    ResultResponse getRandomWall(RandomWallpaperRequest request) throws ApiException;






}
