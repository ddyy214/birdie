package com.birdie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public abstract String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;//추상메소드
	
}
