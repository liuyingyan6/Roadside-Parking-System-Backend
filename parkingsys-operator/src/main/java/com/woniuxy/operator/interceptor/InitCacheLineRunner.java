package com.woniuxy.operator.interceptor;


import com.google.common.hash.BloomFilter;
import com.woniuxy.operator.entity.CarType;
import com.woniuxy.operator.entity.Charge;
import com.woniuxy.operator.entity.UrlPermission;
import com.woniuxy.operator.service.ICarTypeService;
import com.woniuxy.operator.service.IChargeService;
import com.woniuxy.operator.service.IUrlPermissionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目启动时候，会自动执行实现CommandLineRunner接口的类的run()方法
 */
@Component
public class InitCacheLineRunner implements CommandLineRunner {
    // 查询的新课上线的课程数量
    private final RedisTemplate<String, Object> redisTemplate;

    // 注入布隆过滤器
    private final BloomFilter<String> bloomFilter;

    private final IUrlPermissionService urlPermissionService;
    private final IChargeService chargeService;
    private final ICarTypeService carTypeService;
    public InitCacheLineRunner(RedisTemplate<String, Object> redisTemplate, BloomFilter<String> bloomFilter, IUrlPermissionService urlPermissionService, IChargeService chargeService, ICarTypeService carTypeService) {
        this.redisTemplate = redisTemplate;
        this.bloomFilter = bloomFilter;
        this.urlPermissionService = urlPermissionService;
        this.chargeService = chargeService;
        this.carTypeService = carTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        // 先判断布隆过滤器中是否有这个key，没有就放入
        if (!bloomFilter.mightContain("urlPermissionService")) {
            bloomFilter.put("urlPermissionService");
        }
        if (!bloomFilter.mightContain("chargeService")) {
            bloomFilter.put("chargeService");
        }  if (!bloomFilter.mightContain("carTypeService")) {
            bloomFilter.put("carTypeService");
        }

        //查询所有的书籍
        List<UrlPermission> list = urlPermissionService.list();
        list.forEach(e -> {
            //使用HASH数据类型，存储库存量
            redisTemplate.opsForHash().put("urlPermissionService", "" + e.getId(), e);
        });

        List<Charge> chargeList = chargeService.list();
        chargeList.forEach(c->{
            redisTemplate.opsForHash().put("chargeService", "" + c.getId(), c);
        });

        List<CarType> list1 = carTypeService.list();
        list1.forEach(a->{
            redisTemplate.opsForHash().put("carTypeService", "" + a.getId(), a);
        });
    }
}