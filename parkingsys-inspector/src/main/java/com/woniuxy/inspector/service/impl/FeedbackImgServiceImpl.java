package com.woniuxy.inspector.service.impl;

import com.woniuxy.inspector.entity.FeedbackImg;
import com.woniuxy.inspector.mapper.FeedbackImgMapper;
import com.woniuxy.inspector.service.IFeedbackImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@Service
public class FeedbackImgServiceImpl extends ServiceImpl<FeedbackImgMapper, FeedbackImg> implements IFeedbackImgService {

    private final FeedbackImgMapper feedbackImgMapper;

    public FeedbackImgServiceImpl(FeedbackImgMapper feedbackImgMapper){
        this.feedbackImgMapper = feedbackImgMapper;
    }

}
