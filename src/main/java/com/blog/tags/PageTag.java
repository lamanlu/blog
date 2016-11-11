package com.blog.tags;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by LamanLu on 2016/11/11.
 */
public class PageTag extends SimpleTagSupport {

    private String url;

    private int curPage;

    private int dataCount;

    private int pageSize = 20;

    public PageTag() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        JspWriter jspWriter = pageContext.getOut();

        StringBuffer stringBuffer = new StringBuffer();
        String str = "<div>" + this.url + "=>" + this.curPage + "=>" + this.dataCount + "</div>";
        stringBuffer.append(str);

        jspWriter.print(stringBuffer.toString());
    }


}
