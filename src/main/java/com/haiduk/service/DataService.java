package com.haiduk.service;

import com.haiduk.domain.Product;
import com.haiduk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class DataService {
    @Autowired
    private ProductRepository productRepository;
    private List<String> name;
    private List<Product> selectList;
    private List<Product> priceList = productRepository.getAll();



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
