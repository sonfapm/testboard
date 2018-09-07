package net.members.action;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.members.action.Action;
import net.members.action.ActionForward;


import net.members.db.MembersDAO;
import net.members.db.MembersDAO;

public class MembersDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response)
		 	throws Exception{
		MembersDAO membersdao = new MembersDAO();
		ActionForward forward = new ActionForward();
		try {
			String USERID = request.getParameter("USERID");

			if (membersdao.deleteMembers(USERID)) {
				forward.setRedirect(true);
				forward.setPath("./MembersListAction.do");

			}
			return forward;

		} catch (Exception e) {
		
		}

		return null;
	}
}
