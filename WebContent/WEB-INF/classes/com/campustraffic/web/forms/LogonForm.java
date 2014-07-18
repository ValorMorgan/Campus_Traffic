package com.campustraffic.web.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LogonForm extends ActionForm {

    private static final long serialVersionUID = 1L;

    private String name = null;
	private String password = null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
    	name = null;
    	password = null;
    }
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if(this.name.isEmpty()) {
        	errors.add("error.logonForm.name", new ActionMessage("error.logonForm.name", this.name));
        }
        
        if(this.password.isEmpty()) {
        	errors.add("error.logonForm.password", new ActionMessage("error.logonForm.password", this.password));
        }
        
        return errors;
    }
}