package com.xxywebsite.model;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class PackageState {
    @JSONField(name = "package_state_id")
    private String packageStateId;

    @JSONField(name = "package_bar_code")
    private String packageBarcode;

    @JSONField(name = "waybill_code")
    private String waybillCode;

    @JSONField(name = "operator_user_id")
    private String operatorUserId;

    @JSONField(name = "operator_user")
    private String operatorUser;

    @JSONField(name = "operator_site_id")
    private String operatorSiteId;


    @JSONField(name = "operator_site")
    private String operatorSite;

    @JSONField(name = "state")
    private String state;

    @JSONField(name = "remark")
    private String remark;

    @JSONField(name = "create_time")
    private String createTime;

    @JSONField(name = "yn")
    private String yn;

    @JSONField(name = "first_time")
    private String firstTime;

}
