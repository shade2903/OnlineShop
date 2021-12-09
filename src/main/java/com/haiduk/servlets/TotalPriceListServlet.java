package com.haiduk.servlets;
import com.haiduk.config.SpringConfig;
import com.haiduk.service.DataService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/totalPriceList")
public class TotalPriceListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/jsp/shoppingList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnnotationConfigApplicationContext context = SpringConfig.getApplicationContext();
        DataService service = (DataService) context.getBean("dataService");
        req.getSession().setAttribute("selectList", service.getSelectPriceList("selectList",req));
        doGet(req, resp);

    }
}
