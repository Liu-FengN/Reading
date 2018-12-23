package com.qidian.lucy;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Reading implements Runnable{
	/**
	 * 页面路径
	 */
	String url;
	/**
	 * 存储抓取的数据
	 */
	ArrayList<Message> list;
	
	
	public Reading(String url, ArrayList<Message> list) {
		super();
		this.url = url;
		this.list = list;
	}


	@Override
	public void run() {
		String name=Thread.currentThread().getName();	
		System.out.println(name + "," + url); //开始处理
		
		try {
			Document doc=Jsoup.connect(url).get();
			
		    Elements es=doc.select(".book-img-text ul li");
		    
			for(Element e:es) {
				Message m=new Message();
	    			m.num=Integer.parseInt(e.select(".book-img-box span").text());
					m.title=e.select("h4").text();
					m.poster=e.select(".book-img-box img").attr("src");
					m.author=e.select(".author a").first().text();
					m.type=e.select(".author a").last().text();
					m.Zcase=e.select(".update a").text();
					m.riq=e.select(".update span").last().text();
					m.info=e.select(".intro").text();
		    // 	    m.rating=Double.parseDouble(e.select(".total p").text());
			     	
		     	
		     	System.out.println(name + ":" + m);
				list.add(m);	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
