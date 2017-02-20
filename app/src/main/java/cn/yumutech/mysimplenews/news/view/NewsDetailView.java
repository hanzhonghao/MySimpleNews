package cn.yumutech.mysimplenews.news.view;

/**
 * Created by 小豪 on 2017/2/16.
 */

public interface NewsDetailView {
    void showNewsDetialContent(String newsDetailContent);

    void showProgress();

    void hideProgress();
}
