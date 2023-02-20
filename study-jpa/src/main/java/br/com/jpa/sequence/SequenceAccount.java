package br.com.jpa.sequence;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceAccount implements IdentifierGenerator, Configurable {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object o) {
        Connection connection = session.connection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT nextval (SQ_ACCOUNT) as nextval");
            ResultSet rs = ps.executeQuery();

            rs.next();
            Long id = rs.getLong("nextval");
            return id;

        } catch (SQLException e) {
            throw new HibernateException(e.getMessage());
        }
    }

}
