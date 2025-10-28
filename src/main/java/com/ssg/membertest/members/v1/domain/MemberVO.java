package com.ssg.membertest.members.v1.domain;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

    private String mid;
    private String mpw;
    private String mname;
}
