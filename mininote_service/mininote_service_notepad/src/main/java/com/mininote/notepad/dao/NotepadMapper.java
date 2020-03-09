package com.mininote.notepad.dao;

import com.mininote.notepad.pojo.Notepad;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 张某
 * @DATE 2020/2/27
 * @parent mininote_parent
 * @description com.mininote.notepad.dao
 */
public interface NotepadMapper extends Mapper<Notepad> {

}
