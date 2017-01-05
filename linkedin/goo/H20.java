package goo;
/*
实现两个函数: H() and O(), 这两个函数会被多线程调用。当一个线程调用H或O时
，如果当前已经有至少两个线程call H和一个线程call O。那么让两个call H和一个
call O的线程返回（产生一个水分子），其他的都block*/

import java.util.*;
import java.util.concurrent.locks.*;
public class H20 {
	private int HCount = 0;
	private int OCount = 0;
	private Lock lock = new ReentrantLock();
	private Condition condH = lock.newCondition();
	private Condition condO = lock.newCondition();
	
	
	public void H() throws InterruptedException{
		lock.lock();
		try {
			HCount++;
			if (HCount >= 2 && OCount >= 1) {
				System.out.println("2 H and 1 O consumed in H()");
				HCount -= 2;
				OCount -= 1;
				condH.signal();
				condO.signal();
			} else {
				condH.await();
			}
		} finally {
			lock.unlock();
		}
	}
	
	public void O() throws InterruptedException{
		lock.lock();
		try {
			OCount++;
			if (HCount >= 2 && OCount >= 1) {
				System.out.println("2 H and 1 O consumed in O()");
				HCount -= 2;
				OCount -= 1;
				condH.signal();
				condH.signal();
			} else {
				condO.await();
			}
		} finally {
			lock.unlock();
		}
	}
	
	  public static void main(String[] args) {
	        int n = 3;
	        final H2O h2o = new H2O();
	        Thread[] threads = new Thread[n];
	        for (int i=0; i<n; i++) {
	            final int id = i;
	            threads[i] = new Thread(new Runnable() {
	                @Override
	                public void run() {

