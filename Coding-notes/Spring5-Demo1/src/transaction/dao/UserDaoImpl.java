package transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addLucy() {
        String sql = "update count set money = money + ? where name = ?";
        jdbcTemplate.update(sql, 100, "lucy");
    }

    @Override
    public void cutMarry() {
        String sql = "update count set money = money - ? where name = ?";
        jdbcTemplate.update(sql, 100, "marry");
    }
}
