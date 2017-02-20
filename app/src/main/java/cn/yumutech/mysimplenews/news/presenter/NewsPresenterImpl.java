package cn.yumutech.mysimplenews.news.presenter;

import java.util.List;

import cn.yumutech.mysimplenews.beans.NewsBean;
import cn.yumutech.mysimplenews.commons.Urls;
import cn.yumutech.mysimplenews.news.model.NewsModel;
import cn.yumutech.mysimplenews.news.model.OnLoadNewsListListener;
import cn.yumutech.mysimplenews.news.model.NewsModelImpl;
import cn.yumutech.mysimplenews.news.view.NewsView;
import cn.yumutech.mysimplenews.news.widget.NewsFragment;
import cn.yumutech.mysimplenews.utils.LogUtils;

/**
 * Created by 小豪 on 2017/2/9.
 */

public class NewsPresenterImpl implements NewsPresenter,OnLoadNewsListListener {

    private static final String TAG = "NewsPresenterImpl";

    private NewsView mNewsView;
    private NewsModel mNewsModel;

    public NewsPresenterImpl(NewsView newsView){
        this.mNewsView = newsView;
        this.mNewsModel = new NewsModelImpl();
    }
    @Override
    public void loadNews(int type, int pageIndex) {
        String url = getUrl(type,pageIndex);
        LogUtils.d(TAG,url);
        //只有第一页或者刷新的时候才显示进度条
        if(pageIndex == 0){
            mNewsView.showProgress();
        }
        mNewsModel.loadNews(url,type,this);
    }

    private String getUrl(int type, int pageIndex) {
        StringBuffer sb = new StringBuffer();
        switch (type){
            case NewsFragment.NEWS_TYPE_TOP:
                sb.append(Urls.TOP_URL).append(Urls.TOP_ID);
                break;
            case NewsFragment.NEWS_TYPE_NBA:
                sb.append(Urls.COMMON_URL).append(Urls.NBA_ID);
                break;
            case NewsFragment.NEWS_TYPE_CARS:
                sb.append(Urls.COMMON_URL).append(Urls.CAR_ID);
                break;
            case NewsFragment.NEWS_TYPE_JOKES:
                sb.append(Urls.COMMON_URL).append(Urls.JOKE_ID);
                break;
            default:
                sb.append(Urls.TOP_URL).append(Urls.TOP_ID);
                break;
        }
        sb.append("/").append(pageIndex).append(Urls.END_URL);
        return sb.toString();
    }

    @Override
    public void onSuccess(List<NewsBean> list) {
        mNewsView.hideProgress();
        mNewsView.addNews(list);
    }

    @Override
    public void onFailure(String tag, Exception e) {
        mNewsView.hideProgress();
        mNewsView.showLoadFailMsg();
    }
}
