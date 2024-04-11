package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor //인자 없는 생성자
public class Offer {
    private int id;

    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 chars")
    private String name;

    @Email(message = "please provide a valid email address")
    @NotEmpty(message = "The email address can't be empty")
    private String email;

    @Size(min = 5, max = 100, message = "Text must be between 5 and 100 chars")
    private String text;
}
