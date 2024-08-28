package crudpractice.crudpractice.repository;

import crudpractice.crudpractice.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

@Slf4j
public class MemberRepositoryV4 implements MemberRepository{

    private final JdbcTemplate template;

    public MemberRepositoryV4 (DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save (Member member) {
        String sql = "Insert into member(member_id, money) values(?,?)";

        template.update(sql, member.getMemberId(), member.getMoney());
        return member;
    }

    @Override
    public Member findById (String id) {
        String sql = "select * from member where member_id = ?";

        return template.queryForObject(sql, memberRowMapper(), id);
    }

    @Override
    public void update (String memberId, int money) {
        String sql = "update member set money = ? where member_id = ?";
        template.update(sql, money, memberId);
    }

    @Override
    public void delete (String id) {
        String sql = "delete from member where member_id = ?";
        template.update(sql, id);
    }

    private static RowMapper<Member> memberRowMapper () {
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setMemberId(rs.getString("member_id"));
            member.setMoney(rs.getInt("money"));
            return member;
        };
    }
}
