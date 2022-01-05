package com.lening.controller;

import com.github.pagehelper.PageInfo;
import com.lening.entity.Player;
import com.lening.service.PlayerService;
import com.lening.utils.FileInfo;
import com.lening.utils.ResultInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FenHu
 * Date: 2021/12/23
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/player")
public class PlayerController {
    @Resource
    private PlayerService playerService;

    @RequestMapping("/selectAll")
    public PageInfo selectAll(@RequestBody Player player,
                              @RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "3") Integer pageSize){
        String name = player.getName();
        PageInfo<Player> pageInfo = playerService.selectAll(name, pageNum, pageSize);
        return pageInfo;
    }


    @RequestMapping("/deleteById")
    public ResultInfo deleteById(Integer id){
        try {
            playerService.deleteById(id);
            return new ResultInfo(true,"删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultInfo(false,"删除失败！");
        }
    }

    @RequestMapping("/selectSchool")
    public List<Player> selectSchool(){
       return playerService.selectSchool();
    }

    @RequestMapping("/selectTeam")
    public List<Player> selectTeam(){
        return playerService.selectTeam();
    }

    @RequestMapping("/insertPlayer")
    public ResultInfo insertPlayer(@RequestBody Player player,HttpServletRequest request){
        try {
            playerService.insertPlayer(player,request);
            return new ResultInfo(true,"添加成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultInfo(false,"添加失败！");
        }
    }

    @RequestMapping("/selectById")
    public Player selectById(HttpServletRequest request){
        Integer id = (Integer) request.getSession().getAttribute("id");
        Player player = playerService.selectById(id);
        return player;
    }

    @RequestMapping("/updatePlayer")
    public ResultInfo updatePlayer(@RequestBody Player player,HttpServletRequest request){
        try {
            playerService.updatePlayer(player,request);
            return new ResultInfo(true,"修改成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultInfo(false,"修改失败！");
        }
    }

    @RequestMapping("/fileUpload")
    public FileInfo fileUpload(MultipartFile file, HttpServletRequest request){
        try {
            String realPath = request.getServletContext().getRealPath("/");
            playerService.uploadFile(file,realPath,request);
            String imgAddress = (String) request.getSession().getAttribute("imgAddress");
            return new FileInfo(true,"上传成功！",imgAddress);
        }catch (Exception e){
            e.printStackTrace();
            return new FileInfo(false,"上传失败！",null);
        }
    }

}
