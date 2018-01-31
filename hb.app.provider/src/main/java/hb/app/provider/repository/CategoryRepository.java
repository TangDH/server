package hb.app.provider.repository;

import hb.app.protocol.model.entity.TmCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@org.springframework.stereotype.Repository
public interface CategoryRepository extends CrudRepository<TmCategory, Long> {

     /**
      * 根据分类名Category
      * @param name
      * @return
      */
     List<TmCategory> findAllByName(String name);

     /**
      * 根据父类获取所有子分类
      * @param parentId
      * @return
      */
     List<TmCategory> findAllByParentId(long parentId);

     /**
      * 根据分类名一级目录，显示未注册类别
      * @param level
      * @param ids
      * @return
      */
     List<TmCategory> findAllByLevelAndIdNotIn(int level, Collection<Long> ids);

     /**
      * 找到第一个商品分类对应的商标分类一级目录
      * @param level
      * @param ids
      * @return
      */
     TmCategory findFirstByLevelAndIdIn(int level, Collection<Long> ids);

     /**
      * 获取当前第几级的分类
      * @param level
      * @return
      */
     List<TmCategory> findAllByLevel(int level);


     /**
      * 根据一级目录找出二级目录下的商品对应的商标二级分类
      * @param ids
      * @param id
      * @return
      */
     List<TmCategory> findAllByParentIdAndIdIn(long id, Collection<Long> ids);

     /**
      * 根据id集合查找所有的商标第三级分类
      * @param ids
      * @return
      */
     List<TmCategory> findAllByParentIdIn(Collection<Long> ids);

     List<TmCategory> findAllByLevelAndIdIn(int level, Collection<Long> ids);

     TmCategory findFirstByName(String name);

}