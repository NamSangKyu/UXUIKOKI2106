package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.ModelAndView;

public interface Controller {
	public ModelAndView execute(HttpServletRequest request,HttpServletResponse response);
}
