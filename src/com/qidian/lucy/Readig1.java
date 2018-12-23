package com.qidian.lucy;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Readig1 {
	
	public static void main(String[] args) {
	
		 ExecutorService pool=Executors.newFixedThreadPool(8);
		 
		 ArrayList<Message> list=new ArrayList<>();
		 
		 String url = "https://www.qidian.com/rank/yuepiao?style=1&page";
		 
	     for(int i=1;i<26;i++) {
	    	String path = String.format("%s=%d",url,i);//"%s"占位符    "%d"数字
		    pool.submit(new Reading(path,list));
	      }
	     pool.shutdown();//停止
	     System.out.println(pool.isTerminated());
	     
	     while(!pool.isTerminated()) {       //判断任务结束
	    	 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }
	        Collections.sort(list);
	        
	    	System.out.println(list.size());
	    	
	    	String file="d:/message.csv";      //绝对路径
	    	file="message.csv";                //相对路径
	    	//排序
	    	Collections.sort(list);   //()里写规则
	    	try(FileWriter out=new FileWriter(file)) { 
	    		//写数据
			for (Message message : list) {
				out.write(message.toCSV());
				
			}	
			System.out.println("ok");
			} catch (Exception e) {
			}
	}
}

