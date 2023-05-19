package com.hot.commonUtils.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hot.commonUtils.core.PageQueryVO;

/**
 * @author jin
 * @date 2023/5/12
 */
public class QueryVoToPageUtil {
    public static IPage toPage(PageQueryVO queryVO) {
        if (null == queryVO.getPageNum()) {
            queryVO.setPageNum(1);
        }
        if (null == queryVO.getPageSize()) {
            queryVO.setPageSize(10);
        }
        // 分页数据赋值
        IPage page = new Page(queryVO.getPageNum(), queryVO.getPageSize());
        return page;
    }
}
