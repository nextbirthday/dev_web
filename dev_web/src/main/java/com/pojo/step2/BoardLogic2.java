package com.pojo.step2;

import java.util.List;
import java.util.Map;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardLogic2 {
    
    BoardDAO2 boardDAO2 = new BoardDAO2();
    
    public List<Map<String, Object>> boardList() {
        
        List<Map<String, Object>> boardList = boardDAO2.boardList();
        
        log.info( boardList );
        
        return boardList;
    }
    
}
