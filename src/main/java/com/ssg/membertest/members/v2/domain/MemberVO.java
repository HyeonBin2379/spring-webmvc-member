package com.ssg.membertest.members.v2.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

    private String userId;
    private String userPwd;
    private String userName;
    private String userEmail;
    private LocalDate joinDate;
}
