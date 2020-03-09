package com.mininote.notepad.service;

import com.mininote.notepad.pojo.Notepad;

import java.util.List;

/**
 * @author 张某
 * @DATE 2020/2/27
 */
public interface NotepadService {
    /**
     * 增加笔记
     * @param notepad
     */
    void add(Notepad notepad);

    /**
     * 修改笔记
     * @param notepad
     */
    void update(Notepad notepad);

    /**
     * 删除笔记
     * @param id
     */
    void delete(Integer id);

    /**
     * 查询当前登入用户的所有笔记
     * @return
     */
    List<Notepad> findAll(String username);

    /**
     * 关键字搜索笔记
     * @param key
     * @return
     */
    List<Notepad> keywordSearch(String key, String username);

    /**
     * 页面默认显示10条最近查看的笔记
     * 查询: 最近修改的前10个
     * @return
     */
    List<Notepad> findByDate(String username);
}
