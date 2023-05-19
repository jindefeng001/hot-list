package com.hot.gecco.utils;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * @author jin
 * @date 2021/8/5
 */
@Gecco(pipelines={"redisPipeline"})
public class GeccoEntity implements HtmlBean {

    private static final long serialVersionUID = 665662335318691818L;
    
    private List<HrefBean> content;

    public List<HrefBean> getContent() {
        return content;
    }

    public void setContent(List<HrefBean> content) {
        this.content = content;
    }
    
}
