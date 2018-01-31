package hb.app.protocol.service;

import hb.app.protocol.model.entity.TradeMark;

import java.util.List;

/**
 * 商标查询
 */
public interface TmSearchService {
    public class Result<T> {
        public int ret;
        public String msg;
        public long allRecords;
        public List<T> results;
        public List<String> facets;
    }

    /**
     * 给定关键字，查询商标名/注册号/申请人中含有该关键字的商标列表
     * @param keywords
     * @return
     */
    Result<TradeMark> tmListByKeywords(String keywords);

    /**
     * 根据商标名查询
     * @param name
     * @return
     */
    Result<TradeMark> tmListByName(String name);

    /**
     * 根据注册号查询
     * @param regNo
     * @return
     */
    Result<TradeMark> tmListByRegNo(String regNo);

    /**
     * 根据申请人查询
     * @param owner
     * @return
     */
    Result<TradeMark> tmListByOwner(String owner);

}


