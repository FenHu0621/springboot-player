package com.lening.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.entity.Player;
import com.lening.mapper.PlayerMapper;
import com.lening.service.PlayerService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FenHu
 * Date: 2021/12/23
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Resource
    private PlayerMapper playerMapper;

    @Override
    public PageInfo<Player> selectAll(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Player> list = playerMapper.selectAll(name);
        PageInfo<Player> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void deleteById(Integer id) {
        playerMapper.deleteById(id);
    }

    @Override
    public List<Player> selectSchool() {
        return playerMapper.selectSchool();
    }

    @Override
    public List<Player> selectTeam() {
        return playerMapper.selectTeam();
    }

    @Override
    public void insertPlayer(Player player,HttpServletRequest request) {
        Player player1 = (Player) request.getSession().getAttribute("player");
        String url = player1.getUrl();
        player.setUrl(url);
        playerMapper.insertPlayer(player);
    }

    @Override
    public Player selectById(Integer id) {
        return playerMapper.selectById(id);
    }

    @Override
    public void updatePlayer(Player player,HttpServletRequest request) {
        Player player1 = (Player) request.getSession().getAttribute("player");
        String url = player1.getUrl();
        player.setUrl(url);
        playerMapper.updatePlayer(player);
    }

    @Override
    public void uploadFile(MultipartFile file, String realPath, HttpServletRequest request) {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
            String format = sdf.format(new Date());
            String imgAddress = "/imgs"+format+"/"+file.getOriginalFilename();
            realPath = realPath+imgAddress;
            File file1 = new File(realPath);
            if(!file1.exists()){
                file1.mkdirs();
            }
            file.transferTo(file1);
            Player player = new Player();
            player.setUrl(imgAddress);
            request.getSession().setAttribute("player",player);
            request.getSession().setAttribute("imgAddress",imgAddress);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
