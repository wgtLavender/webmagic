package spider;

import org.assertj.core.error.ShouldBeAfterOrEqualsTo;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: webmagic
 * @author: Administrator
 * @create: 2018-11-22 17:08
 **/

public class BlogProcess implements PageProcessor {

    //创建站点信息
    private Site site = Site.me().setRetryTimes(3).setTimeOut(3000);

    public void process(Page page) {

//        List<String> all = page.getHtml().xpath("div[@class='mod_search_pro']/div[@class='itemBox']/div[@class='proImg']/a/img/@src").all();
        List<String> names = page.getHtml().xpath("//*[@id=\"search_list_wrap\"]/div/ul/li/div/div/div/a/img/@alt").all();
        List<String> prices = page.getHtml().xpath("//*[@id=\"search_list_wrap\"]/div/ul/li/div/div/div/div/span/text()").all();
        List<String> imgs = page.getHtml().xpath("//*[@id=\"search_list_wrap\"]/div/ul/li/div/div/div/a/img/@src").all();
        List<String> pages = page.getHtml().xpath("//*[@id=\"search_list_wrap\"]/div/ul/li/a/@href").all();
//        int total = Integer.parseInt(pages.get(pages.size() - 2));
//        System.out.println(total);
        //循环生成所有分页的url
        List<String> nextUrl = new ArrayList<String>();
        for (int i = 1; i <= 18; i++) {
            nextUrl.add("http://search.jumei.com/?filter=0-11-"+ i +"&search=%E9%9B%B6%E9%A3%9F&bid=4");
        }
        //继续抓取
        page.addTargetRequests(nextUrl);
    
        for (int i=0;i<12;i++) {


            System.err.println("名字："+ names.get(i) + "价钱："+ prices.get(i) + "图片：" + imgs.get(i));

        }

    }

    public Site getSite() {
        return site;
    }
}

