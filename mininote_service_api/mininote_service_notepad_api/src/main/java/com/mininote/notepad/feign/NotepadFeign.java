package com.mininote.notepad.feign;

import com.mininote.notepad.pojo.Notepad;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 张某
 * @DATE 2020/2/29
 */
@FeignClient(name = "notepad")
@RequestMapping("/notepad")
public interface NotepadFeign {
    /**
     * 增加笔记
     * @param notepad
     */
    @PostMapping
    public Result add(@RequestBody Notepad notepad);
    /**
     * 修改笔记
     * @param notepad
     */
    @PostMapping("/{id}")
    public Result update(@RequestBody Notepad notepad, @PathVariable Integer id);
    /**
     * 删除笔记
     * @param id
     */
    @RequestMapping("/{id}")
    public Result delete(@PathVariable Integer id);
    /**
     * 查询当前登入用户的所有笔记
     * @return
     */
    @GetMapping
    public Result<List<Notepad>> findAll();

    /**
     * 关键字搜索笔记
     * @param key
     * @return
     */
    @RequestMapping(value = "/keywordSearch")
    public Result<List<Notepad>> keywordSearch(@RequestParam(required = false) String key);

    /**
     * 页面默认显示10条最近查看的笔记
     * 查询: 最近修改的前10个
     * @return
     */
    @RequestMapping("/findByDate")
    public Result<List<Notepad>> findByDate();
}
