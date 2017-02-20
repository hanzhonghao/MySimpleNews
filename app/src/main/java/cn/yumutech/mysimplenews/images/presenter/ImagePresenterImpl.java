package cn.yumutech.mysimplenews.images.presenter;


import java.util.List;

import cn.yumutech.mysimplenews.beans.ImageBean;
import cn.yumutech.mysimplenews.images.model.ImageModel;
import cn.yumutech.mysimplenews.images.model.ImageModelImpl;
import cn.yumutech.mysimplenews.images.view.ImageView;

/**
 * Created by 小豪 on 2017/2/20.
 */

public class ImagePresenterImpl implements ImagePresenter, ImageModelImpl.OnLoadImageListListener {

    private ImageView mImageView;
    private ImageModel mImageModel;

    public ImagePresenterImpl(ImageView imageView) {
        this.mImageView = imageView;
        mImageModel = new ImageModelImpl();
    }

    @Override
    public void loadImageList() {
        mImageView.showProgress();
        mImageModel.loadImageList(this);

    }

    @Override
    public void onSuccess(List<ImageBean> list) {
        mImageView.addImages(list);
        mImageView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mImageView.hideProgress();
        mImageView.showLoadFailMsg();
    }


}
