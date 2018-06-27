package com.bupt.travel.mapper;


import com.bupt.travel.model.Note;
import com.bupt.travel.model.requestBean.NoteBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Mapper
public interface NoteMapper {
    /*插入备注*/
    @Insert("insert into note(title,id,content,img) values(#{title},#{id},#{content},#{img})")
    public int insertNote(Note note);

    /*查询备注*/
    @Select("select * from note where id = #{id}")
    public NoteBean selectNode(@Param("id") Integer id);

}
