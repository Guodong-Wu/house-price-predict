package edu.seu.housepricepredict.service.impl;

import edu.seu.housepricepredict.mapper.area.StreetMapper;
import edu.seu.housepricepredict.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guodonwu@163.com
 * @date 10:33 2019/2/27
 * 街道的Service实现类
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class StreetServiceImpl implements StreetService {

    @Autowired
    private StreetMapper streetMapper;
}
