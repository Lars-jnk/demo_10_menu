/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.entity.content;

import de.lars.menu.entity.content.background.Background;
import de.lars.menu.entity.content.foreground.Foreground;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Tobias
 */
@Entity
@Table(name = "content")
public class Content implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 512)
    private String name;

    @ManyToOne
    @JoinColumn(name = "background")
    private Background background;

    @ManyToOne
    @JoinColumn(name = "foreground")
    private Foreground foreground;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public Foreground getForeground() {
        return foreground;
    }

    public void setForeground(Foreground foreground) {
        this.foreground = foreground;
    }
}
