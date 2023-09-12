package com.woniuxy.user.config.mp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

public class PageOverflowInterceptor extends PaginationInnerInterceptor {

    private DbType dbType;

    // 构造器传入数据库类型
    public PageOverflowInterceptor(DbType dbType) {
        this.dbType = dbType;
    }


    // 当前页 > 总页数时候执行handlerOverflow方法
    // 重写方法
    @Override
    protected void handlerOverflow(IPage<?> page) {
        // 设置当前页为上一页，也就是总页数
        page.setCurrent(page.getCurrent() - 1);
    }
}
