package com.dbms.team15.models;

public class Coffee {

    private String COF_NAME;
	private int SUP_ID;
    private float PRICE;
    private int SALES;
    private int TOTAL;

    public Coffee() {
    }

    // Create constructor and getters
    public Coffee(String COF_NAME, int SUP_ID, float PRICE, int SALES, int TOTAL) {
        this.COF_NAME = COF_NAME;
        this.SUP_ID = SUP_ID;
        this.PRICE = PRICE;
        this.SALES = SALES;
        this.TOTAL = TOTAL;
    }

    public String getCOF_NAME() {
        return COF_NAME;
    }

    public void setCOF_NAME(String COF_NAME) {
        this.COF_NAME = COF_NAME;
    }

    public int getSUP_ID() {
        return SUP_ID;
    }

    public void setSUP_ID(int SUP_ID) {
        this.SUP_ID = SUP_ID;
    }

    public float getPRICE() {
        return PRICE;
    }

    public void setPRICE(float PRICE) {
        this.PRICE = PRICE;
    }

    public int getSALES() {
        return SALES;
    }

    public void setSALES(int SALES) {
        this.SALES = SALES;
    }

    public int getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(int TOTAL) {
        this.TOTAL = TOTAL;
    }

    @Override
    public String toString() {
        return "Coffee [COF_NAME=" + COF_NAME + ", PRICE=" + PRICE + ", SALES=" + SALES + ", SUP_ID=" + SUP_ID + ", TOTAL="
                + TOTAL + "]";
    }



}
