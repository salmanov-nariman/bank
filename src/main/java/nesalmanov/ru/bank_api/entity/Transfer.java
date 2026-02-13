package nesalmanov.ru.bank_api.entity;


import jakarta.persistence.*;
import lombok.Data;
import nesalmanov.ru.bank_api.entity.enums.TransactionStatus;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account toAccount;

    @Column(name = "source_amount")
    private BigDecimal sourceAmount;

    @Column(name = "source_currency")
    private Currency sourceCurrency;

    @Column(name = "target_amount")
    private BigDecimal targetAmount;

    @Column(name = "target_currency")
    private Currency targetCurrency;

    @Column(name = "fx_rate")
    private Double fxRate;

    private TransactionStatus status;

    @Column(name = "created_at")
    private Date createdAt;

}
