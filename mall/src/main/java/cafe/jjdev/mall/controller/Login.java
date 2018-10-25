package cafe.jjdev.mall.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cafe.jjdev.mall.service.Member;
import cafe.jjdev.mall.service.MemberDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	private MemberDao memberDao;
	// �α��� ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loginMember") == null) {
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		} else {
			System.out.println("�α��� ���Դϴ�...");
			response.sendRedirect("/mall/index");
		}
	}
	// �α��� �׼�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Member member = new Member();
		memberDao = new MemberDao();
		member.setId(id);
		member.setPw(pw);
		try {
			Member m = MemberDao.loginMember(member);
			if(m.isLogin()==true) {
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", member);
				response.sendRedirect("/mall/index");
			} else {
				response.sendRedirect("/mall/login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
