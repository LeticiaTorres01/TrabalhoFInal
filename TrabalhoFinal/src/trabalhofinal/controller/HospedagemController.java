package trabalhofinal.controller;
import java.util.List;

import trabalhofinal.negocio.Hospedagem;
import trabalhofinal.persistencia.HospedagemDAOImp;

public class HospedagemController {
	public String inserir(Hospedagem hos) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.inserir(hos);
	}

	public String alterar(Hospedagem hos) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.alterar(hos);
	}

	public String excluir(Hospedagem hos) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.excluir(hos);
	}

	public List<Hospedagem> listarTodos() {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.listarTodos();
	}

	public Hospedagem pesquisarPorCodHospedagem(int codHospedagem) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarPorCodHospedagem(codHospedagem);
	}
}