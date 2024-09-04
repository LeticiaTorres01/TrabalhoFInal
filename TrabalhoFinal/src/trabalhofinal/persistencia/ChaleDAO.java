package trabalhofinal.persistencia;
import java.util.List;

import trabalhofinal.negocio.Chale;

public interface ChaleDAO {
	public String inserir(Chale cha);
	public String alterar(Chale emp);
	public String excluir(Chale emp);
	public List<Chale> listarTodos();
	public Chale pesquisarPorCodChale(int codChale);
}
