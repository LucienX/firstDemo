package com.viva.lucien.spider.test;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.viva.lucien.service.BaiduService;
import com.viva.lucien.util.JdbcUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


/**
 * 
 * @time:2017年4月14日 上午10:15:47
 * @author Wuqx
 *
 * @Description:webmagic爬虫测试
 */
public class test implements PageProcessor {
	
/*	private Site site = Site.me().setSleepTime(1);
	int temp=1;
	public static void main(String[] args) {  
        //Spider是爬虫的入口类,addurl为入口url  
        Spider oschinaSpider = Spider.create(new test()).addUrl("https://baidu.com")  
                //Pipeline是结果输出和持久化的接口，这里ConsolePipeline表示结果输出到控制台  
                .addPipeline(new ConsolePipeline());  
        try {  
            //添加到JMT监控中  
            SpiderMonitor.instance().register(oschinaSpider);  
            //设置线程数  
            //oschinaSpider.thread(5);  
            oschinaSpider.run();  
        } catch (JMException e) {  
            e.printStackTrace();  
        }   
    }

	@Override
	public void process(Page page) {
		page.putField("title", page.getHtml().xpath("//p").get());
		List<String> links=page.getHtml().css("div").links().regex("https://baidu.com/").all();
		page.addTargetRequests(links);
		System.out.println("记录数:"+temp++);
	}

	
	@Override
	public Site getSite() {
		return site;
	}*/
	
	@Autowired
	private BaiduService baiduService;
	
	  private Site site= Site.me().setRetryTimes(1).setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64)" + " AppleWebKit/537.36 (KHTML, like Gecko)"
				+ " Chrome/58.0.3013.3 Safari/537.36").setCharset("UTF-8");  
	  int temp=0;
	    public void process(Page page){  
	    	//通过增加需要抓取的url新闻详情页的xpath抓取。
	   /* 	List<String> pages=page.getHtml().xpath("ul[@class='ulist focuslistnews']").links().all();
	    	 page.addTargetRequests(pages);//增加需要抓取的url
	    	if(page.getUrl().regex("com/").match()){
	    		List<String> links = page.getHtml().xpath("[@class='ulist focuslistnews']").links().all();  
	    		page.addTargetRequests(links);
	    		 System.out.println("记录数:"+temp++);  
	              page.putField("title", page.getHtml().xpath("//h1/text()").toString());
	    	}*/
	    	
	    	try {
	    	Map<String,String> linkTitleMap=new HashMap<String,String>();
	    	List<String> links=page.getHtml().xpath("ul[@class='ulist focuslistnews']").links().all();
	    	List<String> titles=page.getHtml().xpath("//ul[@class='ulist focuslistnews']/li/a/text()").all();
	    	String str="";
	    	if(links.size()==titles.size()){
	    		for(int i=0;i<titles.size();i++){
	    		String sql="insert into baidu(title,url) values('"+titles.get(i)+"','"+links.get(i)+"')";
	    		Connection con=	JdbcUtil.getConnection();
	    		Statement st=con.createStatement();
	    		st.executeUpdate(sql);
	    		st.close();
				con.close();
	    			linkTitleMap.put(titles.get(i), links.get(i));
	    			str+=titles.get(i)+","+links.get(i)+"\r\n";
	    		}
	    	}
	    	System.out.println(linkTitleMap.toString());
	    
	    		FileWriter writer = new FileWriter("d:\\ants_info.txt", true);
	    		   writer.write(str);
	    		   writer.close();
	           
	    	}
	    	catch (Exception e) {
				e.printStackTrace();
			}
	    	 
	    //使用jsoup匹配要定制规则。。
	  /*  	Document html = Jsoup.parse(page.toString());

			Elements elements = html.select("ul[class=ulist focuslistnews]");

			Iterator<Element> iterator = elements.iterator();

			while (iterator.hasNext()) {
				Element li = iterator.next();
				System.out.println(li);
			}*/
			
			
 	    }  
	  
	    public Site getSite(){  
	        return site;  
	    }  
	  
	    public static void main(String[] args){  
	        
	        Spider.create(new test()).addUrl("http://news.baidu.com/").run(); 
	        //国内
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=civilnews").run(); 
	        //财经
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=FinanceNews").run(); 
	        //体育
	       Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=SportNews").run(); 
	        //汽车
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=AutoNews").run(); 
	        //互联网
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=InternetNews").run(); 
	       /* //本地(定制新规则，这返回的是Json，换种方式。)
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=LocalHouseNews").run(); */
	        //互联网+
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=InternetPlusNews").run(); 
	        //房产
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=HouseNews").run(); 
	       
	        //科技
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=TechNews").run(); 
	        //教育
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=EduNews").run(); 
	        //娱乐
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=EnterNews").run(); 
	        //游戏
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=GameNews").run(); 
	        //探索
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=DiscoveryNews").run(); 
	        //健康
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=HealthNews").run(); 
	        //女人
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=LadyNews").run(); 
	        //社会
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=SocialNews").run(); 
	        //军事
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=MilitaryNews").run(); 
	        //图片新闻
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=PicWall").run(); 
	       /* //
	        Spider.create(new test()).addUrl("http://news.baidu.com/widget?id=civilnews").run(); */
	    }  

}


