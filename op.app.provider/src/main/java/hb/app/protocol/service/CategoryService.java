package op.app.protocol.service;

import op.app.protocol.model.entity.TmCategory;
import op.app.protocol.model.entity.GoodsCategory;

import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
public interface CategoryService {

    /**
     * 根据商品id和商标分类id值添加商品到商标种类
     * @param cid
     * @param gid
     */
  void addGoodsToCategory(long cid,long gid) throws BizExeption;

    /**
     * 根据商品id和商标分类id值从商标里删除商品的对应
     * @param cid
     * @param gid
     */
  void deleteGoodsToCategory(long cid,long gid) throws BizExeption;

    /**
     * 更新商品种类
     * @param goodsCategory
     */
  void updateGoods(GoodsCategory goodsCategory) throws BizExeption;

    /**
     * 根据id删除商品种类
     * @param gid
     */
  void deleteGoods(long gid) throws BizExeption;

    /**
     * 新增一个商品种类
     * @param goodsCategory
     */
  GoodsCategory saveGoods(GoodsCategory goodsCategory) throws BizExeption;

    /**
     *查询所有商品种类
     */
  List<GoodsCategory> findAllGoods();

    /**
     * 更新商标分类
     * @param category
     */
  void updateCategory(TmCategory category) throws BizExeption;

    /**
     * 根据id删除已个商标分类
     * @param id
     */
  void deleteCategory(long id) throws BizExeption;

    /**
     * 新增一个商标的分类
     * @param category
     */
  TmCategory saveCategory(TmCategory category) throws BizExeption;

    /**
     * 根据商标分类id找到所有的商品分类
     * @param id
     * @return
     */
  List<GoodsCategory> findCategoryByGoodsId(long id);
}
