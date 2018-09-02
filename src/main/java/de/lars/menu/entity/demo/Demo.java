/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.entity.demo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author syrinx
 */
@Entity
@Table(name = "demo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demo.findAll", query = "SELECT d FROM Demo d")
    , @NamedQuery(name = "Demo.findByIdDemo", query = "SELECT d FROM Demo d WHERE d.idDemo = :idDemo")
    , @NamedQuery(name = "Demo.findByDemocol", query = "SELECT d FROM Demo d WHERE d.democol = :democol")
    , @NamedQuery(name = "Demo.findByDemocol1", query = "SELECT d FROM Demo d WHERE d.democol1 = :democol1")})
public class Demo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idDemo")
    private Integer idDemo;
    @Size(max = 45)
    @Column(name = "Democol")
    private String democol;
    @Size(max = 45)
    @Column(name = "Democol1")
    private String democol1;

    private int test;

    public Demo() {
    }

    public Demo(Integer idDemo) {
        this.idDemo = idDemo;
    }

    public Demo(String demoCol, String demoCol1) {
        this.democol = demoCol;
        this.democol1 = demoCol1;
    }

    public Integer getIdDemo() {
        return idDemo;
    }

    public void setIdDemo(Integer idDemo) {
        this.idDemo = idDemo;
    }

    public String getDemocol() {
        return democol;
    }

    public void setDemocol(String democol) {
        this.democol = democol;
    }

    public String getDemocol1() {
        return democol1;
    }

    public void setDemocol1(String democol1) {
        this.democol1 = democol1;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDemo != null ? idDemo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demo)) {
            return false;
        }
        Demo other = (Demo) object;
        if ((this.idDemo == null && other.idDemo != null) || (this.idDemo != null && !this.idDemo.equals(other.idDemo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.lars.menu.entity.Demo[ idDemo=" + idDemo + " ]";
    }

}
