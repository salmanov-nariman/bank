package nesalmanov.ru.bank_api.entity;


import jakarta.persistence.*;
import lombok.Data;
import nesalmanov.ru.bank_api.entity.enums.AccountStatus;
import nesalmanov.ru.bank_api.entity.enums.Currency;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    private Currency currency;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

}
