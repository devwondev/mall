package cafe.jjdev.mall.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cafe.jjdev.mall.service.Item;
import cafe.jjdev.mall.service.ItemDao;

@WebServlet("/GetItemList")
public class GetItemList extends HttpServlet {
	private ItemDao itemDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;
		// request.getParameter("currentPage")
		int pagePerRow = 10;
		itemDao = new ItemDao();
		ArrayList<Item> list = itemDao.selectItemList(currentPage, pagePerRow);
		request.setAttribute("list", list);
		// forward itemList.jsp
		// 상품데이터 샘플로 넣는다. 회원정보수정, 회원정보조회, 상품리스트볼수있도록하자.
	}

	
	

}
