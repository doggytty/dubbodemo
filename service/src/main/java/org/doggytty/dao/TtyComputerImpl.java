package org.doggytty.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.doggytty.dao.mapper.TtyComputerMapper;
import org.doggytty.models.TtyComputer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by doggy on 17-6-23.
 */
@Repository
public class TtyComputerImpl implements ITtyComputer {

    @Resource
    private TtyComputerMapper mapper;

    public int insert(TtyComputer ttyComputer) {
        return mapper.insert(ttyComputer);
    }

    public int delete(int id) {
        return mapper.delete(id);
    }

    public int update(TtyComputer ttyComputer) {
        return mapper.update(ttyComputer);
    }

    public TtyComputer query(int id) {
        return mapper.query(id);
    }

    public List<TtyComputer> list() {
        return mapper.list();
    }

    public PageInfo<TtyComputer> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TtyComputer> list = mapper.list();
        return new PageInfo(list);
    }
}
