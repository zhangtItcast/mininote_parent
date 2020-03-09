package com.mininote.notepad.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mininote.notepad.dao.NotepadMapper;
import com.mininote.notepad.pojo.Notepad;
import com.mininote.notepad.service.NotepadService;
import entity.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author 张某
 * @DATE 2020/2/27
 * @parent mininote_parent
 * @description com.mininote.notepad.service.impl
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class NotepadServiceImpl implements NotepadService {

    @Autowired
    private NotepadMapper notepadMapper;

    /**
     * 添加
     * @param notepad
     */
    @Override
    public void add(Notepad notepad) {
        notepad.setCreateDate(new Date());// 创建时间
        notepad.setUpdateDate(notepad.getCreateDate());// 更新时间
        notepadMapper.insert(notepad);
    }

    /**
     * 修改
     * @param notepad
     */
    @Override
    public void update(Notepad notepad) {
        notepad.setUpdateDate(new Date());//修改更新时间
        notepadMapper.updateByPrimaryKeySelective(notepad);
    }

    /**
     * 删除, 根据id删除
     * @param id
     */
    @Override
    public void delete(Integer id) {
        notepadMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询所有: 登入用户
     * @param username
     * @return
     */
    @Override
    public List<Notepad> findAll(String username) {
        Notepad notepad = new Notepad();
        notepad.setUsername(username);
        return notepadMapper.select(notepad);
    }

    /**
     * 关键字搜索笔记
     * @param key
     * @return
     */
    @Override
    public List<Notepad> keywordSearch(String key, String username) {
        //1. 创建查询条件构建器
        Example example = new Example(Notepad.class);
        Example.Criteria criteria = example.createCriteria();
        //2. 构建查询条件
         if (StringUtils.isNotBlank(username)) {
             criteria.andEqualTo("username", username);
         }
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("context", "%"+key+"%");
            criteria.orLike("title", "%"+key+"%");
        }

        return notepadMapper.selectByExample(example);
    }

    /**
     * 页面默认显示10条最近查看的笔记
     * @return
     */
    @Override
    public List<Notepad> findByDate(String username) {
        //1. 创建查询条件构建器
        Example example = new Example(Notepad.class);
        Example.Criteria criteria = example.createCriteria();
        //2. 构建查询条件
        if (StringUtils.isNotBlank(username)) {
            criteria.andEqualTo("username", username);
        }
        RowBounds rowBounds = new RowBounds(0,10);
        return notepadMapper.selectByExampleAndRowBounds(example, rowBounds);
    }
}
