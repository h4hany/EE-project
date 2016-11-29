/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.education.services.generic;

import javax.ejb.Local;

/**
 *
 * @author mohamedk
 */
@Local
public interface ValidatorLocal {

    public boolean isNull(String s);

    public boolean length(String s, int len);

    public boolean isInt(String s);

    public boolean intRange(String i, int min, int max);

    public boolean isEmail(String s);

    public boolean isPhone(String s);


}
