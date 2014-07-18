package com.campustraffic.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.campustraffic.web.forms.LogonForm;

public class LogonAction extends Action
{
    public ActionForward execute(ActionMapping mapping, ActionForm form,
    							 HttpServletRequest request, HttpServletResponse response)
    									 throws Exception {
    		ActionForward forward = new ActionForward(); // return value

    		LogonForm lform = (LogonForm)form;
    		String name = lform.getName();
    		String password = lform.getPassword();

    		System.out.print("Login Status: ");
    		if(name.equals("admin") && password.equals("hcf")) {
    			System.out.println("success");
    			request.getSession().setAttribute("username", name);
    			forward = mapping.findForward("success");
    		} else {
    			System.out.println("failure");
    			forward = mapping.findForward("failure");
    		}

    		return (forward);
    }
}