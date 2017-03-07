package cn.yumutech.mysimplenews.weather.model;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import cn.yumutech.mysimplenews.beans.WeatherBean;
import cn.yumutech.mysimplenews.commons.Urls;
import cn.yumutech.mysimplenews.utils.LogUtils;
import cn.yumutech.mysimplenews.utils.OkHttpUtils;
import cn.yumutech.mysimplenews.weather.WeatherJsonUtils;

/**
 * Created by 小豪 on 2017/2/21.
 */

public class WeatherModelImpl implements WeatherModel {

    private static final String TAG = "WeatherModelImpl";

    @Override
    public void loadWeatherData(String cityName, final LoadWeatherListener listener) {
        try {
            String url = Urls.WEATHER + URLEncoder.encode(cityName, "utf-8");
            OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
                @Override
                public void onSuccess(String response) {
                    List<WeatherBean> lists = WeatherJsonUtils.getWeatherInfo(response);
                    listener.onSuccess(lists);
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure("load weather data failure.", e);
                }
            };
            OkHttpUtils.get(url,callback);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LogUtils.e(TAG, "url encode error.", e);
        }
    }
    @Override
    public void loadLocation(Context context, final LoadLocationListener listener) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                LogUtils.e(TAG, "location failure1.");
                listener.onFailure("location failure.", null);
                return;
            }
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        LogUtils.e(TAG, "location :"+location);
        if(location == null) {
            LogUtils.e(TAG, "location failure2.");
            listener.onFailure("location failure.", null);
            return;
        }
//        double latitude = location.getLatitude();     //经度
//        double longitude = location.getLongitude(); //纬度

        double latitude = 104.30214000000001;     //经度
        double longitude = 30.60949;
        System.out.println("======================latitude :"+latitude+"longitude:"+longitude );
        String url = getLocationURL(latitude, longitude);
        OkHttpUtils.ResultCallback<String> callback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                String city = WeatherJsonUtils.getCity(response);
                if(TextUtils.isEmpty(city)) {
                    LogUtils.e(TAG, "load location info failure.");
                    listener.onFailure("load location info failure.", null);
                } else {
                    listener.onSuccess(city);
                }
            }

            @Override
            public void onFailure(Exception e) {
                LogUtils.e(TAG, "load location info failure.", e);
                listener.onFailure("load location info failure.", e);
            }
        };
        OkHttpUtils.get(url, callback);
    }

    private String getLocationURL(double latitude, double longitude) {
        StringBuffer sb = new StringBuffer(Urls.INTERFACE_LOCATION);
        sb.append("?ak=AmPUmmyd48S0WIl9889YPb4hSCePCB4i").append("&mcode=11:FE:9B:D1:04:1C:C4:6A:8F:49:8E:CF:BA:4D:AA:E7:67:2C:BB:B4;cn.yumutech.mysimplenews")
                .append("&callback=renderReverse");
        sb.append("&location=").append(latitude).append(",").append(longitude).append("&output=json&pois=1");
        LogUtils.d(TAG, sb.toString());
        return sb.toString();
    }


    public interface LoadWeatherListener {
        void onSuccess(List<WeatherBean> list);

        void onFailure(String msg, Exception e);
    }

    public interface LoadLocationListener {
        void onSuccess(String cityName);

        void onFailure(String msg, Exception e);
    }
}
