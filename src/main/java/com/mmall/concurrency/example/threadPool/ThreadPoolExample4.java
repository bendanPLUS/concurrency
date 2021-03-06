package com.mmall.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {

	public static void main(String[] args) {

		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
		//initialDelay the time to delay first execution
		//initialDelay就是开始的时间 到执行第一个线程的时间间隔 单位s
		log.info("开始的时间---   ");
//        executorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                log.warn("schedule run");
//            }
//        }, 3, TimeUnit.SECONDS);

		executorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				log.warn("schedule run , thread name is {}", Thread.currentThread().getName());
			}
		}, 0, 2, TimeUnit.SECONDS);
//        executorService.shutdown();

		//间隔5s继续执行
//		Timer timer = new Timer();
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				log.warn("timer run");
//			}
//		}, new Date(), 5 * 1000);
	}
}
