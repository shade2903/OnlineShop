package com.haiduk.servlets;






import com.haiduk.domain.PriceList;
import com.haiduk.domain.Product;
import com.haiduk.entities.User;
import com.haiduk.service.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/price")
public class SecondServlet extends HttpServlet {
    private final static ArrayList<Product> listProduct = PriceList.getListProduct();
    private final static ArrayList<Product> selectList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("selectList",selectList);
        req.getRequestDispatcher("/menu.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        session.setAttribute("name",name);
//        final String nameProduct = request.getParameter("nameProduct");
//        final String price = request.getParameter("price");
//         final Product product = new Product(nameProduct, Double.parseDouble(price));
//        selectList.add(product);
        DataService dataService = new DataService();
        request.setAttribute("mapKey",dataService.getSelectPriceList("mapKey",request));

        doGet(request,response);




    }
}
