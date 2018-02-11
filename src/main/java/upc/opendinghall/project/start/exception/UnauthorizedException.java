package upc.opendinghall.project.start.exception;

/**
 * @author liliangbin dumpling1520@gmail.com
 * @date 2018/2/11  23:17
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}