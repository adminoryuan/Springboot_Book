package com.example.day1.Dao;

import com.example.day1.Entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;


/**
 * @Repository
 * 注册到ioc 中 表示该类是一个dao 层的持久化类
 */
@Repository
public class ProductDao {
    public List<Product> GetProList(){
        List<Product> l=new LinkedList<>();
        l.add(new Product(1,"苹果手机",12));
        l.add(new Product(2,"菠萝手机",42));
        return l;
    }

}
