package cn.yumutech.mysimplenews.news.view;

import java.util.List;

import cn.yumutech.mysimplenews.beans.NewsBean;

/**
 * Created by 小豪 on 2017/2/9.
 */

public interface NewsView {
    void showProgress();

    void addNews(List<NewsBean> newsList);

    void hideProgress();

    void showLoadFailMsg();
}
