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
		
		// 2. model호출 : DAO모델생성
		String model = "jjdev";
		// view rend...(template)
		
		request.setAttribute("model", model);	// view쪽에서 표현식 ${model}을 보여줌
		Member member = new Member();
		member.setNo(1); member.setId("guest"); member.setLevel(0);
		request.setAttribute("member", member);	// ${member.id}
		ArrayList<String> list = new ArrayList<String>();
		list.add("승정"); list.add("승우"); list.add("찬우");
		request.setAttribute("list", list);	// ${list}
		
		
		// 4. Forward(request, response) to WEB-INF/jsp/index.jsp	// Forward:"내가 request, response 다 처리할 수 있는데 그냥 index 니가 해라"
		
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request,  response); // request안에 있는 dispatcher객체를 꺼내면서 어디로 포워딩할건지 매개변수로 알려줌	
	}
}