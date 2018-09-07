package net.members.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.members.db.MembersDAO;


public class MembersListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MembersDAO membersdao = new MembersDAO();
		ActionForward forward = new ActionForward();
		List memberList = new ArrayList();
		
		
		memberList = membersdao.getMembersList();
		
		
		request.setAttribute("memberList", memberList);
		
		forward.setRedirect(false);
   		forward.setPath("./members/Member_list.jsp");
   		return forward;
	}
}