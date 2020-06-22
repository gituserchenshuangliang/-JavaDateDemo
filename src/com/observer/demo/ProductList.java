package com.observer.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
/**
 * 观察者设计模式
 * @author Cherry
 * 2020年5月28日
 */
@SuppressWarnings("deprecation")
public class ProductList extends Observable {
    private List<String> list = null; //产品列表
    private static ProductList instance;//产品单例
    
    private ProductList() {}
    
    //获取单例
    public static ProductList getInstance() {
        if(instance == null) {
            instance = new ProductList();
            instance.list = new ArrayList<String>(10);
        }
        return instance;
    }
    
    //添加观察者
    public void addProductObserver(Observer observer) {
        this.addObserver(observer);
    }
    
    //添加产品
    public void addProduct(String p) {
        list.add(p);
        System.out.println("添加产品"+p);
        
        //试着被观察者对象变化
        this.setChanged();
        //通知观察者，传递新产品
        this.notifyObservers(p);
    }
}
