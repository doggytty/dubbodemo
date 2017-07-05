package org.doggytty.utils;

import org.apache.commons.lang3.StringUtils;
import org.doggytty.enums.OSEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunlichuan on 17-7-4.
 */
public class IdNoUtils {

    /**
     * 根据身份证号码结束时间、出生日期获取身份证起始时间
     * @param idNo
     * @param idNoEndTime
     * @return
     */
    public static String getIdNoBeginTime(String idNo, String idNoEndTime) {
        if (StringUtils.isBlank(idNoEndTime) || StringUtils.isBlank(idNo)) {
            throw new IllegalArgumentException("参数不能为空!");
        }
        // todo 长度>4,前4位必须为数字
        int timeLen = idNoEndTime.length();
        if (timeLen < 4) {
            throw new IllegalArgumentException("身份证有效期格式错误!");
        }
        // todo 长度=18，前17位必须为数字，最后以为x1-9
        int noLen = idNo.length();
        if (noLen != 18) {
            throw new IllegalArgumentException("身份证号码格式错误!");
        }
        // 46周岁及以上申请身份证时，为长期身份证，传入的参数格式:2007.12.18-长期。格式待确认
        if (StringUtils.contains(idNoEndTime, "长期")) {
            return idNoEndTime.substring(0, timeLen-3);
        }
        // 获取出生年份   460022198703110338 ==> 1987
        int birthYear = Integer.parseInt(idNo.substring(6, 10));
        // 获取结束时间年份 2035-10-04 ==> 2035
        int endTimeYear = Integer.parseInt(idNoEndTime.substring(0, 4));
        int diffYear = endTimeYear - birthYear;
        if (diffYear >= 46 && diffYear <= 65) {
            // 有效期20年   26周岁--45周岁
            return String.format("%d%s", endTimeYear - 20, idNoEndTime.substring(4));
        } else if (diffYear >= 26 && diffYear <= 35) {
            // 有效期10年   16周岁--25周岁
            return String.format("%d%s", endTimeYear - 10, idNoEndTime.substring(4));
        } else {//else if (diffYear <= 20)
            //有效期5年
            return String.format("%d%s", endTimeYear - 5, idNoEndTime.substring(4));
        }
        //throw  new IllegalArgumentException("计算错误，请确认传入参数是否正确");
    }

    public static void main(String[] args) {
        String idNo = "511322199410128733";
        String idNoEndTime = "2023-07-08";
        String idNoBeginTime = IdNoUtils.getIdNoBeginTime(idNo, idNoEndTime);
        System.out.println(idNoBeginTime);

        Double tmp = null;
        System.out.println(tmp);
        Map<String, Object> tmpMap = new HashMap<String, Object>();
        tmp = (Double)tmpMap.get("askdfasd");
        System.out.println(tmp);

        OSEnum osEnum = OSEnum.valueOf("linux");
        System.out.println(osEnum);
    }

}
