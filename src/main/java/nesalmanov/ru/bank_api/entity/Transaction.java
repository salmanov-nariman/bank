package nesalmanov.ru.bank_api.entity;


import jakarta.persistence.*;
import lombok.Data;
import nesalmanov.ru.bank_api.entity.enums.TransactionStatus;
import nesalmanov.ru.bank_api.entity.enums.TransactionType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "transfer_id")
    private Transfer transfer;

    private TransactionType type;
    private BigDecimal amount;
    private TransactionStatus status;

    @Column(name = "created_at")
    private Date createdAt;

}
