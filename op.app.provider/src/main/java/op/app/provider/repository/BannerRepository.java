package op.app.provider.repository;

import op.app.protocol.enums.PostStatus;
import op.app.protocol.model.entity.Banner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@Repository
public interface BannerRepository extends CrudRepository<Banner, Long> {

    /**
     * 根据id获取banner
     * @param id
     * @return
     */
    Banner findById(long id);

    /**
     * 获取指定位置的banner列表并按照权重排序
     * @param slotId
     * @param status
     * @return
     */
    List<Banner> findAllBySlotIdAndStatusOrderByPriorityAsc(long slotId, PostStatus status);

    /**
     * 获取指定位置并且位于时间段之内的banner列表并按照权重排序
     * @param slotId
     * @param status
     * @param showDateStart
     * @param showDateEnd
     * @return
     */
    List<Banner> findAllBySlotIdAndStatusAndShowDateStartAfterAndShowDateEndBeforeOrderByPriorityAsc(long slotId, PostStatus status, Timestamp showDateStart, Timestamp showDateEnd);

}