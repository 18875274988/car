package com.sys.dao;

import com.sys.entity.ApplycarPo;
import com.sys.entity.OrderPo;
import com.sys.vo.ApplyCarVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/25
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
@Repository
public interface ApplyCarDao {

    List<ApplycarPo> findAllfree();
    /**
     * 生成订单
     * @param carNo
     * @return
     */
    int applyOrder(String carNo, String userName);

    /**
     * 提交订单修改车辆状态
     */
    int updatecarState(Integer id);
    /**
     * 按账户查找材料
     */
    String findMaterial(String userName);
}
