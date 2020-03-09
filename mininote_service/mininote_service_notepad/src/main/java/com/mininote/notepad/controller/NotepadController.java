package com.mininote.notepad.controller;

import com.mininote.notepad.pojo.Notepad;
import com.mininote.notepad.service.NotepadService;
import entity.Result;
import entity.StatusCode;
import entity.TokenDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 张某
 * @DATE 2020/2/27
 * @parent mininote_parent
 * @description com.mininote.notepad.controller
 */
@RestController
@RequestMapping("/notepad")
@CrossOrigin
public class NotepadController {

    @Autowired
    private NotepadService notepadService;
    /**
     * 增加笔记
     * @param notepad
     */
    @PostMapping
    public Result add(@RequestBody Notepad notepad){
        //1. 获取登入的用户名
        String username = TokenDecode.getUserInfo().get("username");
//        String username = "lisi";
        notepad.setUsername(username);
        //2. 保存
        notepadService.add(notepad);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改笔记
     * @param notepad
     */
    @PostMapping("/{id}")
    public Result update(@RequestBody Notepad notepad, @PathVariable Integer id){
        String username = TokenDecode.getUserInfo().get("username");
//        String username = "zhangsan";
        notepad.setUsername(username);
        notepad.setId(id);
        notepadService.update(notepad);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除笔记
     * @param id
     */
    @RequestMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        notepadService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 查询当前登入用户的所有笔记
     * @return
     */
    @GetMapping
    public Result<List<Notepad>> findAll(){
        String username = TokenDecode.getUserInfo().get("username");
//        String username = "zhangsan";
        List<Notepad> notepadList = notepadService.findAll(username);
        return new Result<List<Notepad>>(true, StatusCode.OK, "查询成功",notepadList);
    }

    /**
     * 关键字搜索笔记
     * @param key
     * @return
     */
    @RequestMapping(value = "/keywordSearch")
    public Result<List<Notepad>> keywordSearch(@RequestParam(required = false) String key){
        String username = TokenDecode.getUserInfo().get("username");
//        String username = "lisi";
        List<Notepad> notepadList = notepadService.keywordSearch(key,username);
        return new Result<List<Notepad>>(true, StatusCode.OK, "查询成功",notepadList);
    }

    /**
     * 页面默认显示10条最近查看的笔记
     * 查询: 最近修改的前10个
     * @return
     */
    @RequestMapping("/findByDate")
    public Result<List<Notepad>> findByDate(){
        String username = TokenDecode.getUserInfo().get("username");
//        String username = "lisi";
        List<Notepad> notepadList = notepadService.findByDate(username);
        return new Result<List<Notepad>>(true, StatusCode.OK, "查询成功",notepadList);
    }
}
