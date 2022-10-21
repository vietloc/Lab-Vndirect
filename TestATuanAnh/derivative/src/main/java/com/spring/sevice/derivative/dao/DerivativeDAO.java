package com.spring.sevice.derivative.dao;

import com.spring.sevice.derivative.model.Derivative;

import java.util.List;

public interface DerivativeDAO {
    List<Derivative> list(int page, Integer size,String sort, String q);
//    Derivative get(String deri_composite_code);

    int getTotalPage();
    int getTotalElements();

//    List<Derivative> listForEle();
}
