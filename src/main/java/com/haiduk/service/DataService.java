package com.haiduk.service;

import com.haiduk.domain.PriceList;
import com.haiduk.domain.Product;
import com.haiduk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class DataService {
    @Autowired
    private ProductRepository productRepository;
    private List<String> name;
    private List<Product> selectList;
    private List<Product> priceList = productRepository.getAll();


    public List<Product> getSelectPriceList(String str, HttpServletRequest req){
        name = new ArrayList<>();
        selectList = new ArrayList<>();


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

    public List<Product> getSelect(String str, HttpServletRequest req) {
        selectList = new ArrayList<>();
        if (req.getParameter(str) != null) {
            for (Product s : priceList) {
                if (s.getName().equals(req.getParameter(str))) {
                    selectList.add(s);
                }
            }
        }

        return selectList;
    }

        public List<Product> getSelect(String str) {
            selectList = new ArrayList<>();
            if (str != null) {
                for (Product s : priceList) {
                    if (s.getName().equals(str)) {
                        selectList.add(s);
                    }
                }
            }

            return selectList;

    }
    public List<Product> getSelectBasket(String[] str){
        name = new ArrayList<>();
        selectList = new ArrayList<>();


        if(str != null) {

            for (String s : str) {
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


}
