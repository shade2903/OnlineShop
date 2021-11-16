package com.haiduk.service;

import com.haiduk.domain.PriceList;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataService {
    private ArrayList<String> listKeys;
    private HashMap<String,Double> selectPriceList;
    private Map<String,Double> priceList;

    public HashMap<String,Double> getSelectPriceList(String str, HttpServletRequest req){
        listKeys = new ArrayList<>();
        priceList = PriceList.getPRODUCTS();
        selectPriceList = new HashMap<>();
        for(String s : req.getParameterValues(str)){
            listKeys.add(s);
        }
        for(int i= 0; i < listKeys.size(); i++){
            for(Map.Entry<String,Double> key : priceList.entrySet()){
                if((key.getKey()).equals(listKeys.get(i))){
                    selectPriceList.put(key.getKey(),key.getValue());
                }
            }
        }
        return selectPriceList;
    }

}
