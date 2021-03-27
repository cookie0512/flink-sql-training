package com.xxywebsite.helper;

import com.xxywebsite.model.PackageState;

import java.util.Random;

public class PackageStateMockHelper {
    public static PackageState mock() {
        PackageState packageState = new PackageState();
        Random random = new Random();

        int randInt = random.nextInt(1000);
        packageState.setPackageStateId("package_state_" + randInt);

        randInt = random.nextInt(1000);
        packageState.setPackageBarcode("package_barcode_" + randInt);

        randInt = random.nextInt(1000);
        packageState.setWaybillCode("waybill_code_" + randInt);

        randInt = random.nextInt(100);
        packageState.setOperatorUserId("operator_user_id_" + randInt);

        randInt = random.nextInt(100);
        packageState.setOperatorUser("operator_user_" + randInt);

        randInt = random.nextInt(1000);
        packageState.setOperatorSiteId("operator_site_id_" + randInt);

        randInt = random.nextInt(1000);
        packageState.setOperatorSite("operator_site_" + randInt);

        randInt = random.nextInt(10);
        packageState.setState("state_" + randInt);

        randInt = random.nextInt(1000);
        packageState.setRemark("remark_" + randInt);

//        randInt = random.nextInt(1000);
        packageState.setCreateTime(String.valueOf(System.currentTimeMillis()));

        randInt = random.nextInt(2);
        packageState.setYn("yn_" + randInt);

//        randInt = random.nextInt(1000);
        packageState.setFirstTime(String.valueOf(System.currentTimeMillis()));

        return packageState;
    }
}
