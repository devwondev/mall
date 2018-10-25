package cafe.jjdev.mall.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cafe.jjdev.mall.service.Member;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IndexController doGet");
		// 1. router : @WebServlet("/index")
		
		// 2. model : DAO모델생성
		String model = "jjdev";
		// view rend...(template)
		
		request.setAttribute("model", model);	
		Member member = new Member();
		member.setNo(1); member.setId("guest"); member.setLevel(0);
		request.setAttribute("member", member);	// ${member.id}
		ArrayList<String> list = new ArrayList<String>();
		list.add("승정"); list.add("승우"); list.add("승정");
		request.setAttribute("list", list);	// ${list}
		
		
		// 4. Forward(request, response) to WEB-INF/jsp/index.jsp	
		
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request,  response); 	
	}
}