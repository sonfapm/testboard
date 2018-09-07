package net.members.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/MembersLogin.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./members/loginForm.jsp");
		} else if (command.equals("/MembersJoin.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./members/joinForm.jsp");
		
		} else if (command.equals("/MembersJoinAction.do")) {
			action = new MembersJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MembersLoginAction.do")) {
			 action = new MembersLoginAction();
			 try {
				 forward = action.execute(request, response);
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		}else if(command.equals("/MembersListAction.do")) {
			action = new MembersListAction();
			try {
				 forward = action.execute(request, response);
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		}else if(command.equals("/MembersViewAction.do")) {
			action = new MembersViewAction();
			try {
				 forward = action.execute(request, response);
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		}else if(command.equals("/MembersDeleteAction.do")) {
			action = new MembersDeleteAction();
			try {
				 forward = action.execute(request, response);
			 }catch (Exception e) {
				 e.printStackTrace();
			}
		}
		
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
}