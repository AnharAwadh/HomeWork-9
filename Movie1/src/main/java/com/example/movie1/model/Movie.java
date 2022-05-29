package com.example.movie1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Data@AllArgsConstructor@NoArgsConstructor
@Entity
@Table
public class Movie {
@Id
@Column(nullable = false,length =3 )
private Integer id;
@Column(nullable = false,unique = true)
private String name;
@Column(nullable = false,unique = true)
@Pattern(regexp = "Drama|Actiov|Comedy",message = "the movie must be Drama or Action or comedy")
private String genre;
@NotNull(message = " rating required")
@Positive(message = " must be positive")
@Min(value = 1,message = " The rate must be 1-5")
@Max(value = 5,message = " The rate must be 1-5")
private Integer rating;
@NotNull(message = " duration required")
//@Min(value = 60,message = " The duration must be more 60")
private Integer duration;
@NotNull(message = " launchDate must be date yyy-mm-dd hh:mm:ss")
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
private Date launchDate;



}
