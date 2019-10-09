package cn.puhy.mybatisgenerator.mapper;

import cn.puhy.mybatisgenerator.model.GeneratorTest;

public interface GeneratorTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GeneratorTest record);

    int insertSelective(GeneratorTest record);

    GeneratorTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GeneratorTest record);

    int updateByPrimaryKey(GeneratorTest record);
}