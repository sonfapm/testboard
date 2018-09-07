package net.members.action;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.board.db.BoardDAO;
import net.members.db.MembersBean;
import net.members.db.MembersDAO;

public class MembersLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		MembersDAO membersdao = new MembersDAO();
		MembersBean membersdata=new MembersBean();
		ActionForward forward = new ActionForward();
		
		
		String USERID = request.getParameter("USERID");
		String PA = request.getParameter("PA");
		try {
			if (membersdao.isMembers(USERID, PA)) {
				System.out.println("로그인성공함");
				forward.setRedirect(true);
				forward.setPath("./BoardList.bo");
				
				HttpSession session = request.getSession();
				session.setAttribute("USERID", USERID);
				System.out.println("세션부여성공");
				return forward;
			} else {
				System.out.println("로그인실패함");
				forward.setRedirect(false);
				forward.setPath("MembersLogin.do");
				return forward;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

		
