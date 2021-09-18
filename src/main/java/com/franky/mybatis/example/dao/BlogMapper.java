package com.franky.mybatis.example.dao;

import com.franky.mybatis.example.model.Blog;

/**
 * @Title
 * @Description
 * @Author hdan
 * @Since 2021/9/18
 * @See
 */
public interface BlogMapper {
    Blog selectById(Long id);
}
