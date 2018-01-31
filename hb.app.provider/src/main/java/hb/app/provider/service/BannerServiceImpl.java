package hb.app.provider.service;

import hb.app.protocol.enums.PostStatus;
import hb.app.protocol.model.entity.Banner;
import hb.app.protocol.service.BannerService;
import hb.app.protocol.service.BizExeption;
import hb.app.provider.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by gabry on 2017/7/21.
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    /**
     * 根据id获取内容
     * @param id 内容id
     * @return 内容
     */
    public Banner getById(long id) {
        return bannerRepository.findById(id);
    }

    /**根据slotId获取内容
     * @param id
     * @return
     */
    @Override
    public List<Banner> getBySlotId(long id) {
        return bannerRepository.findAllBySlotIdAndStatusOrderByPriorityAsc(id, PostStatus.Publish);
    }

    /**
     * 根据slotid和时间段之内要展示的banner获取列表
     * @param slotId
     * @param showDateStart
     * @param showDateEnd
     * @return
     */
    @Override
    public List<Banner> getBySlotIdAndTime(long slotId, Timestamp showDateStart, Timestamp showDateEnd) {
        return bannerRepository.findAllBySlotIdAndStatusAndShowDateStartAfterAndShowDateEndBeforeOrderByPriorityAsc(slotId,PostStatus.Publish,showDateStart,showDateEnd);
    }

    /**
     * 增加一个banner
     * @param banner
     * @return
     */
    @Override
    public Banner addBanner(Banner banner) throws BizExeption {
        try {
            return bannerRepository.save(banner);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizExeption("增加banner失败");
        }
    }

    /**
     * 删除一个banner
     * @param id
     */
    @Override
    public void deleteBanner(long id) throws BizExeption {
        try {
            bannerRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizExeption("删除banner失败");
        }
    }

    /**
     * 更新一个banner
     * @param banner
     */
    //必须传进来id
    @Override
    public void updateBanner(Banner banner) throws BizExeption {
        try {
            bannerRepository.save(banner);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizExeption("更新banner失败");
        }
    }

}
