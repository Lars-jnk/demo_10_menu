/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.entity.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

/**
 *
 * @author syrinx
 */
@Entity
public class BetterStaff extends AbsStaff {

    @Size(max = 45)
    @Column(name = "bessere")
    private String haha;
    
    
}
