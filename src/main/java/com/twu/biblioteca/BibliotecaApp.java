package com.twu.biblioteca;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.*;

public class BibliotecaApp {


    private Menu menu;
    BibliotecaApp(){

    }


    public String checkoutItem(int productCode, List<? extends Product> products) throws NotAvailableProductException, InvalidProductCodeException {

        for(Product p: products){
            if(p.getCode().equals(productCode) && p.getStatus().equals("available")){
                p.setStatus("not available");
                return p.toString();
            } else {
                throw new NotAvailableProductException("The product "+p.getName()+" is not available!");
            }
        }
        throw new InvalidProductCodeException("Invalid Code!");
    }

    public String returnItem(int productCode, List<? extends Product> products) throws NotAvailableProductException, InvalidProductCodeException {

        for(Product p: products){
            if(p.getCode().equals(productCode) && p.getStatus().equals("not available")){
                p.setStatus("available");
                return p.toString();
            }
        }
        throw new InvalidProductCodeException("Invalid Code!");
    }




}
