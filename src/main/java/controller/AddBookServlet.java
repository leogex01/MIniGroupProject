package controller;

import java.awt.print.Book;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class addBookServlet
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	// TODO Auto-generated method stub 
	
		String bookTitle =request.getParameter("bookTitle");
		String bookAuthor =request.getParameter("bookAuthor");
		
		
		//Book b = new Book(bookTitle, bookAuthor);
		Book b = new Book();
		BookHelper dao = new BookHelper();
		dao.insert(b);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
