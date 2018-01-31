package hb.app.api.controllers.app;

import hb.app.api.controllers.common.BaseController;
import hb.app.protocol.model.entity.TradeMark;
import hb.app.protocol.service.TmSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/search")
@RestController
public class TmSearchConroller extends BaseController {

    @Autowired
    private TmSearchService tmSearchService;

    @RequestMapping("/all/{keywords}")
    public Object all(@PathVariable String keywords,@RequestParam String tmName) {
        TmSearchService.Result<TradeMark> serviceResult = tmSearchService.tmListByKeywords(keywords);
        Object result = serviceResult;
        return result;
    }

    @RequestMapping("/name/{keywords}")
    public Object name(@PathVariable String keywords) {
        TmSearchService.Result<TradeMark> serviceResult = tmSearchService.tmListByName(keywords);
        Object result = serviceResult;
        return result;
    }

    @RequestMapping("/owner/{keywords}")
    public Object owner(@PathVariable String keywords) {
        TmSearchService.Result<TradeMark> serviceResult = tmSearchService.tmListByOwner(keywords);
        Object result = serviceResult;
        return result;
    }

    @RequestMapping("/regno/{keywords}")
    public Object regNo(@PathVariable String keywords) {
        TmSearchService.Result<TradeMark> serviceResult = tmSearchService.tmListByRegNo(keywords);
        Object result = serviceResult;
        return result;
    }


}
