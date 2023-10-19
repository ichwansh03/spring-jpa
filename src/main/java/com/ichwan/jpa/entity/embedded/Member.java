package com.ichwan.jpa.entity.embedded;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Email cannot blank")
    private String email;

    @Embedded
    private Name name;

    @ElementCollection
    @CollectionTable(name = "hobbies", joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"))
    @Column(name = "name")
    private List<String> hobbies;

    /**
     * pada Map, attribute key disimpan pada @MapKeyColumn,
     * sementara value tetap pada @Column
     */
    @ElementCollection
    @CollectionTable(name = "skills", joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    private Map<String, Integer> skills;
}
