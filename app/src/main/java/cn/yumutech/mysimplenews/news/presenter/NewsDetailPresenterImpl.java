package cn.yumutech.mysimplenews.news.presenter;

import android.content.Context;

import cn.yumutech.mysimplenews.beans.NewsDetailBean;
import cn.yumutech.mysimplenews.news.model.NewsModel;
import cn.yumutech.mysimplenews.news.model.NewsModelImpl;
import cn.yumutech.mysimplenews.news.model.OnLoadNewsDetailListener;
import cn.yumutech.mysimplenews.news.view.NewsDetailView;

/**
 * Created by 小豪 on 2017/2/20.
 */

public class NewsDetailPresenterImpl implements NewsDetailPresenter ,OnLoadNewsDetailListener{

    private Context mContent;
    private NewsDetailView mNewsDetailView;
    private NewsModel mNewsModel;

    public NewsDetailPresenterImpl(Context context, NewsDetailView mNewsDetailView){
        this.mContent = context;
        this.mNewsDetailView = mNewsDetailView;
        mNewsModel = new NewsModelImpl();
    }
    @Override
    public void loadNewsDetail(String docId) {
        mNewsDetailView.showProgress();
        mNewsModel.loadNewsDetail(docId,this);
    }

    @Override
    public void onSuccess(NewsDetailBean newsDetailBean) {
        if (newsDetailBean != null) {
            mNewsDetailView.showNewsDetialContent(newsDetailBean.getBody());
        }
        mNewsDetailView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mNewsDetailView.hideProgress();
    }
}
