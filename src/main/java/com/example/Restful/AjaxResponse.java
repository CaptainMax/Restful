package com.example.Restful;

import lombok.Data;

@Data
public class AjaxResponse {
    private boolean isok;
    private int code; //200, 400, 500
    private String message;
    private Object data;


    public AjaxResponse(){}

    //default response for success 200
    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("request successes");
        return ajaxResponse;
    }

    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("request successes");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    public static AjaxResponse success(Object obj, String message){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

}
