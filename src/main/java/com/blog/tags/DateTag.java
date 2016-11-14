package com.blog.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LamanLu on 2016/11/14.
 */
public class DateTag extends SimpleTagSupport {

    private String formatRule = "yyyy-MM-dd HH:mm:ss";

    private long timeStamp;

    public DateTag() {
    }

    public String getFormatRule() {
        return formatRule;
    }

    public void setFormatRule(String formatRule) {
        this.formatRule = formatRule;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        JspWriter jspWriter = pageContext.getOut();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.formatRule);
        Date dateObj = new Date(this.timeStamp * 1000);
        String dateTime = simpleDateFormat.format(dateObj);

        jspWriter.print(dateTime);
    }
}
