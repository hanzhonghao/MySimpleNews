package cn.yumutech.mysimplenews.news.model;

/**
 * Created by 小豪 on 2017/2/9.
 */

public interface NewsModel {
    void loadNews(String url,int type,OnLoadNewsListListener listener);

    void loadNewsDetail(String docid, OnLoadNewsDetailListener listener);
}
