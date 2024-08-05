package greedzCorp.pocketGym.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "NAT_ID")
    private String natId;
    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "AGE")
    private String age;
    @Column(name = "GYM_NAME")
    private String gymName;
    @Column(name = "PARTY_TYPE")
    private String partyType;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY_NAME")
    private String cityName;
    @Column(name = "district")
    private String district;
    @Column(name = "CREATE_DATE")
    private String createDate;
}
