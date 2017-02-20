package cn.yumutech.mysimplenews.images.model;

/**
 * Created by 小豪 on 2017/2/20.
 */

public interface ImageModel {
    void loadImageList(ImageModelImpl.OnLoadImageListListener listener);
}
