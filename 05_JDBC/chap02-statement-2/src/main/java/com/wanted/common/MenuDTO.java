package com.wanted.common;

public class MenuDTO {

    /* comment.
    *   DTO 기본 구성 요소
    *   1. 필드
    *   2. 기본 생성자
    *   3. 모든 필드를 초기화하는 생성자
    *   4. Getter, Setter
    *   5. ToString
     */

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private Integer refCategoryCode;
    private char orderableStatus;

    public MenuDTO(){
    }

    public MenuDTO(String menuName, int menuCode, int categoryCode, int menuPrice, Integer refCategoryCode, char orderableStatus) {
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.categoryCode = categoryCode;
        this.menuPrice = menuPrice;
        this.refCategoryCode = refCategoryCode;
        this.orderableStatus = orderableStatus;

    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public char getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(char orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", refCategoryCode=" + refCategoryCode +
                ", orderableStatus=" + orderableStatus +
                '}';
    }
}



