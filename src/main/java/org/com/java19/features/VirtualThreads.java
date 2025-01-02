package org.com.java19.features;

import java.util.stream.IntStream;

public class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        //Thread platformThread = Thread.ofPlatform().name("platform worker * 1").start(() -> System.out.println(Thread.currentThread()));
        //System.out.println("-----------------");
        //Thread virtualThread = Thread.ofVirtual().name("virtual worker * 1").start(() -> System.out.println(Thread.currentThread()));

        var start = System.currentTimeMillis();
        var totalThreads = 100000;
        var threads = IntStream.range(0, totalThreads)
                .mapToObj(threadCount -> Thread.ofPlatform().unstarted(() -> {}))
                .toList();
        threads.forEach(Thread::start);
        for(Thread thread : threads) {
            thread.join();
        }
        var end = System.currentTimeMillis();
        System.out.println("Millseconds used to launch " + totalThreads + " virtual threads: " + (end-start) + " ms");
    }
}
