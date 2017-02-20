package cn.yumutech.mysimplenews.images.model;

import java.util.List;

import cn.yumutech.mysimplenews.beans.ImageBean;
import cn.yumutech.mysimplenews.commons.Urls;
import cn.yumutech.mysimplenews.images.ImageJsonUtils;
import cn.yumutech.mysimplenews.utils.OkHttpUtils;

/**
 * Created by 小豪 on 2017/2/20.
 */

public class ImageModelImpl implements ImageModel {


    @Override
    public void loadImageList(final OnLoadImageListListener listener) {
        String url = Urls.IMAGES_URL;
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<ImageBean> imageBeanList = ImageJsonUtils.readJsonImageBeans(response);
                listener.onSuccess(imageBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load image list failure.", e);
            }
        };
        OkHttpUtils.get(url,loadNewsCallback);
    }




    public interface  OnLoadImageListListener{
        void onSuccess(List<ImageBean> list);
        void onFailure(String msg,Exception e);
    }
}
