package cn.yumutech.mysimplenews.commons;

/**
 * Created by 小豪 on 2017/2/9.
 */

public class Urls {

    public static final int PAGE_SIZE = 20;

    public static final String HOST = "http://c.m.163.com/";

    public static final String END_URL = "-" + PAGE_SIZE + ".html";

    public static final String END_DETAIL_URL = "/full.html";

    // 头条
    public static final String TOP_URL = HOST + "nc/article/headline/";
    public static final String TOP_ID = "T1348647909107";
    // 新闻详情
    //"http://c.m.163.com/nc/article/full.html
    public static final String NEW_DETAIL = HOST + "nc/article/";

    public static final String COMMON_URL = HOST + "nc/article/list/";

    // 汽车
    public static final String CAR_ID = "T1348654060988";
    // 笑话
    public static final String JOKE_ID = "T1350383429665";
    // nba
    public static final String NBA_ID = "T1348649145984";

    // 图片
    public static final String IMAGES_URL = "http://api.laifudao.com/open/tupian.json";

    // 天气预报url
    public static final String WEATHER = "http://wthrcdn.etouch.cn/weather_mini?city=";

    //百度定位
    public static final String INTERFACE_LOCATION = "http://api.map.baidu.com/geocoder/v2/";
    //http://api.map.baidu.com/geocoder?output=json&referer=32D45CBEEC107315C553AD1131915D366EEF79B4&location=103，80

    //ak:AmPUmmyd48S0WIl9889YPb4hSCePCB4i

    //http://api.map.baidu.com/geocoder/v2/?ak=AmPUmmyd48S0WIl9889YPb4hSCePCB4i&mcode=11:FE:9B:D1:04:1C:C4:6A:8F:49:8E:CF:BA:4D:AA:E7:67:2C:BB:B4;cn.yumutech.mysimplenews&callback=renderReverse&location=28.696117,115.958458&output=json&pois=1
}
