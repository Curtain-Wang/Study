package com.study.service.business.oraDB;

import com.study.core.algorithm.BjjlGdsz;
import com.study.core.base.bean.ResponseResult;
import com.study.core.util.MapUtil;
import com.study.dal.mapper.DbFieldInfoMapper;
import com.study.service.api.oraDB.DbFieldInfoService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ：Curtain
 * @date ：Created in 2020/8/5 10:47
 * @description：TODO
 */
@Service
public class DbFieldInfoServiceImpl implements DbFieldInfoService {

    @Resource
    private DbFieldInfoMapper dbFieldInfoMapper;

    @Override
    public ResponseResult getMostFieldInfo(String inputComments) {
        List<Map<String,String>> allFieldList = dbFieldInfoMapper.getAllFieldInfo();
        List<Map<String,String>> mostLikeList = new ArrayList<>();
        for (int i = 0; i < allFieldList.size(); i++){
            Map<String,String> map = allFieldList.get(i);
            if (StringUtil.isNotEmpty(map.get("COMMENTS"))){
                int bjjl = BjjlGdsz.getBjjl(inputComments, map.get("COMMENTS"));
                if (bjjl < 5){
                    map.put("bjjl", String.valueOf(bjjl));
                    mostLikeList.add(map);
                }
            }
        }
        MapUtil.mapListSort(mostLikeList, "bjjl", true);
        return new ResponseResult(mostLikeList);
    }
}
