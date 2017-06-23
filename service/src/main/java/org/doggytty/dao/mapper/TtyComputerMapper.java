package org.doggytty.dao.mapper;

import org.apache.ibatis.annotations.Select;
import org.doggytty.models.TtyComputer;

import java.util.List;

/**
 * Created by doggy on 17-6-23.
 */
public interface TtyComputerMapper {

    int insert(TtyComputer ttyComputer);

    int delete(int id);

    int update(TtyComputer ttyComputer);

    TtyComputer query(int id);

    @Select("SELECT * FROM tty_computer")
    List<TtyComputer> list();

}
