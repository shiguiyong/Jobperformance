package com.xiuxiu.mapper;

import com.xiuxiu.pojo.Visitorvolume;
import com.xiuxiu.pojo.VisitorvolumeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VisitorvolumeMapper {
    int countByExample(VisitorvolumeExample example);

    int deleteByExample(VisitorvolumeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Visitorvolume record);

    int insertSelective(Visitorvolume record);

    List<Visitorvolume> selectByExample(VisitorvolumeExample example);

    Visitorvolume selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Visitorvolume record, @Param("example") VisitorvolumeExample example);

    int updateByExample(@Param("record") Visitorvolume record, @Param("example") VisitorvolumeExample example);

    int updateByPrimaryKeySelective(Visitorvolume record);

    int updateByPrimaryKey(Visitorvolume record);

    List<Visitorvolume> getVisitorvolume(@Param("volume")Visitorvolume volume);
}