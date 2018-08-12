package indi.kevin.selfLearn1.chainModel;

public class Result {
    public boolean isRatify;
    public String reason;

    public Result( boolean isRatify, String reason){
        super();
        this.isRatify = isRatify;
        this.reason = reason;
    }

    public boolean isRatify(){
        return isRatify;
    }

    public void setRatify(boolean isRatify){
        this.isRatify = isRatify;
    }

    public String getReason(){
        return reason;
    }

    public void setReason(String info){
        this.reason = reason;
    }

    @Override
    public String toString(){
        return "Result [isRatify=" + isRatify + ", info=" + reason + "]";
    }
}
