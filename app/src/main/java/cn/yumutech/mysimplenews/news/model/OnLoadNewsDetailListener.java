package cn.yumutech.mysimplenews.news.model;

import cn.yumutech.mysimplenews.beans.NewsDetailBean;

/**
 * Created by 小豪 on 2017/2/20.
 */

public interface OnLoadNewsDetailListener {

    void onSuccess(NewsDetailBean newsDetailBean);

    void onFailure(String msg,Exception e);
}
