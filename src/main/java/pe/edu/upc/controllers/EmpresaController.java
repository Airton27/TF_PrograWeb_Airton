package pe.edu.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Empresa;
import pe.edu.upc.serviceinterfaces.IEmpresaService;

@Named
@RequestScoped
public class EmpresaController {
	@Inject
	private IEmpresaService eService;

	// metodos
	@PostConstruct
	public void init() {
		this.listaEmpresas = new ArrayList<Empresa>();
		this.e = new Empresa();
		this.list();
	}

	public String newEmpresa() {
		this.setE(new Empresa());
		return "empresa.xhtml";
	}

	public void insert() {
		try {
			eService.insert(e);
		} catch (Exception e) {
			System.out.println("Error ocurrio en el controlador de empresa al insertar");
		}
	}

	public void list() {
		try {
			listaEmpresas = eService.list();
		} catch (Exception e) {
			System.out.println("Error al listar empresas en el controller");
		}
	}

	public void delete(Empresa ems) {
		try {
			eService.delete(ems.getIdEmpresa());
		} catch (Exception e) {
			System.out.println("Error al eliminar empresas en el controller");
		}
	}

	// atributos
	private Empresa e;
	List<Empresa> listaEmpresas;

	// getters & setters
	public Empresa getE() {
		return e;
	}

	public void setE(Empresa e) {
		this.e = e;
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

}
