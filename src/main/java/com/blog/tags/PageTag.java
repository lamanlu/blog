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

    private String params;

    private int curPage;

    private int dataCount;

    private int pageSize = 20;

    private int length = 7;

    public PageTag() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
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

        int pageCount = (int)Math.ceil((double)this.dataCount / this.pageSize);

        StringBuffer stringBuffer = new StringBuffer();
        String tmpStr = "page:"+this.curPage+" pagesize:"+this.pageSize+" datacount:"+this.dataCount+" pageCount:"+pageCount+"<br>";
        stringBuffer.append(tmpStr);

        tmpStr = "<div class=\"pagination\">";
        stringBuffer.append(tmpStr);

        if(this.curPage > 0){
            tmpStr = "<a href=\""+this.pageUrl(0)+"\">首页</a>";
            stringBuffer.append(tmpStr);

            tmpStr = "<a href=\""+this.pageUrl(this.curPage-1)+"\">上一页</a>";
            stringBuffer.append(tmpStr);
        }


        int maxPreNum = (int)Math.ceil(this.length / 2);

        int startPage = this.curPage - maxPreNum;
        if(startPage < 0){
            startPage = 0;
        }

        int lastPage = startPage + this.length;
        if(lastPage > pageCount){
            this.length = this.length - (lastPage - pageCount);
        }

        for(int i = startPage; i < this.length; i++ ){
            if(i == this.curPage){
                tmpStr = "<a href=\"javascript:void(0);\">"+(i+1)+"</a>";
                stringBuffer.append(tmpStr);
            }else{
                tmpStr = "<a href=\""+this.pageUrl(i)+"\">"+(i+1)+"</a>";
                stringBuffer.append(tmpStr);
            }
        }

        if((pageCount-1) > this.curPage){
            tmpStr = "<a href=\""+this.pageUrl(this.curPage+1)+"\">下一页</a>";
            stringBuffer.append(tmpStr);

            tmpStr = "<a href=\""+this.pageUrl(pageCount-1)+"\">末页</a>";
            stringBuffer.append(tmpStr);
        }

        stringBuffer.append("</div>");

        jspWriter.print(stringBuffer.toString());
    }

    private String pageUrl(int page){
        if(this.params == null){
            if(page > 0) {
                return this.url + "?page=" + page;
            }else{
                return this.url;
            }
        }else{
            if(page > 0) {
                return this.url + "?" + this.params + "&page=" + page;
            }else{
                return this.url + "?" + this.params;
            }
        }
    }


}
