package cn.eeepay.app.entity;

/**
 * Created by xqf on 201703.
 *
 */
public class HttpResult<T> {

    private String resp;
    private String errorMsg;
    private int errorCode;

    //用来模仿Data
    private T subjects;

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("resp=" + resp + " msg=" + errorMsg + " errorcode=" + errorCode);
        if (null != subjects) {
            sb.append(" subjects:" + subjects.toString());
        }
        return sb.toString();
    }
}
