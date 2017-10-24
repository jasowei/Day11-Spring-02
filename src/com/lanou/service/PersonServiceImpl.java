package com.lanou.service;

import com.lanou.dao.PersonDaoImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/24.
 */


@Service("personService")
public class PersonServiceImpl {
    /*按照名称装载, 默认不指定具体名称时按属性名搜索
    * 如果使用Resource注解完成属性装载时建议不要指定name
    * 但是如果使用AutoWired建议与Qualifier一起搭配使用*/
    @Resource
    private PersonDaoImpl dao;

    public boolean login(String name, String pwd){
        return dao.login(name,pwd);
    }
}
