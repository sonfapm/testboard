package net.members.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import net.members.db.MembersBean;
import net.members.db.MembersDAO;

public class MembersJoinAction implements Action  {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response)
			 	throws Exception{
				 request.setCharacterEncoding("euc-kr");
				 ActionForward forward = new ActionForward();
				 MembersDAO membersdao=new MembersDAO();
				 MembersBean membersdata=new MembersBean();
				 
				 boolean result = false;
				 
				 membersdata.setUSERID(request.getParameter("USERID"));
				 membersdata.setPA(request.getParameter("PA"));
				 membersdata.setMAIL(request.getParameter("MAIL"));
				 membersdata.setUSERNAME(request.getParameter("UERSNAME"));
				 membersdata.setIDENT(request.getParameter("IDENT"));
				 membersdata.setINTRODUCEMYSELF(request.getParameter("INTRODUCEMYSELF"));
				 System.out.println(request.getParameter("USERID"));
				 
				 result=membersdao.joinmember(membersdata);
				 
				 if(result==false) {
					 System.out.print("½ÇÆÐ");
					 return null;
				 }
				 
				 forward.setRedirect(true);
				 forward.setPath("MembersLogin.do");
				 return forward;
	}
	

}
