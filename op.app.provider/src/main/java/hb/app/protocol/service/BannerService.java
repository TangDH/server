package op.app.protocol.service;

import op.app.protocol.model.entity.Banner;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
public interface BannerService {

    /**
     * 根据id获取内容
     * @param id 内容id
     * @return 内容
     */
    Banner getById(long id);

    /**根据slotId获取内容
     * @param id
     * @return
     */
    List<Banner> getBySlotId(long id);

    /**
     * 根据slotid和时间段之内要展示的banner获取列表
     * @param slotId
     * @param showDateStart
     * @param showDateEnd
     * @return
     */
    List<Banner> getBySlotIdAndTime(long slotId, Timestamp showDateStart, Timestamp showDateEnd);

    /**
     * 增加一个banner
     * @param banner
     * @return
     */
    Banner addBanner(Banner banner) throws BizExeption;

    /**
     * 删除一个banner
     * @param id
     */
    void deleteBanner(long id) throws BizExeption;

    /**
     * 更新一个banner
     * @param banner
     */
    void updateBanner(Banner banner) throws BizExeption;

}
