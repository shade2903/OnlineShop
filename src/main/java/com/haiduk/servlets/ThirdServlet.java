package com.haiduk.servlets;

import com.haiduk.domain.PriceList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/totalPrice")
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/shopList.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> list = new ArrayList<>();

        for(String s : req.getParameterValues("mapKey")){
            System.out.println(s);
            list.add(s);
        }
        System.out.println(list.size());
        Map<String,Double> map = new HashMap<>();
        Map<String,Double> priceList = PriceList.getPRODUCTS();


        for(int i = 0; i <list.size(); i++){
            for(Map.Entry<String,Double> key: priceList.entrySet()){
                if((key.getKey()).equals(list.get(i))){
                    map.put(key.getKey(),key.getValue());

                }
            }
        }

        req.setAttribute("data",map);



//        System.out.println(name);



        doGet(req,resp);



    }
}
