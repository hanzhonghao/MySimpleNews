package cn.yumutech.mysimplenews.images.view;

import java.util.List;

import cn.yumutech.mysimplenews.beans.ImageBean;

/**
 * Created by 小豪 on 2017/2/20.
 */

public interface ImageView {
    void addImages(List<ImageBean> list);
    void showProgress();
    void hideProgress();
    void showLoadFailMsg();
}
