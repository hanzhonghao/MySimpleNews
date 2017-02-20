package cn.yumutech.mysimplenews.images;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import cn.yumutech.mysimplenews.beans.ImageBean;
import cn.yumutech.mysimplenews.utils.JsonUtils;
import cn.yumutech.mysimplenews.utils.LogUtils;

/**
 * Created by 小豪 on 2017/2/20.
 */

public class ImageJsonUtils {
    private final static String TAG = "ImageJsonUtils";

    public static List<ImageBean> readJsonImageBeans(String res) {
        List<ImageBean> beans = new ArrayList<>();
        try {
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(res).getAsJsonArray();
            for (int i = 1; i < jsonArray.size(); i++) {
                JsonObject jo = jsonArray.get(i).getAsJsonObject();
                ImageBean news = JsonUtils.deserialize(jo, ImageBean.class);
                beans.add(news);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "readJsonImageBeans error", e);
        }
        return beans;
    }
}
