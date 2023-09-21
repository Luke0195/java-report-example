package br.com.jasperreportexample.userslist.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO implements Serializable {
    private Long id;
    private String name;
    private String email;
    @JsonProperty("brith_date")
    private Date brithDate;
    private Double salary;
}
