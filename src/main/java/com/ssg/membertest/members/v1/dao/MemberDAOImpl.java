package com.ssg.membertest.members.v1.dao;

import com.ssg.membertest.members.v1.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Qualifier("basicMemberDAO")
//@Repository
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

    @Override
    public Optional<MemberVO> selectOne(String mid) throws Exception {
        String sql = "select * from t_member where mid = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, mid);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    MemberVO memberVO = MemberVO.builder()
                            .mid(rs.getString("mid"))
                            .mpw(rs.getString("mpw"))
                            .mname(rs.getString("mname"))
                            .build();
                    return Optional.ofNullable(memberVO);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public String insertOne(MemberVO vo) throws Exception {
        String sql = "insert into t_member values(?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, vo.getMid());
            preparedStatement.setString(2, vo.getMpw());
            preparedStatement.setString(3, vo.getMname());

            int affected = preparedStatement.executeUpdate();
            return affected == 1 ? vo.getMid() : "";
        }
    }

    @Override
    public boolean updateOne(MemberVO vo) throws Exception {
        String sql = "update t_member set mpw = ? where mid = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, vo.getMpw());
            preparedStatement.setString(2, vo.getMid());

            int affected = preparedStatement.executeUpdate();
            return affected == 1;
        }
    }

    @Override
    public boolean deleteOne(String mid) throws Exception {
        String sql = "delete from t_member where mid = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, mid);

            int affected = preparedStatement.executeUpdate();
            return affected == 1;
        }
    }
}
