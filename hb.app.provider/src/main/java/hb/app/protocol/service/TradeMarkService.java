package hb.app.protocol.service;

import hb.app.protocol.model.entity.TmCategory;
import hb.app.protocol.model.entity.TradeMark;

import java.util.List;

/**
 * Created by gabry on 2017/8/21.
 */
public interface TradeMarkService {

    /**
     * 根据商标名和商品名获取商标注册情况
     *
     * @param tmName    商标名
     * @param goodsName 商品名
     * @return 商标注册情况
     */
    TradeMark getByTmNameAndGoodsName(String tmName, String goodsName);

    /**
     * 根据商标名和商品名获取未注册相关分类,获取一个分类树
     * @param tmName
     * @param goodsName
     * @return
     */
    Object getAllByTmNameAndGoodsName(String tmName, String goodsName);

    /**
     * 根据行业(以及商标分类名)获取4个推荐商标名
     * @param tmName
     * @return
     */
    List<Object> getTmnameByIndustry(String tmName);

    /**
     * 根据一级分类和取得商标名获得未注册商标的二级分类和三级分类
     * @param tmName
     * @param brandName
     * @return
     */
    List<Object> getCategoryByTmnameAndBrandname(String tmName,String brandName);

    /**
     * 商场：获取已注册可交易商标的列表
     * @return
     */
    List<Object> getRegisterTradeMarks();

    /**
     * 获取所有的商标
     * @return
     */
    List<TradeMark> getAllTradeMarks();

    /**
     * 根据一级分类category和商标名和商品名获取=未注册相关分类+已注册分类+相关一级分类
     * @param category
     * @param tmName
     * @param goodsName
     * @return
     */
    List<Object> getByCategory(TmCategory category, String tmName, String goodsName);
}
