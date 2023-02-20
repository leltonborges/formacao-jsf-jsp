package br.com.jpa.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "TB_ACCOUNT")
@Getter
@Setter
@ToString

@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class Account implements Serializable {
    private static final long serialVersionUID = -8333860214295451835L;

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACCOUNT")
//    @SequenceGenerator(name = "SQ_ACCOUNT", allocationSize = 1, initialValue = 1)
    @GenericGenerator(name = "SQ_ACCOUNT", strategy = "br.com.jpa.sequence.SequenceAccount")
    @GeneratedValue(generator = "SQ_ACCOUNT")
    @Column(name = "SEQ_ACCOUNT", unique = true, nullable = false)
    private Long id;
    @Column(name = "AGENCY_ACCOUNT",nullable = false)
    private Integer agency;
    @Column(name="NUMBER_ACCOUNT",nullable = false)
    private Integer numberAccount;
    @Column(name = "OWNER_ACCOUNT",nullable = false)
    private String owner;
    @Column(name = "BALANCE_ACCOUNT")
    private BigDecimal balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return id != null && Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
