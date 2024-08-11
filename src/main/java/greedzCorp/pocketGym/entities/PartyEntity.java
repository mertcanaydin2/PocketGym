package greedzCorp.pocketGym.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.PasswordAuthentication;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PARTY")
public class PartyEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

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

    @Column(name = "CREATE_DATE")
    private String createDate;

    @Column(name = "PARTY_STATE")
    private Long partyState;

    @Column(name = "WALLET")
    private Long wallet;

    @Column(name = "PASSWORD")
    private String password;
}
