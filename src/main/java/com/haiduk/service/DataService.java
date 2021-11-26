package com.haiduk.service;

import com.haiduk.domain.PriceList;
import com.haiduk.domain.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataService {
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<Product> selectList = new ArrayList<>();
    private ArrayList<Product> priceList = PriceList.getListProduct();


    public ArrayList<Product> getSelectPriceList(String str, HttpServletRequest req){

        if(req.getParameterValues(str) != null) {

            for (String s : req.getParameterValues(str)) {
                name.add(s);
            }
            for (int i = 0; i < name.size(); i++) {
                for (Product x : priceList) {
                    if ((x.getName()).equals(name.get(i))) {
                        selectList.add(x);
                    }
                }
            }
            return selectList;
        }
        return null;
    }

    public ArrayList<Product> getSelect(String str, HttpServletRequest req) {
        if (req.getParameter(str) != null) {
            for (Product s : priceList) {
                if (s.getName().equals(req.getParameter(str))) {
                    selectList.add(s);
                }
            }
        }

        return selectList;

    }

}
