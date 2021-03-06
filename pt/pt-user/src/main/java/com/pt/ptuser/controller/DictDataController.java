package com.pt.ptuser.controller;


import com.pt.ptcommon.util.R;
import com.pt.ptuser.service.SysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wl
 */
@RestController
@RequestMapping("/dict/data")
public class DictDataController {
    @Autowired
    private SysDictDataService sysDictDataService;

    @GetMapping("/dictType/{dictType}")
    public R getByDicType(@PathVariable String dictType){
        return R.ok(sysDictDataService.selectDictDataByType(dictType));
    }
}
