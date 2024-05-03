package wokrspacewiz.workspacewiz.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface FindMapper {
    String findId(Map<String, String> map);
}
