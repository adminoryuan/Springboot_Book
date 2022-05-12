package com.example.day1.Service;

import com.example.day1.Dao.ProductDao;
import com.example.day1.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标志该类为server层的组件
 */
@Service
public class ProductServer {

    @Autowired
    /**
     * 注入ProductDao
     */
    private ProductDao _dao;

//    setter注入方式
//    @Autowired
//    public void setProductDao(ProductDao dao){
//        _dao=dao;
//    }

    public List<Product> Getall(){

        return _dao.GetProList();
    }
}
