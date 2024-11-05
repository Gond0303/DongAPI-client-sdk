package com.dong.dongapiclientsdk.service.impl;

import com.dong.dongapiclientsdk.client.DongApiClient;
import com.dong.dongapiclientsdk.exception.ApiException;
import com.dong.dongapiclientsdk.model.request.*;
import com.dong.dongapiclientsdk.model.response.LoveResponse;
import com.dong.dongapiclientsdk.model.response.ResultResponse;
import com.dong.dongapiclientsdk.service.ApiService;
import com.dong.dongapiclientsdk.service.BaseService;

public class ApiServiceImpl extends BaseService implements ApiService {

    @Override
    public LoveResponse randomLoveTalk() throws ApiException {
        LoveRequest loveRequest = new LoveRequest();
        return request(loveRequest);
    }

    @Override
    public LoveResponse randomLoveTalk(DongApiClient dongApiClient) throws ApiException {
        LoveRequest loveRequest = new LoveRequest();
        return request(dongApiClient,loveRequest);
    }

    @Override
    public ResultResponse dyResponse(DyRequest dyRequest) throws ApiException {
        return request(dyRequest);
    }

    @Override
    public ResultResponse dyResponse(DongApiClient dongApiClient,DyRequest dyRequest) throws ApiException {
        return request(dongApiClient,dyRequest);
    }

    @Override
    public ResultResponse wyyMusicResponse(WyyMusicRequest wyyMusicRequest) throws ApiException {
        return request(wyyMusicRequest);
    }

    @Override
    public ResultResponse wyyMusicResponse(DongApiClient dongApiClient,WyyMusicRequest wyyMusicRequest) throws ApiException {
        return request(dongApiClient,wyyMusicRequest);
    }

    @Override
    public ResultResponse bddjResponse(BddjRequest bddjRequest) throws ApiException {
        return request(bddjRequest);
    }

    @Override
    public ResultResponse bddjResponse(DongApiClient dongApiClient,BddjRequest bddjRequest) throws ApiException {
        return request(dongApiClient,bddjRequest);
  }

    @Override 
    public ResultResponse avatarResponse(AvatarRequest avatarRequest) throws ApiException {
        return request(avatarRequest);
    }

    @Override
    public ResultResponse avatarResponse(DongApiClient dongApiClient,AvatarRequest avatarRequest) throws ApiException {
        return request(dongApiClient,avatarRequest);
    }

    @Override
    public ResultResponse  weatherResponse(WeatherRequest weatherRequest) throws ApiException {
        return request(weatherRequest);
    }

    @Override
    public ResultResponse  weatherResponse(DongApiClient dongApiClient,WeatherRequest weatherRequest) throws ApiException {
        return request(dongApiClient,weatherRequest);
    }

    @Override
    public ResultResponse getRandomWall(RandomWallpaperRequest request) throws ApiException {
        return request(request);
    }
}
