package com.book.scope;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Sonata {
    public String carName  = "2023년형 소나타";
    public int    speed    = 10;
    public int    wheelNum = 4;
    
    public Sonata() {
        // 10, 2023년형 소나타, 4
        log.info( "default Constructor" );
    }
    
    public Sonata( int speed ) {
        log.info( "int speed Constructor" );
        this.speed = speed;
    }
    
    public Sonata( int speed, String carName ) {
        this.speed = speed;
        this.carName = carName;
    }
    
    public Sonata( int speed, int wheelNum, String carName ) {
        this.speed = speed;
        this.wheelNum = wheelNum;
        this.carName = carName;
    }
    
}
