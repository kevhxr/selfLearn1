package indi.kevin.selfLearn1.chainModel;

import indi.kevin.selfLearn1.chainModel.Approvers.Ratify;

import java.util.List;

public class RealChain implements Ratify.Chain {

    public Request request;
    public List<Ratify> ratifies;
    public int index;

    public RealChain(List<Ratify> ratifies, Request request, int index){
        this.request = request;
        this.ratifies = ratifies;
        this.index = index;
    }

    @Override
    public Request request() {
        return request;
    }

    @Override
    public Result proceed(Request request) {
        Result proceedResult = null;
        if(ratifies.size() > index){
            RealChain realChain = new RealChain(ratifies,request,index+1);
            Ratify ratify = ratifies.get(index);
            proceedResult = ratify.deal(realChain);
        }
        return proceedResult;
    }
}
