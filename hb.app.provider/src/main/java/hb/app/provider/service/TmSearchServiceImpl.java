package hb.app.provider.service;

import com.google.gson.Gson;
import hb.app.protocol.model.entity.TradeMark;
import hb.app.protocol.service.TmSearchService;
import hb.app.http.HttpClient;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class TmSearchServiceImpl implements TmSearchService {

    private static final String API_URL = "http://api.tmkoo.com/search.php?searchType=%s&keyword=%s&apiKey=4399320012393234&apiPassword=331nd3342d&pageSize=30&pageNo=1";

    public static void main(String[] args) throws Exception {

        TmSearchService search = new TmSearchServiceImpl();

        System.out.println("Testing 1 - Send Http GET request");
        Result<TradeMark> list = search.tmListByKeywords("海飞丝");

    }

    /**
     * 从网络中获取JSON字符串，然后解析
     *
     * @param json
     * @return
     */
    private Result<TradeMark> jsonParse(String json) {
        Gson gson = new Gson();
        Result<TradeMark> tmResult = gson.fromJson(json, Result.class);
        return tmResult;
    }

    private Result<TradeMark> getList(String url) {
        HttpClient http = new HttpClient();
        String jsonStr = null;
        try {
            jsonStr = http.sendGet(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonParse(jsonStr);
    }

    @Override
    public Result<TradeMark> tmListByKeywords(String keywords) {

        String url = null;
        try {
            url = String.format(API_URL, "4", URLEncoder.encode(keywords, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return getList(url);
    }

    @Override
    public Result<TradeMark> tmListByName(String name) {
        String url = null;
        try {
            url = String.format(API_URL, "1", URLEncoder.encode(name, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return getList(url);
    }

    @Override
    public Result<TradeMark> tmListByRegNo(String regNo) {
        String url = null;
        try {
            url = String.format(API_URL, "2", URLEncoder.encode(regNo, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return getList(url);
    }

    @Override
    public Result<TradeMark> tmListByOwner(String owner) {
        String url = null;
        try {
            url = String.format(API_URL, "3", URLEncoder.encode(owner, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return getList(url);
    }
}
