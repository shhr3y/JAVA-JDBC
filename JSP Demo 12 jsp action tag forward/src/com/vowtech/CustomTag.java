package com.vowtech;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomTag extends SimpleTagSupport 
{
	public void doTag() throws JspException, IOException 
	{
		JspWriter out = getJspContext().getOut();
		out.println("Current Date is : "+Calendar.getInstance().getTime().toString());
	}
}
