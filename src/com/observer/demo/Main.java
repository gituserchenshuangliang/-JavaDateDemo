package com.observer.demo;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Main {
    public static void main(String[] args) {
        ProductList pro = ProductList.getInstance();
        
        //添加商家观察者
        pro.addObserver(new JingDongObserver());
        pro.addObserver(new TaoBaoObserver());
        
        //新增产品,通知到商家
        pro.addProduct("小米20note----4300￥");
    }

}

@SuppressWarnings("deprecation")
class JingDongObserver implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("发送新产品【"+ arg + "】到京东");
    }
}
@SuppressWarnings("deprecation")
class TaoBaoObserver implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("发送新产品【"+ arg + "】到淘宝");
    }
}