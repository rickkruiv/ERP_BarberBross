package com.barberbross.BarberBross.service;

import com.barberbross.BarberBross.model.Empresa;
import com.barberbross.BarberBross.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa salvarEmpresa(Empresa novaEmpresa){return empresaRepository.save(novaEmpresa);}

    public List<Empresa> listarEmpresas(){return empresaRepository.findAll();}

    public Empresa buscarEmpresaPorId(Long id){
        return empresaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Nenhuma empresa encontrada com o id: " + id));
    }

    public Empresa editarEmpresa(Long id, Empresa empresa){
        Empresa empresaEditada = buscarEmpresaPorId(id);

        empresaEditada.setRazaoSocial(empresa.getRazaoSocial());
        empresaEditada.setNomeFantasia(empresa.getNomeFantasia());
        empresaEditada.setCnpj(empresa.getCnpj());
        empresaEditada.setEmail(empresa.getEmail());
        empresaEditada.setEnderecoid(empresa.getEnderecoid());
        empresaEditada.setTelefone(empresa.getTelefone());
        empresaEditada.setTipoAssinatura(empresa.getTipoAssinatura());
        empresaEditada.setAgendamentos(empresa.getAgendamentos());

        return empresaRepository.save(empresaEditada);
    }

    public void deletarEmpresa(Long id){
        Empresa empresaDeletada = buscarEmpresaPorId(id);
        empresaRepository.delete(empresaDeletada);
    }


}
