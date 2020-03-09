package com.mininote.webnotepad.controller;

import com.mininote.notepad.feign.NotepadFeign;
import com.mininote.notepad.pojo.Notepad;
import entity.Result;
import entity.TokenDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 张某
 * @DATE 2020/2/29
 * @parent mininote_parent
 * @description com.mininote.webnotepad.controller
 */
@RestController
@RequestMapping("/webNotepad")
public class WebNotepadController {

    @Autowired
    private NotepadFeign notepadFeign;

    /**
     * 默认显示最近10条
     * @param model
     * @return
     */
    @RequestMapping("/findByDate")
    public Result<List<Notepad>> findByDate(Model model){
        Result<List<Notepad>> result = notepadFeign.findByDate();
//        model.addAttribute("result", result);
        return result;
    }

    /**
     * 删除
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id, Model model){
        Result result = notepadFeign.delete(id);
//        model.addAttribute("result", result);
        return result;
    }
    /**
     * 修改
     * @param model
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Notepad notepad,Model model){
        Result result = notepadFeign.update(notepad,notepad.getId());
//        model.addAttribute("result", result);
        return result;
    }
    /**
     * 保存
     * @param model
     * @return
     */
    @RequestMapping("/save")
    public Result save(@RequestBody Notepad notepad,Model model){
        Result result = notepadFeign.add(notepad);
//        model.addAttribute("result", result);
        return result;
    }
    /**
     * 关键字搜索
     * @param model
     * @return
     */
    @RequestMapping("/search")
    public Result<List<Notepad>> search(@RequestParam(value = "key", required = false) String key, Model model){
        Result<List<Notepad>> result = notepadFeign.keywordSearch(key);
//        model.addAttribute("result", result);
        return result;
    }
}
