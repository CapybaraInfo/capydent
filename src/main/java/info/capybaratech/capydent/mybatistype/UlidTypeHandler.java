package info.capybaratech.capydent.mybatistype;

import com.github.f4b6a3.ulid.Ulid;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UlidTypeHandler extends BaseTypeHandler<Ulid> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Ulid parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter.toString());
    }

    @Override
    public Ulid getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if(value != null && !value.isBlank() && Ulid.isValid(value)) {
            return Ulid.from(value);
        }
        return null;
    }

    @Override
    public Ulid getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if(value != null && !value.isBlank() && Ulid.isValid(value)) {
            return Ulid.from(value);
        }
        return null;
    }

    @Override
    public Ulid getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if(value != null && !value.isBlank() && Ulid.isValid(value)) {
            return Ulid.from(value);
        }
        return null;
    }
}
