package com.sakadream.jsf.controller;

import com.sakadream.jsf.func.Functions;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by Phan Ba Hai on 17/07/2017.
 */

@ManagedBean(name = "login", eager = true)
@RequestScoped
public class LoginController implements Serializable {
    private Functions func = new Functions();

    public String login() throws SQLException, ClassNotFoundException {
        FacesContext context = FacesContext.getCurrentInstance();
        String username = func.getParameterByName("username");
        String password = func.getParameterByName("password");
        boolean valid = func.checkLogin(username, password);
        if(valid) return "home";
        else {
            context.addMessage("loginForm",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username or password not valid, please try again!", ""));
            return null;
        }
    }

    public String logout() {
        HttpSession session = func.getSession();
        session.invalidate();
        return "login";
    }
}
