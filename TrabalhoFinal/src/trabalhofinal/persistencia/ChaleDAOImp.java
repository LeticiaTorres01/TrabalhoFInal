package trabalhofinal.persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalhofinal.negocio.Chale;

public class ChaleDAOImp implements ChaleDAO {
	@Override
	public String inserir(Chale cha) {
		String sql = "insert into chale(codChale,capacidade,localizacao,valorAltaEstacao,valorBaixaEstacao)values (?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, cha.getCodChale());
			pst.setInt(2,  cha.getCapacidade());
			pst.setString(3, cha.getLocalizacao());
			pst.setDouble(4, cha.getValorAltaEstacao());
			pst.setDouble(5, cha.getValorBaixaEstacao());

			int res = pst.executeUpdate();
			if (res > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String alterar(Chale cha) {
		String sql = "update chale set capacidade=?,localizacao=?,valorAltaEstacao=?,valorBaixaEstacao=? where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, cha.getCapacidade());
			pst.setString(2,  cha.getLocalizacao());
			pst.setDouble(3, cha.getValorAltaEstacao());
			pst.setDouble(4, cha.getValorBaixaEstacao());
			pst.setInt(5, cha.getCodChale());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String excluir(Chale cha) {
		String sql = "delete from chale where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, cha.getCodChale());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Excluído com sucesso.";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Chale> listarTodos() {
		String sql = "select * from chale";
		Connection con = ConnectionFactory.getConnection();
		List<Chale> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Chale ep = new Chale();
					ep.setCodChale(rs.getInt(1));
					ep.setCapacidade(rs.getInt(2));
					ep.setLocalizacao(rs.getString(3));
					ep.setValorAltaEstacao(rs.getDouble(4));
					ep.setValorBaixaEstacao(rs.getDouble(5));

					lista.add(ep);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public Chale pesquisarPorCodChale(int codChale) {
		String sql = "select * from chale where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, codChale);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Chale ep = new Chale();
				ep.setCodChale(rs.getInt(1));
				ep.setCapacidade(rs.getInt(2));
				ep.setLocalizacao(rs.getString(3));
				ep.setValorAltaEstacao(rs.getDouble(4));
				ep.setValorBaixaEstacao(rs.getDouble(5));
				return ep;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
}