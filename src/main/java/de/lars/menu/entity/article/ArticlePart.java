/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.entity.article;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author syrinx
 */
@Entity
@Table(name = "article_part")/*, uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id", "position"})
})
*/
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ArticlePart implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "position")
    private int position;

    @ManyToOne(optional = false)
    private Article article;
}
