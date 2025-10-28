package com.ssg.membertest.members.v2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private String userId;
    private String userPwd;
    private String userName;
    private String userEmail;
    private LocalDate joinDate;
}
