package com.twu.biblioteca;

import java.util.List;

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

    public void print(List<? extends Product> products) {

        for (Product p : products) {
            if(p.getStatus().equals("available")){
                System.out.println(p.toString());
            }

        }

    }

    public String getProductDetails(int productCode, List<? extends Product> products) throws InvalidProductCodeException {

        for(Product p: products){
            if(p.getCode().equals(productCode)){

                return p.toString();
            }

        }

        throw new InvalidProductCodeException("Invalid Code!");
    }

};


