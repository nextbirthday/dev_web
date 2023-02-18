<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!int x = 1;
    
    private String showDisplay( String[] cafeMenu ) {
        
        StringBuilder stringBuilder = new StringBuilder();
        
        for ( int i = 0; i < cafeMenu.length; i++ ) {
            
            if ( i == ( x - 1 ) ) {
                stringBuilder.append( "<table width='500px' border='1'>" );
                stringBuilder.append( "<tr><td>" + cafeMenu[x - 1] + "</td></tr>" );
                stringBuilder.append( "</table>" );
            }
        }
        
        String showOnDisplay = stringBuilder.toString();
        return showOnDisplay;
    }%>


<%
String[] cafeMenu = { "Americano(hot/iced)", "Latte(hot/iced)", "Soy latte(only hot)", "Cold brew", "mint tea", "black tea" };

String show = "";
System.out.println( "cml ===> " + x );
switch ( x ) {
    
    case 1:
        show = showDisplay( cafeMenu );
        
        x++;
        break;
    case 2:
        show = showDisplay( cafeMenu );
        x++;
        break;
    case 3:
        show = showDisplay( cafeMenu );
        x++;
        break;
    case 4:
        show = showDisplay( cafeMenu );
        x++;
        break;
    case 5:
        show = showDisplay( cafeMenu );
        x++;
        break;
    case 6:
        show = showDisplay( cafeMenu );
        x = 1;
        break;
}

out.clear();
out.print( show );
%>