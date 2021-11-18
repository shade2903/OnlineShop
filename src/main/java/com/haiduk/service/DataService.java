package com.haiduk.service;

import com.haiduk.domain.PriceList;
import com.haiduk.domain.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataService {
    private ArrayList<String> name;
    private ArrayList<Product> selectList;
    private ArrayList<Product> priceList;

    public ArrayList<Product> getSelectPriceList(String str, HttpServletRequest req){
        name =new ArrayList<>();
        selectList = new ArrayList<>();
        priceList = PriceList.getListProduct();

        for(String s : req.getParameterValues(str)){
          name.add(s);
        }
        for(int i= 0; i < name.size(); i++){
            for(Product x : priceList) {
                if ((x.getName()).equals(priceList.get(i).getName())) {
                    selectList.add(x);
                }
            }
        }
        return selectList;
    }

}
