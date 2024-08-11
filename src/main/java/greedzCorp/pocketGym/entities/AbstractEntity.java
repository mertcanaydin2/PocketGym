package greedzCorp.pocketGym.entities;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntity {

    @Column(name = "ST_ID")
    private long stId;

    @Column(name = "IS_ACTV")
    private boolean isActv;

    LocalDateTime now = LocalDateTime.now();
    String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    @Column(name = "CREATE_DATE")
    private String createDate = formattedDate;

    @Column(name = "CREATE_USER")
    private String createUser;

    @Column(name = "UPDATE_USER")
    private String updateUser;

    @Column(name = "UPDATE_DATE")
    private String updateDate;
}
