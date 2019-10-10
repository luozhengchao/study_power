package com.luo.demo01.service;

import com.luo.demo01.config.AsyncConfig;
import com.luo.demo01.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 * @Author luozhengchao
 * @Date 2019/3/6 7:17 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AsyncConfig asyncConfig;

    Logger logger = Logger.getLogger("aaaa");

    @Async
    @Override
    public String insert(final String user) {

        logger.info(Thread.currentThread().getName());
//        return Thread.currentThread().getName();
        StringBuffer buffer = new StringBuffer("");
        excute(user, buffer);
        return buffer.toString();
//        return submit(user,buffer).toString();
    }

    @Override
    public User save(User user) {
        return user;
    }

    /**
     * 无返回值
     * @param user
     * @param buffer
     */
    private void excute(final String user, final StringBuffer buffer) {
        Executor executorPool = asyncConfig.getAsyncExecutor();
        for (int i = 0; i <= 100; i++) {
            executorPool.execute(new Thread(){
                @Override
                public void run() {
                    buffer.append(user).append("==").append(Thread.currentThread().getName()).append(">>");
                }
            });
        }
    }

    private StringBuffer submit(final String user, final StringBuffer buffer) {
        ThreadPoolTaskExecutor executorPool = new ThreadPoolTaskExecutor();
        for (int i = 0; i <= 100; i++) {
            Future<?> submit = executorPool.submit(new Thread() {

                @Override
                public void run() {
                    buffer.append(user).append("==").append(Thread.currentThread().getName()).append(">>");
                }
            });

            try {
                StringBuffer o = (StringBuffer)submit.get();
                return o;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }


        }
        return new StringBuffer("错误");
    }

}
