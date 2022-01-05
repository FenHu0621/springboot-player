package com.lening.mapper;

import com.lening.entity.Player;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FenHu
 * Date: 2021/12/23
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
public interface PlayerMapper {
    List<Player> selectAll(String name);

    void deleteById(Integer id);

    List<Player> selectSchool();
    List<Player> selectTeam();

    void insertPlayer(Player player);

    Player selectById(Integer id);

    void updatePlayer(Player player);

}
