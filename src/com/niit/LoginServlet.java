package com.niit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String userID=	request.getParameter("userID");  //name of the user id field in login.html
	String password =  request.getParameter("password");    //name of the password field in login.html
	
	
	//send it it corresponding DAO
	
	//creat instance of LoginDAO
	LoginDAO  loginDAO = new LoginDAO();
	
	//get the request dispatcher so that we dispatch either to home page or login page
	
	
	
	if (  loginDAO.isValidCredentials(userID, password))
	{
		//Navigate/dispatch to Home page
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/Home");
		dispatcher.forward(request, response);
		
	}
	
	else
	{
		//Navigate/dispatch to Login page
		//show error message
		RequestDispatcher dispatcher =request.getRequestDispatcher("Login");
		dispatcher.forward(request, response);  //supposed use include
		
	}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
