package com.backend.springbootdeveloper.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); //클래스 레벨에 올라가기 때문에 1개밖에 존재할 수 없다.
    public static SingletonService getInstance(){
        return instance;
    }
    private SingletonService(){
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
