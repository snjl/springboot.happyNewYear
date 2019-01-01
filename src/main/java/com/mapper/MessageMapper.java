package com.mapper;

import com.model.Message;
import com.model.MessageExample;
import com.model.MessageWithBLOBs;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@ResponseBody
@Mapper
public interface MessageMapper {
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    @Delete({
        "delete from message",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into message (id, name, ",
        "email, date, status, ",
        "title, message)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{date,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT}, ",
        "#{title,jdbcType=LONGVARCHAR}, #{message,jdbcType=LONGVARCHAR})"
    })
    int insert(MessageWithBLOBs record);

    int insertSelective(MessageWithBLOBs record);

    List<MessageWithBLOBs> selectByExampleWithBLOBs(MessageExample example);

    List<Message> selectByExample(MessageExample example);

    @Select({
        "select",
        "id, name, email, date, status, title, message",
        "from message",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mapper.MessageMapper.ResultMapWithBLOBs")
    MessageWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageWithBLOBs record, @Param("example") MessageExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageWithBLOBs record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(MessageWithBLOBs record);

    @Update({
        "update message",
        "set name = #{name,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "title = #{title,jdbcType=LONGVARCHAR},",
          "message = #{message,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(MessageWithBLOBs record);

    @Update({
        "update message",
        "set name = #{name,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Message record);
}