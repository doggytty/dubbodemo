package org.doggytty.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by doggy on 17-6-23.
 */
@Getter
@Setter
public class TtyComputer {
    private int id;
    private String name;
    private String alias;
    private Date createTime;
    private Date updateTime;
    private String os;
    private String bios;
    private String cpu;
    private String memory;
}
