package org.doggytty.dao;

import com.github.pagehelper.PageInfo;
import org.doggytty.models.TtyComputer;

import java.util.List;

/**
 * Created by doggy on 17-6-23.
 */
public interface ITtyComputer {

    int insert(TtyComputer ttyComputer);

    int delete(int id);

    int update(TtyComputer ttyComputer);

    TtyComputer query(int id);

    List<TtyComputer> list();

    PageInfo<TtyComputer> list(int pageNum, int pageSize);
}
