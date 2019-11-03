package com.jiutian.jiutian.resultVo;

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

    public static ResultVo setError(String message){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(400);
        resultVo.setData(message);
        resultVo.setMessage("error");
        return resultVo;
    }

}
