package net.members.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.members.db.MembersBean;
import net.members.db.MembersDAO;

public class MembersViewAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response)
		 	throws Exception{
		 ActionForward forward = new ActionForward();
		 MembersDAO membersdao=new MembersDAO();
		 String USERID = request.getParameter("USERID");
		 try {
				MembersBean userInfo = new MembersBean();
				
				userInfo = membersdao.getMembersInto(USERID);
				request.setAttribute("userInfo", userInfo);
				forward.setRedirect(false);
				forward.setPath("./member/Member_info.jsp");
				
				return forward;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

