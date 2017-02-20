package cn.yumutech.mysimplenews.news.model;

import java.util.List;

import cn.yumutech.mysimplenews.beans.NewsBean;

/**
 * Description : 新闻列表加载回调
 * Created by 小豪 on 2017/2/9.
 */

public interface OnLoadNewsListListener {
    void onSuccess(List<NewsBean> list);

    void onFailure(String tag,Exception e);
}
