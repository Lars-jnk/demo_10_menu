/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.entity.element.background;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Tobias
 */
@Entity
@Table(name = "element_background")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BackgroundElement implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Size(max = 256)
    @Column(name = "intern_title")
    private String internTitle;

    @Column(name = "notice", columnDefinition = "TEXT")
    private String notice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInternTitle() {
        return internTitle;
    }

    public void setInternTitle(String internTitle) {
        this.internTitle = internTitle;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
