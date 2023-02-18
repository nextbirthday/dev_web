package dept.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Dept {
    
    public Dept() {}
    
    private int    deptno;
    private String dname;
    private String loc;
}
