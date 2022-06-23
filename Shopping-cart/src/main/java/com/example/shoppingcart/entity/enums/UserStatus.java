package com.example.shoppingcart.entity.enums;



public enum UserStatus {
    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINED(-2);

    private int value;

    UserStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static UserStatus of(int value){
        for (UserStatus status :
                UserStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        return UserStatus.UNDEFINED;
    }
}
