package com.campustraffic.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.campustraffic.web.forms.LogonForm;

public class LogoutAction extends Action
{
    public ActionForward execute(ActionMapping mapping, ActionForm form,
    							 HttpServletRequest request, HttpServletResponse response)
    									 throws Exception {
    		HttpSession session = request.getSession();
    		session.removeAttribute("username");
    		session.invalidate();
    		
    		return (mapping.findForward("home"));
    }
}