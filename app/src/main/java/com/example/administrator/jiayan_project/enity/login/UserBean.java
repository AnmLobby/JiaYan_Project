package com.example.administrator.jiayan_project.enity.login;

/**
 * Created by 鱼握拳 on 2018/4/27.
 */

public class UserBean {

    /**
     * reason : 操作成功
     * result : {"sid":"180528173546103011100002","fee":1,"count":1}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * sid : 180528173546103011100002
         * fee : 1
         * count : 1
         */

        private String sid;
        private int fee;
        private int count;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
