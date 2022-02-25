package com.franky.mybatis.example.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title 第一个拦截器
 * @Author hdan
 * @Since 2022/2/24
 */
@Intercepts({@Signature(
        type= Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class FirstInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // implement pre processing if need
        LOGGER.info("start to process first interceptor");
        Object returnObject = invocation.proceed();
        // implement post processing if need
        LOGGER.info("end to process first interceptor");
        return returnObject;
    }
}
