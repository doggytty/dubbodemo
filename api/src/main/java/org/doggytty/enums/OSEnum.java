package org.doggytty.enums;

import lombok.Getter;

/**
 * Created by doggy on 17-7-5.
 */
@Getter
public enum OSEnum {

    WINDOWS("window"),
    OSX("macos"),
    UBUNTU("ubuntu"),
    REDHAT("redhat"),
    ;
    private String name;
    OSEnum(String name) {
        this.name = name;
    }
}
