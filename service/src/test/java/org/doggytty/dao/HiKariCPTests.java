package org.doggytty.dao;

import com.github.pagehelper.PageInfo;
import org.doggytty.models.TtyComputer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by doggy on 17-6-23.
 */
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class HiKariCPTests {

    @Autowired
    private ITtyComputer dao;

    @Test
    public void insert() {
        TtyComputer ttyComputer = new TtyComputer();
        ttyComputer.setName("doggytty-laptop");
        ttyComputer.setAlias("doggytty-laptop");
        ttyComputer.setBios("AUSU 1.75");
        ttyComputer.setCpu("core i7");
        ttyComputer.setMemory("8G");
        ttyComputer.setOs("Ubuntu amd64");
        ttyComputer.setCreateTime(new Date());
        ttyComputer.setUpdateTime(new Date());

        int id = dao.insert(ttyComputer);
        assert id > 0;
        System.out.println(id);
    }

    @Test
    public void delete() {

    }
    @Test
    public void update() {


    }
    @Test
    public void query() {

    }


    @Test
    public void list() {
        int pageNum = 1;
        int pageSize = 2;
        PageInfo<TtyComputer> pageInfo = dao.list(pageNum, pageSize);
//        assert pageInfo.getPageNum() == 2;
        for (TtyComputer tty : pageInfo.getList()) {
            System.out.println(tty.getId());
        }
    }
}
