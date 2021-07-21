package com.raphael.votacoop;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raphael.votacoop.domain.Pauta;
import com.raphael.votacoop.domain.SessaoVotacao;
import com.raphael.votacoop.domain.Usuario;
import com.raphael.votacoop.domain.Voto;
import com.raphael.votacoop.domain.enums.StatusPauta;
import com.raphael.votacoop.domain.enums.StatusSessao;
import com.raphael.votacoop.resources.repositories.PautaRepository;
import com.raphael.votacoop.resources.repositories.SessaoVotacaoRepository;
import com.raphael.votacoop.resources.repositories.UsuarioRepository;
import com.raphael.votacoop.resources.repositories.VotoRepository;

@SpringBootApplication
public class VotacoopApplication implements CommandLineRunner {

	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VotoRepository votoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(VotacoopApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Date dataHoraAtual = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SimpleDateFormat sdfTempo = new SimpleDateFormat("HH:mm");
			
		Pauta p1 = new Pauta(null, "Votação para saber se SIM ou NÃO", StatusPauta.ABERTA, dataHoraAtual);
		
		SessaoVotacao sv1 = new SessaoVotacao(null, dataHoraAtual, sdfTempo.parse("01:00"), StatusSessao.EM_VOTACAO, p1);
		p1.setSessaoVotacao(sv1);
		
		sv1.setStatusSessao(StatusSessao.VOTADA.getCod());
		
		pautaRepository.saveAll(Arrays.asList(p1));
		sessaoVotacaoRepository.saveAll(Arrays.asList(sv1));
		
		Usuario usu1 = new Usuario(null, "Raphael Philippe", "05888397792", "raphael@gmail.com");
		Usuario usu2 = new Usuario(null, "Andrea Barcelos", "10626365708", "andrea@gmail.com");
		usuarioRepository.saveAll(Arrays.asList(usu1, usu2));
		
		Voto v1 = new Voto(null, "Sim", dataHoraAtual, sv1, usu1);
		Voto v2 = new Voto(null, "Não", dataHoraAtual, sv1, usu2);
		votoRepository.saveAll(Arrays.asList(v1, v2));
			
	}

}
