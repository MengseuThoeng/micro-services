package org.ite.oauth2.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Table(name = "authorities")
@Entity
@Data
@NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "authorities",fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<User> user;
}
