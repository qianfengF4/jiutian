package com.jiutian.jiutian.service;

import com.jiutian.jiutian.resultVo.ResultVo;

public interface MenuService {
    ResultVo queryMenu();

    ResultVo select(int id);
}
