package cn.yumutech.mysimplenews.news.model;

import java.util.List;

import cn.yumutech.mysimplenews.beans.NewsBean;
import cn.yumutech.mysimplenews.beans.NewsDetailBean;
import cn.yumutech.mysimplenews.commons.Urls;
import cn.yumutech.mysimplenews.news.NewsJsonUtils;
import cn.yumutech.mysimplenews.news.widget.NewsFragment;
import cn.yumutech.mysimplenews.utils.LogUtils;
import cn.yumutech.mysimplenews.utils.OkHttpUtils;

/**
 * Description: 新闻业务处理类
 * Created by 小豪 on 2017/2/9.
 */

public class NewsModelImpl implements NewsModel {

    /**
     * 加载新闻列表
     * @param url
     * @param listener
     */
    @Override
    public void loadNews(String url, final int type, final OnLoadNewsListListener listener) {
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<NewsBean> newsBeanList = NewsJsonUtils.readJsonNewsBeans(response, getID(type));
                listener.onSuccess(newsBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load news list failure.", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }


    /**
     * 加载新闻详情
     * @param docid
     * @param listener
     */
    @Override
    public void loadNewsDetail(final String docid, final OnLoadNewsDetailListener listener) {
        String url = getDetailUrl(docid);
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>(){

            @Override
            public void onSuccess(String response) {
                NewsDetailBean newsDetailBean = NewsJsonUtils.readJsonNewsDetailBeans(response, docid);
                listener.onSuccess(newsDetailBean);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load news detail info failure.", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    private String getDetailUrl(String docid) {
        StringBuffer sb = new StringBuffer(Urls.NEW_DETAIL);
        sb.append(docid).append(Urls.END_DETAIL_URL);
        LogUtils.d("Test++++++++++++++++++++++++++++++++++++",sb.toString());
        return sb.toString();
    }


    /**
     * 获取ID
     * @param type
     * @return
     */
    private String getID(int type) {
        String id;
        switch (type) {
            case NewsFragment.NEWS_TYPE_TOP:
                id = Urls.TOP_ID;
                break;
            case NewsFragment.NEWS_TYPE_NBA:
                id = Urls.NBA_ID;
                break;
            case NewsFragment.NEWS_TYPE_CARS:
                id = Urls.CAR_ID;
                break;
            case NewsFragment.NEWS_TYPE_JOKES:
                id = Urls.JOKE_ID;
                break;
            default:
                id = Urls.TOP_ID;
                break;
        }
        return id;
    }


}
