package com.spring.sevice.derivative.controller;

import com.spring.sevice.derivative.dao.DerivativeDAO;
import com.spring.sevice.derivative.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//trả về API
@RestController
public class DerivativeController {

    //inject service
    @Autowired
    private DerivativeDAO derivativeDAO;

    //trả về model list data
    @RequestMapping(value = "/loc/derivative",method = RequestMethod.GET, produces = "application/json")
    public Data loadDerivative(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "20") Integer size,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "q", required = false) String q){
        int te = derivativeDAO.getTotalElements();
        int tp = derivativeDAO.getTotalPage();
        Data dt = new Data();
        dt.setData(derivativeDAO.list(page, size, sort, q));
        dt.setSize(size);
        dt.setCurrentPage(page);
        dt.setTotalElements(te);
        dt.setTotalPages(tp);
        return dt;
    }

}
