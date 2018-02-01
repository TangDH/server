package op.app.api.controllers.app;

import op.app.api.controllers.common.BaseController;
import op.app.protocol.service.TradeMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabry on 2017/7/13.
 */
@RequestMapping("/tradeMark")
@RestController
public class TradeMarkController extends BaseController {

    @Autowired
    private TradeMarkService tradeMarkService;

    /**
     * 根据商标名和商品名获取未注册相关分类,获取一个分类树
     * @param tmName
     * @param goodsName
     * @return
     */
    @RequestMapping("/getRecommendTradeMark")
    public Object getRecommendTradeMark(@RequestParam String tmName,@RequestParam String goodsName) {
        Object result =tradeMarkService.getAllByTmNameAndGoodsName(tmName,goodsName);
        return result;
    }

    /**
     * 根据行业(以及商标分类名)获取4个推荐商标名
     * @param tmName
     * @return
     */
    @RequestMapping("/getTradeMarkByIndustry")
    public Object getTradeMarkByIndustry(@RequestParam String tmName) {
        Object result =tradeMarkService.getTmnameByIndustry(tmName);
        return result;
    }

    /**
     * 根据一级分类和取得商标名获得未注册商标的二级分类和三级分类
     * @param tmName
     * @param brandName
     * @return
     */
    @RequestMapping("/etCategoryByTmnameAndBrandname")
    public Object getTradeMarkByIndustry(@RequestParam String tmName,@RequestParam String brandName) {
        Object result =tradeMarkService.getCategoryByTmnameAndBrandname(tmName,brandName);
        return result;
    }


    /**
     * 获取所有的商标
     * @return
     */
    @RequestMapping("/getAllTradeMark")
    public Object getAllTradeMark() {
        Object result =tradeMarkService.getAllTradeMarks();
        return result;
    }
}
