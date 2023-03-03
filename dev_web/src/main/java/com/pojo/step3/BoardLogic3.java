package com.pojo.step3;

import java.util.List;
import java.util.Map;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardLogic3 {
    
    BoardDAO3 boardDAO3 = new BoardDAO3();
    
    public List<Map<String, Object>> boardList() {
        log.info( "boardList" );
        List<Map<String, Object>> boardList = boardDAO3.boardList();
        return null;
    }
    
}
