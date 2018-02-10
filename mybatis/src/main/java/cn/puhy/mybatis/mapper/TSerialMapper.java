package cn.puhy.mybatis.mapper;

import cn.puhy.mybatis.model.TSerial;

public interface TSerialMapper {
	
	int update(TSerial tSerial);
	TSerial query(Integer id);
}
