package com.lening.service;

import com.github.pagehelper.PageInfo;
import com.lening.entity.Player;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FenHu
 * Date: 2021/12/23
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
public interface PlayerService {
    PageInfo<Player> selectAll(String name, Integer pageNum, Integer pageSize);

    void deleteById(Integer id);

    List<Player> selectSchool();
    List<Player> selectTeam();

    void insertPlayer(Player player,HttpServletRequest request);

    Player selectById(Integer id);

    void updatePlayer(Player player,HttpServletRequest request);

    void uploadFile(MultipartFile file, String realPath, HttpServletRequest request);
}
