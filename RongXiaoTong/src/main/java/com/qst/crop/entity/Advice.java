package com.qst.crop.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * tb_advice
 * @author 
 */
@Data
public class Advice implements Serializable {
    private String userName;

    private String advice;

    private String phonenumber;


    private static final long serialVersionUID = 1L;
}