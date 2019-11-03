package com.jiutian.jiutian.vo;

import lombok.Data;

@Data
public class ResultVo {
    private int code;
    private Object data;
    private String message;

    public static ResultVo setOk(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(200);
        resultVo.setData(data);
        resultVo.setMessage("success");
        return resultVo;
    }
    public static ResultVo setErro0r(String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(400);
        resultVo.setData(msg);
        resultVo.setMessage("error");
        return resultVo;
    }
}
