package op.app.provider.service;

import op.app.protocol.model.entity.TmCategory;
import op.app.protocol.model.entity.GoodsCategory;
import op.app.protocol.model.entity.TradeMark;
import op.app.protocol.model.entity.TradeMarkGoods;
import op.app.protocol.service.TradeMarkService;
import op.app.provider.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gabry on 2017/7/21.
 */
@Service
public class TradeMarkServiceImpl implements TradeMarkService {

    @Autowired
    private TradeMarkRepository tradeMarkRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GoodsCategoryRepository goodsCategoryRepository;
    @Autowired
    private TradeMarkGoodsRepository tradeMarkGoodsRepository;
    @Autowired
    private GoodsSaleDayRepository goodsSaleDayRepository;
    @Autowired
    private  TradeMarkStatusRepository tradeMarkStatusRepository;

    //根据商标名和商品名获取商标情况
    @Override
    public TradeMark getByTmNameAndGoodsName(String tmName, String goodsName) {

        return null;
    }


    //根据商标名和商品名获取=未注册相关分类+已注册分类+相关一级分类
    @Override
    public List<Object> getAllByTmNameAndGoodsName(String tmName, String goodsName) {
        //获取未注册相关分类
        //根据商品名找到数据库记录
    GoodsCategory goodsCategory=goodsCategoryRepository.findFirstByName(goodsName);
    List<TradeMarkGoods> tradeMarkGoods= tradeMarkGoodsRepository.findAllByGoodsCategoryId(goodsCategory.getId());
    //找到商品名对应的id集合，ids：商品分类所对应的三级分类+二级分类+一级分类 ,ids1:商品分类对应的二级分类
        Set<Long> ids=new HashSet<>();
        Set<Long> ids0=new HashSet<>();
    tradeMarkGoods.forEach(tradeMarkGoods1 -> ids.add(tradeMarkGoods1.categoryId));
    //添加进二级分类和一级分类
      ArrayList<TmCategory> categories01= (ArrayList<TmCategory>) categoryRepository.findAll(ids);
      categories01.forEach(c->ids0.add(c.parentId));
      ArrayList<TmCategory> categories02= (ArrayList<TmCategory>) categoryRepository.findAll(ids0);
      categories02.forEach(c->ids.add(c.parentId));
      ids.addAll(ids0);
     //找到商标分类的一级目录，根据要求，获取列表中的第一个数据
     TmCategory category=categoryRepository.findFirstByLevelAndIdIn(1,ids);
        //调用本类中的getByCategory方法
        return this.getByCategory(category,tmName,goodsName);
        }


    //根据行业(45个一级分类)获取4个推荐商标名
    @Override
    public List<Object> getTmnameByIndustry(String tmName) {
        //categoryRepository.findAllByNameLikeAndLevelAndIndustry("%"+goodsName+"%",1,industry);
        List<Object> table =new ArrayList<>();
        List<Object> table1 =new ArrayList<>();
        ArrayList<Object> tableTop=new ArrayList<>();
        ArrayList<Object> tableLeft=new ArrayList<>();
        ArrayList<Object> tableRight=new ArrayList<>();
        ArrayList<Object> tableBottom=new ArrayList<>();
        String []titles=new String[]{"海飞丝","沙宣","潘婷","多芬"};
        String species=tmName;
        String [] provenances =new String[]{"海飞丝是对一种精神的统称，海飞丝的寂寞，龙破上果照用海飞丝瓶子挡住了下面...",
                "作为一个享誉国际的发型设计大师，维达·沙宣既是潮流革新者、艺术家、教育家、企业家，也是倍受赞赏的作者、节目主持人和慈善家。",
                "作为一个享誉国际的发型设计大师，维达·沙宣既是潮流革新者、艺术家、教育家、企业家，也是倍受赞赏的作者、节目主持人和慈善家。",
                "海飞丝是对一种精神的统称，海飞丝的寂寞，龙破上果照用海飞丝瓶子挡住了下面..."};
        String []data = new String[]{"9月4日", "9月5日", "9月6日", "9月7日", "9月8日", "9月9日", "9月10日"};
        String []labels = new String[]{"73", "20", "12", "60", "23", "45", "34"};
        for (int i=0;i>4;i++){
            List<Object> arrayList=new ArrayList<>();
            arrayList.add(titles[i]);
            arrayList.add(species);
            arrayList.add(provenances[i]);
            arrayList.add(data);
            arrayList.add(labels);
            table1.add(arrayList);
        }
        tableTop= (ArrayList<Object>) table1.get(0);
        tableLeft= (ArrayList<Object>) table1.get(1);
        tableRight= (ArrayList<Object>) table1.get(2);
        tableBottom= (ArrayList<Object>) table1.get(3);
        table.add(tableTop);
        table.add(tableLeft);
        table.add(tableRight);
        table.add(tableBottom);


        return table;
    }

    /**
     * 根据一级分类和取得商标名获得未注册商标的二级分类和三级分类
     * @param tmName
     * @param brandName
     * @return
     */
    @Override
    public List<Object> getCategoryByTmnameAndBrandname(String tmName, String brandName) {
        List<Object> objects=new ArrayList<>();
        //添加商标一级分类
        String category0=tmName;
        String brandName0=brandName;
        String[] _req={category0,brandName0};
        objects.add(_req);

        TmCategory category= categoryRepository.findFirstByName(tmName);
        Set<Long> ids=new HashSet<>();
        //找到一级目录下的二级目录
        ArrayList<TmCategory> categories= (ArrayList<TmCategory>) categoryRepository.findAllByParentId(category.getId());
        categories.forEach(c->ids.add(c.getId()));
        ArrayList<TmCategory> categories5= (ArrayList<TmCategory>) categoryRepository.findAllByParentIdIn(ids);
        categories5.forEach(c->ids.add(c.getId()));
        //三级分类
        Set<Long> cids=new HashSet<>();
        //已被注册的二级分类
        Set<Long> cids1=new HashSet<>();
        //找到三级分类被注册完的二级分类，cids：商标注册的商标三级分类id
        //List<TradeMark> tradeMarks=tradeMarkRepository.findAllByName(brandName);
        //tradeMarks.forEach(tradeMark -> cids.addAll(tradeMark.categoryIds));
        //已被注册的商标的二级分类
        ArrayList<TmCategory> categories4= (ArrayList<TmCategory>)categoryRepository.findAll(cids);
        categories4.forEach(category1 -> cids1.add(category1.parentId));
        ArrayList<TmCategory> categories1=   (ArrayList<TmCategory>) categoryRepository.findAllByParentIdAndIdIn(category.getId(),cids1);
        for (TmCategory c:categories1) {
            //查找是否有二级分类的三级分类是否有完全注册的，完全注册的除去
            ArrayList<TmCategory> categories2= (ArrayList<TmCategory>) categoryRepository.findAllByParentIdAndIdIn(c.getId(),cids);
            ArrayList<TmCategory> categories3= (ArrayList<TmCategory>) categoryRepository.findAllByParentId(c.parentId);
            //如果集合相同，则进行操作
            if (!categories2.retainAll(categories3)){
                ids.removeAll(cids);
                ids.remove(c.getId());
                categories.remove(c);
            }
           /* Iterator<Category> categories2= categoryRepository.findAllByParentIdAndIdIn(c.getId(),cids).iterator();
            ArrayList<Long> ids1=null;
            categories2.forEachRemaining(category1 ->ids1.add(category1.getId()) );
            Iterator<Category> categories3= categoryRepository.findAllByParentId(c.parentId).iterator();
            ArrayList<Long> ids2=null;
            categories3.forEachRemaining(category2 ->ids2.add(category2.getId()) );
            Long[] ids11= (Long[]) ids1.toArray();
            Arrays.sort(ids11);
            Long[] ids22= (Long[]) ids2.toArray();
            Arrays.sort(ids22);
            if (Arrays.equals(ids11,ids22)) {
                //完全被注册，则除去此二级分类
                ids.removeAll(cids);
                ids.remove(c.getId());
                categories.remove(c);
            }*/
        }
        //添加到树形结构里,封装起来
        List<Object> objects0=new ArrayList<>();
        for (TmCategory c1:categories) {
            ArrayList<TmCategory> categoryArrayList= (ArrayList<TmCategory>) categoryRepository.findAllByParentIdAndIdIn(c1.getId(),ids);
            ArrayList<Object> data=null;
            //在商标分类名前添加分类代码
            String title=c1.code+"-"+c1.name;
            ArrayList<String> contain=null;
            categoryArrayList.forEach(category1 -> contain.add(category1.code+"-"+category1.name));
            data.add(title);
            data.add(contain);
            objects0.add(data);
        }
        objects.add(objects0);

        return objects;
    }

    /**
     * 获取已注册的商标，包括商标信息+申请的详细进程+估值信息
     * @return
     */
    @Override
    public List<Object> getRegisterTradeMarks() {
        List<Object> objects=new ArrayList<>();
         List<TradeMark> tradeMarks=null;//tradeMarkRepository.findAllByCurrentStatus(CurrentStatus.RegisterSuccess);
        for (TradeMark t:tradeMarks) {
            List<Object> objects1=new ArrayList<>();
            objects1.add(t);
            //objects1.add(tradeMarkStatusRepository.findAll(t.tradeMarkStatusIds));
            //当前价
            String currentprice="￥200000";
            //涨跌幅
            String range="+0.5%";
            //关注指数
            int focusindex=92786;
            objects1.add(currentprice);
            objects1.add(range);
            objects1.add(focusindex);
            objects.add(objects1);
        }

        return objects;
    }


    // 获取所有商标状态
    @Override
    public List<TradeMark> getAllTradeMarks() {

        return (List<TradeMark>) tradeMarkRepository.findAll();
    }


    /**
     * 根据一级分类category和商标名和商品名获取=未注册相关分类+已注册分类+相关一级分类
     * @param category
     * @param tmName
     * @param goodsName
     * @return
     */
    @Override
    public List<Object> getByCategory(TmCategory category, String tmName, String goodsName) {
        //获取未注册相关分类
        //根据商品名找到数据库记录
        List<Object> objects=new ArrayList<>();
        GoodsCategory goodsCategory=goodsCategoryRepository.findFirstByName(goodsName);
        List<TradeMarkGoods> tradeMarkGoods= tradeMarkGoodsRepository.findAllByGoodsCategoryId(goodsCategory.getId());
        //找到商品名对应的id集合，ids：商品分类所对应的三级分类+二级分类+一级分类 ,ids1:商品分类对应的二级分类
        Set<Long> ids=new HashSet<>();
        Set<Long> ids0=new HashSet<>();
        tradeMarkGoods.forEach(tradeMarkGoods1 -> ids.add(tradeMarkGoods1.categoryId));
        //添加进二级分类和一级分类
        ArrayList<TmCategory> categories01= (ArrayList<TmCategory>) categoryRepository.findAll(ids);
        categories01.forEach(c->ids0.add(c.parentId));
        ArrayList<TmCategory> categories02= (ArrayList<TmCategory>) categoryRepository.findAll(ids0);
        categories02.forEach(c->ids.add(c.parentId));
        ids.addAll(ids0);
        //找到一级目录下的二级目录
        ArrayList<TmCategory> categories= (ArrayList<TmCategory>) categoryRepository.findAllByParentIdAndIdIn(category.getId(),ids);

        //找到三级分类被注册完的二级分类，cids：商标注册的商标三级分类id
        Set<Long> cids=new HashSet<>();
        //已被注册的二级分类
        Set<Long> cids1=new HashSet<>();
        List<TradeMark> tradeMarks=null;//tradeMarkRepository.findAllByName(tmName);
        //tradeMarks.forEach(tradeMark -> cids.addAll(tradeMark.categoryIds));
        //已被注册的商标的二级分类
        ArrayList<TmCategory> categories4= (ArrayList<TmCategory>)categoryRepository.findAll(cids);
        categories4.forEach(category1 -> cids1.add(category1.parentId));
        ArrayList<TmCategory> categories1= (ArrayList<TmCategory>) categoryRepository.findAll(cids1);
        for (TmCategory c:categories1) {
            //查找是否有二级分类的三级分类是否有完全注册的，完全注册的除去
            ArrayList<TmCategory> categories2= (ArrayList<TmCategory>) categoryRepository.findAllByParentIdAndIdIn(c.getId(),cids);
            ArrayList<TmCategory> categories3= (ArrayList<TmCategory>) categoryRepository.findAllByParentId(c.parentId);
            //如果集合相同，则进行操作
            if (!categories2.retainAll(categories3)){
                ids.removeAll(cids);
                ids.remove(c.getId());
                categories.remove(c);
            }
          /*  Iterator<Category> categories2= categoryRepository.findAllByParentIdAndIdIn(c.getId(),cids).iterator();
            ArrayList<Long> ids1=null;
            categories2.forEachRemaining(category1 ->ids1.add(category1.getId()) );
            Iterator<Category> categories3= categoryRepository.findAllByParentId(c.parentId).iterator();
            ArrayList<Long> ids2=null;
            categories3.forEachRemaining(category2 ->ids2.add(category2.getId()) );
            Long[] ids11= (Long[]) ids1.toArray();
            Arrays.sort(ids11);
            Long[] ids22= (Long[]) ids2.toArray();
            Arrays.sort(ids22);
            if (Arrays.equals(ids11,ids22)) {
                //完全被注册，则除去此二级分类
                ids.removeAll(cids);
                ids.remove(c.getId());
                categories.remove(c);
            }*/
        }
        //未注册商标：添加到树形结构里,封装起来
        for (TmCategory c1:categories) {
            ArrayList<TmCategory> categoryArrayList= (ArrayList<TmCategory>) categoryRepository.findAllByParentIdAndIdIn(c1.getId(),ids);
            ArrayList<Object> unregisteredNumberArray=null;
            String title=c1.code;
            //传一个对象过去，在注册时得失用到
            ArrayList<TmCategory> contain=null;
            unregisteredNumberArray.add(title);
            unregisteredNumberArray.add(contain);
            unregisteredNumberArray.add(categoryArrayList);
            objects.add(unregisteredNumberArray);
        }

        //已注册分类：处理已注册商标
        List<Object> objects2=new ArrayList<>();
        List<TmCategory> categories5=categoryRepository.findAllByParentId(category.getId());
        //tid:一级商标分类下的全部二级分类id
        Set<Long> tid=new HashSet<>();
        categories5.forEach(category1 ->tid.add(category1.getId()) );
        List<TmCategory> categories6=categoryRepository.findAllByParentIdIn(tid);
        //位于第一级分类下的所有商标三级分类
        Set<Long> tid1=new HashSet<>();
        categories6.forEach(category1 ->tid1.add(category1.getId()) );
        //不是位于一级分类下，则删除
        //添加到树形结构里
        cids.removeIf(els->!(tid1.contains(els)));
        for (TradeMark t:tradeMarks) {
            //t.categoryIds.removeIf(els->!(cids.contains(els)));
        }
        List<Object> objects0=new ArrayList<>();
        for (TradeMark t:tradeMarks) {
            ArrayList<Object> alreadyArr=null;
            ArrayList<String> contain=null;
            String title=t.tmName;
            String link=t.tmImg;
            String category2=category.name;
            //ArrayList<Category> categories7= (ArrayList<Category>) categoryRepository.findAll(t.categoryIds);
            //categories7.forEach(category1 -> contain.add(category1.name));
            alreadyArr.add(title);
            alreadyArr.add(link);
            alreadyArr.add(category2);
            alreadyArr.add(contain);
            objects0.add(alreadyArr);
        }
        objects.add(objects0);
        //返回所有查询的相关一级分类
        List<TmCategory> categories8=categoryRepository.findAllByLevelAndIdIn(1,ids);
        ArrayList<Object> relevantClassificationData=null;
        categories8.forEach(c->relevantClassificationData.add(c.name));
        objects.add(relevantClassificationData);

        //返回商品搜索热图,多个同名商标对应一个商标热度图，返回一个object对象
        //GoodsSaleDay goodsSaleDay=goodsSaleDayRepository.findOne(tradeMarks.get(0).goodsSaleDayId);
        //Object canvas=new GoodsSaleDay(goodsSaleDay.Date,goodsSaleDay.count);
        //objects.add(canvas);

        //打包成树形结构
        return objects;
    }


}