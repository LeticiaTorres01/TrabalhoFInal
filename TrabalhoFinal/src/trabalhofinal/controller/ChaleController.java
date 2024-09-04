package trabalhofinal.controller;
import java.util.List;
import trabalhofinal.negocio.Chale;
import trabalhofinal.persistencia.ChaleDAOImp;

public class ChaleController {
	public String inserir(Chale cha) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.inserir(cha);
	}

	public String alterar(Chale cha) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.alterar(cha);
	}

	public String excluir(Chale cha) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.excluir(cha);
	}

	public List<Chale> listarTodos() {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.listarTodos();
	}

	public Chale pesquisarPorCodChale(int codChale) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.pesquisarPorCodChale(codChale);
	}
}