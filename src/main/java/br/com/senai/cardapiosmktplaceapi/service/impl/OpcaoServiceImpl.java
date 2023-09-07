package br.com.senai.cardapiosmktplaceapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.google.common.base.Preconditions;

import br.com.senai.cardapiosmktplaceapi.entity.Categoria;
import br.com.senai.cardapiosmktplaceapi.entity.Opcao;
import br.com.senai.cardapiosmktplaceapi.entity.Restaurante;
import br.com.senai.cardapiosmktplaceapi.entity.enums.Status;
import br.com.senai.cardapiosmktplaceapi.repository.CardapiosRepository;
import br.com.senai.cardapiosmktplaceapi.repository.OpcoesRepository;
import br.com.senai.cardapiosmktplaceapi.repository.RestaurantesRepository;
import br.com.senai.cardapiosmktplaceapi.service.CategoriaService;
import br.com.senai.cardapiosmktplaceapi.service.OpcaoService;
import br.com.senai.cardapiosmktplaceapi.service.RestauranteService;

public class OpcaoServiceImpl implements OpcaoService {
	
	@Autowired
	private OpcoesRepository repository;
	
	@Autowired
	private CardapiosRepository cardapiosRepository;
	
	@Autowired
	@Qualifier("categoriaServiceImpl")
	private CategoriaService categoriaService;
	
	@Autowired
	@Qualifier("restauranteServiceImpl")
	private RestauranteService restauranteService;
	
	@Override
	public Opcao salvar(Opcao opcao) {
		Opcao outraOpcao = repository.buscarPor(opcao.getNome());
		if(outraOpcao != null) {
			if(outraOpcao.isPersistida()) {
				Preconditions.checkArgument(outraOpcao.equals(opcao),"O nome da opção já está em uso");
			}
		}
		this.categoriaService.buscarPor(opcao.getCategoria().getId());
		this.restauranteService.buscarPor(opcao.getRestaurante().getId());
		Opcao opcaoSalva = repository.save(opcao);
		return opcaoSalva;
	}

	@Override
	public void atualizarStatusPor(Integer id, Status status) {
		Opcao opcaoEncontrada = repository.buscarPor(id);
		Preconditions.checkNotNull(opcaoEncontrada, "Não existe opção vinculada ao id informado");
		Preconditions.checkArgument(opcaoEncontrada.getStatus() != status, "O status já está salvo para a opção");
		this.repository.atualizarPor(id, status);
	}

	@Override
	public Page<Opcao> listarPor(String nome, Categoria categoria, Restaurante restaurante, Pageable paginacao) {
		return repository.listarPor(nome + "%", categoria, restaurante, paginacao);
	}

	@Override
	public Opcao buscarPor(Integer id) {
		Opcao opcaoEncontrada = repository.buscarPor(id);
		Preconditions.checkNotNull(opcaoEncontrada, "Não existe opção vinculada ao id informado");
		Preconditions.checkArgument(opcaoEncontrada.isAtiva(), "A opção está inativa");
		return opcaoEncontrada;
	}

	@Override
	public Opcao excluirPor(Integer id) {
		Opcao opcaoParaExclusao = repository.buscarPor(id);
		Long qtdeDeCardapiosVinculados = cardapiosRepository.contarPor(id);
		Preconditions.checkArgument(qtdeDeCardapiosVinculados == 0, "Não é possível remover, pois existem cardápios vinculados");
		this.repository.deleteById(opcaoParaExclusao.getId());
		return opcaoParaExclusao;
	}

}
