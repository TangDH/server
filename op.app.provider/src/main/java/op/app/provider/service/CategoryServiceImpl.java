package op.app.provider.service;

import op.app.protocol.model.entity.TmCategory;
import op.app.protocol.model.entity.GoodsCategory;
import op.app.protocol.model.entity.TradeMarkGoods;
import op.app.protocol.service.BizExeption;
import op.app.protocol.service.CategoryService;
import op.app.provider.repository.CategoryRepository;
import op.app.provider.repository.GoodsCategoryRepository;
import op.app.provider.repository.TradeMarkGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private GoodsCategoryRepository goodsCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TradeMarkGoodsRepository tradeMarkGoodsRepository;

    /**
     * 根据商品id和商标分类id值添加商品到商标种类
     *
     * @param cid
     * @param gid
     */
    @Override
    public void addGoodsToCategory(long cid, long gid) throws BizExeption {
        try {//判断数据库是否已存在对应关系（是否存在此记录）
            TradeMarkGoods tradeMarkGoods1 = tradeMarkGoodsRepository.findFirstByCategoryIdAndGoodsCategoryId(cid, gid);
            if (tradeMarkGoods1 == null) {
                //数据库不存在此记录，则插入
                TradeMarkGoods tradeMarkGoods = new TradeMarkGoods();
                tradeMarkGoods.categoryId = cid;
                tradeMarkGoods.goodsCategoryId = gid;
                tradeMarkGoodsRepository.save(tradeMarkGoods);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizExeption("添加商品分类到商标分类失败");
        }
    }

    /**
     * 根据商品id和商标分类id值删除对应的关系
     *
     * @param cid
     * @param gid
     */
    @Override
    public void deleteGoodsToCategory(long cid, long gid) throws BizExeption {
        try {//先查找到数据库的记录
            TradeMarkGoods tradeMarkGoods = tradeMarkGoodsRepository.findFirstByCategoryIdAndGoodsCategoryId(cid, gid);
            //删除记录
            tradeMarkGoodsRepository.delete(tradeMarkGoods);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizExeption("从商标分类目录里删除商品分类失败");
        }
    }

    /**
     * 更新商品种类
     *
     * @param goodsCategory
     */
    @Override
    public void updateGoods(GoodsCategory goodsCategory) throws BizExeption {
        try {
            goodsCategoryRepository.save(goodsCategory);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizExeption("更新商品分类失败");
        }
    }

    /**
     * 根据id删除商品种类
     *
     * @param gid
     */
    @Override
    public void deleteGoods(long gid) throws BizExeption {
        try {
            goodsCategoryRepository.delete(gid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizExeption("删除商品目录失败");
        }
    }

    /**
     * 新增一个商品种类
     *
     * @param goodsCategory
     */
    @Override
    public GoodsCategory saveGoods(GoodsCategory goodsCategory) throws BizExeption {
        try {
            return goodsCategoryRepository.save(goodsCategory);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizExeption("新增商品目录失败");
        }
    }

    /**
     * 查询所有商品种类
     */
    @Override
    public List<GoodsCategory> findAllGoods() {

        return (List<GoodsCategory>) goodsCategoryRepository.findAll();
    }

    /**
     * 更新商标分类
     *
     * @param category
     */
    @Override
    public void updateCategory(TmCategory category) throws BizExeption {
        try {
            categoryRepository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizExeption("更新商标分类失败");
        }
    }

    /**
     * 根据id删除已个商标分类
     *
     * @param id
     */
    @Override
    public void deleteCategory(long id) throws BizExeption {
        try {
            categoryRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizExeption("删除商标分类目录失败");
        }
    }

    /**
     * 新增一个商标的分类
     *
     * @param category
     */
    @Override
    public TmCategory saveCategory(TmCategory category) throws BizExeption {
        try {
            return categoryRepository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizExeption("新增商标目录失败");
        }
    }

    /**
     * 根据商标分类id找到所有的商品分类
     *
     * @param cid
     * @return
     */
    @Override
    public List<GoodsCategory> findCategoryByGoodsId(long cid) {
        List<TradeMarkGoods> tradeMarkGoods = tradeMarkGoodsRepository.findAllByCategoryId(cid);
        List<Long> ids = new ArrayList<>();
        for (TradeMarkGoods t : tradeMarkGoods) {
            ids.add(t.goodsCategoryId);
        }
        return (List<GoodsCategory>) goodsCategoryRepository.findAll(ids);

    }


}
