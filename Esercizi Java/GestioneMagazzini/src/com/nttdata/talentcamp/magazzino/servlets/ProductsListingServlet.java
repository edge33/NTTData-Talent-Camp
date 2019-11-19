package com.nttdata.talentcamp.magazzino.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nttdata.talentcamp.magazzino.models.Product;

/**
 * Servlet implementation class ProductsListingServlet
 */
@WebServlet("/ProductsListingServlet")
public class ProductsListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsListingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductListingServlet In");
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product("vestito amazon", "vestito", 100));
		products.add(new Product("iphone 11 pro", "smartphone", 1000));
		products.add(new Product("citizen", "orologi", 70));
		products.add(new Product("Omega", "orologi", 3000));
		request.setAttribute("productsList", products);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productsList.jsp");
		System.out.println("ProductListingServlet Out");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
