package nesalmanov.ru.bank_api.entity;


import jakarta.persistence.*;
import lombok.Data;
import nesalmanov.ru.bank_api.entity.enums.TransactionStatus;

import java.util.Date;
import java.util.UUID;


@Entity
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(name = "created_at")
    private Date createdAt;

}
