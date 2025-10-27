package com.ssg.membertest.members.dao;

import com.ssg.membertest.members.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {

    private final DataSource dataSource;

    @Override
    public void insert(MemberVO vo) throws Exception {
        String sql = "insert into t_member values(?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, vo.getMid());
            preparedStatement.setString(2, vo.getMpw());
            preparedStatement.setString(3, vo.getMname());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<MemberVO> selectAll() throws Exception {
        String sql = "select * from t_member";
        List<MemberVO> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    MemberVO vo = MemberVO.builder()
                            .mid(rs.getString("mid"))
                            .mpw(rs.getString("mpw"))
                            .mname(rs.getString("mname"))
                            .build();
                    list.add(vo);
                }
            }
        }
        return list;
    }
}
