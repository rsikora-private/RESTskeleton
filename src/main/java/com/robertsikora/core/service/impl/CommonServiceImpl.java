package com.robertsikora.core.service.impl;

import com.robertsikora.core.model.RedisEntity;
import com.robertsikora.core.repo.RedisRepo;
import com.robertsikora.core.service.CommonService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * Created by robertsikora on 18.03.2016.
 */
public abstract class CommonServiceImpl<E extends RedisEntity, K extends Serializable>
        implements CommonService<E, K> {

    private RedisRepo<E, K> redisRepo;

    @Override
    public K create(final E entity) {
        Assert.notNull(entity);
        return redisRepo.create(entity);
    }

    @Override
    public E findById(final K id) {
        Assert.notNull(id);
        return redisRepo.getById(id);
    }

    @Override
    public void delete(K id) {
        Assert.notNull(id);
        redisRepo.delete(id);
    }

    @Required
    public void setRedisRepo(final RedisRepo<E, K> redisRepo) {
        this.redisRepo = redisRepo;
    }
}
