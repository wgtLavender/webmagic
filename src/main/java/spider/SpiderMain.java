package spider;

import us.codecraft.webmagic.Spider;

/**
 * @program: webmagic
 * @author: Administrator
 * @create: 2018-11-22 17:24
 **/

public class SpiderMain {
    public static void main(String[] args) {
       String url = "http://search.jumei.com/?filter=0-11-1&search=%E9%9B%B6%E9%A3%9F&from=&cat=";
        new Spider(new BlogProcess()).addUrl(url).run();
    }
}

