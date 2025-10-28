package com.ssg.membertest.members.v2.repository;

import com.ssg.membertest.members.v2.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {

    private static final RowMapper<MemberVO> MEMBER_ROW_MAPPER = (rs, rowNum) -> {
        Date joinDate = rs.getDate("joinDate");
        return MemberVO.builder()
                .userId(rs.getString("userId"))
                .userPwd(rs.getString("userPwd"))
                .userName(rs.getString("userName"))
                .userEmail(rs.getString("userEmail"))
                .joinDate(joinDate != null ? joinDate.toLocalDate() : null)
                .build();
    };

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insert(MemberVO vo) {
        String sql = "insert into members values(?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                vo.getUserId(),
                vo.getUserPwd(),
                vo.getUserName(),
                vo.getUserEmail(),
                Date.valueOf(vo.getJoinDate()));
    }

    @Override
    public List<MemberVO> findAll() {
        String sql = "select * from members";
        return jdbcTemplate.query(sql, MEMBER_ROW_MAPPER);
    }

    @Override
    public Optional<MemberVO> findById(String userId) {
        String sql = "select * from members where userId = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, MEMBER_ROW_MAPPER, userId));
    }

    @Override
    public boolean update(MemberVO vo) {
        String sql = "update members set userPwd = ?, userName = ?, userEmail = ? where userId = ?";
        int affected = jdbcTemplate.update(sql, vo.getUserPwd(), vo.getUserName(), vo.getUserEmail(), vo.getUserId());
        return affected == 1;
    }

    @Override
    public boolean delete(String userId) {
        String sql = "delete from members where userId = ?";
        int affected = jdbcTemplate.update(sql, userId);
        return affected == 1;
    }
}
