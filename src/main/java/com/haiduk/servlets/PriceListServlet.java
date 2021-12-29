package com.haiduk.servlets;


import com.haiduk.config.SpringContext;
import com.haiduk.domain.PriceList;
import com.haiduk.domain.Product;
import com.haiduk.service.DataService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//@WebServlet("/priceList")
public class PriceListServlet extends HttpServlet {
    private final static List<Product> listProduct = PriceList.getListProduct();
    private final static List<Product> clickList = new ArrayList<>();
    AnnotationConfigApplicationContext  context = SpringContext.getApplicationContext();
    DataService service = (DataService) context.getBean("dataService");


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/menu.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(req.getParameter("userName") != null){
            session.setAttribute("userName", req.getParameter("userName"));
        }
        req.setAttribute("products", listProduct);
        clickList.addAll(service.getSelect("mapKey",req));
        session.setAttribute("clickList", clickList);
        doGet(req,resp);


    }
}
