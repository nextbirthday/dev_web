package clone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionForward {
    /**
     * TRUE이면 sendRedirect(INSERT|UPDATE|DELETE) FALSE이면 forward(SELECT일 때)
     */
    private String  path;
    private boolean isRedirect;
}
