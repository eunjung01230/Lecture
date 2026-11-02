package com.wanted.jpaintro.section02;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/* comment.
    @Entity: JPA가 관리하는 하나의 객체라는 것을 명시
    @Table: 해당 엔티티 객체와 매핑이 될 테이블 이름을 지정
*/
@Entity
@Table(name = "tbl_menu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Menu {

    @Id
    @Column(name = "menu_code")
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private double menuPrice;

    /* comment.
        categoryCode 필드는 실제로는 Category 테이블의
        fk를 지칭한다.
        Java 객체로 해당 연관관계를 표현하는 방법은
        Category 엔티티를 Menu 엔티티에서 필드로 가지고 있으면 된다.
     */
    @ManyToOne
    @JoinColumn(name = "category_code")
    private Category categoryCode;

    @Column(name = "orderable_status")
    private String orderableStatus;

    public void changeMenuName(String s) {
        this.menuName = s;
    }
}