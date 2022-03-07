package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

/**
 * Servlet implementation class ViewAllBooksServlet
 */
@WebServlet("/viewAllBooksServlet")
public class ViewAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookHelper dao = new BookHelper();
		request.setAttribute("allBooks", dao.showAllBooks());
		
		  for(Book b : dao.showAllBooks()) {
		 //System.out.println(b.Details()); }
		
		
		String path = "/Users-list.jsp";
		
		if(dao.showAllBooks().isEmpty()) {
			path = "/index.html";
		}
	
		getServletContext().getRequestDispatcher(path).forward(request, response);
		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
