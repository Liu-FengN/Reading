package com.qidian.lucy;


public class Message implements Comparable<Message>{
	/**
	 * 排名
	 */
	 int num;
	 /**
	  * 海报
	  */
	 String poster;
	 /**
	  * 作品名
	  */
	 String title;
	 /**
	  * 作者
	  */
	 String author;
	 /**
	  * 类型
	  */
	 String type;
	 /**
	  * 连载状况
	  */
	 String  Zcase;
	 /**
	  * 更新时间
	  */
	String riq;
	 /**
	  * 简介
	  */
	 String info;
	 /**
	  * 月票
	  */
	 double rating;
	 
	public String toCSV() {
		return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%.1f\n",
    			num,
    			poster,
    			title,
    			author,
    			type,
                info,
    			Zcase,
    			riq,
    			rating);
    }
	

	@Override
	public String toString() {
		return "Message [num=" + num + ", poster=" + poster + ", title=" + title + ", author=" + author + ", type="
				+ type + ", Zcase=" + Zcase + ", riq=" + riq + ", info=" + info + ", rating=" + rating + "]";
	}


	public int compareTo(Message o) {
		// TODO Auto-generated method stub
		return num-o.num;    //降序排列
	}

}
