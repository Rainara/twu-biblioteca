package com.twu.biblioteca;

public abstract class Product {

    private Integer code;
    private String name;
    private Integer year;
    private String status;



    public Product(Integer code, String name, Integer year, String status) {
        this.code = code;
        this.name = name;
        this.year = year;
        this.status = status;
    }

//    public abstract boolean print();

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", status='" + status + '\''
                ;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status=status;
    }


    public String getName() {
        return name;
    }
};


