package br.com.alura.literalura;

import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.service.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	private final AutorRepository autorRepository;
	private final LivroRepository livroRepository;
	private final ConsumoApi consumoApi; // já injetado via construtor

	public LiteraluraApplication(AutorRepository autorRepository,
								 LivroRepository livroRepository,
								 ConsumoApi consumoApi) {
		this.autorRepository = autorRepository;
		this.livroRepository = livroRepository;
		this.consumoApi = consumoApi;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Exemplos de uso: busca e salva livros na base
		String[] titulosParaBuscar = {"dom casmurro", "dom quixote"};

		for (String titulo : titulosParaBuscar) {
			System.out.println("Buscando livro: " + titulo);
			int quantidadeSalvos = consumoApi.salvarLivrosGutendex(titulo);
			if (quantidadeSalvos == 0) {
				System.out.println("Nenhum livro encontrado para: " + titulo);
			} else {
				System.out.println(quantidadeSalvos + " livro(s) salvo(s) com sucesso!");
			}
		}
	}
}