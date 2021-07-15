package com.devTest.Movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devTest.Movies.model.Movies;
import com.devTest.Movies.repository.MoviesRepository;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/movies")
public class MoviesController {

	@Autowired
	private MoviesRepository repository;

	@GetMapping
	public ResponseEntity<List<Movies>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{movieId}") //ENCONTRE PELO ID
	public ResponseEntity<Movies>GetById(@PathVariable long movieId){
		return repository.findById(movieId)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build()); //CASO NÃO TENHA O ID NO BANCO DE DADOS [404 NOT FOUND] 
	}
	
	@GetMapping ("/title/{title}") //ENCONTRE PELO TITULO
	public ResponseEntity<List<Movies>> GetByTitle (@PathVariable String title){
		return ResponseEntity.ok(repository.findAllByTitleContainingIgnoreCase(title));
	}
	
	@PostMapping // INSERIR DADOS
	public ResponseEntity <Movies> post (@RequestBody Movies movies){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(movies));
	}
	
	@PutMapping // ATUALIZAR DADOS
	public ResponseEntity<Movies> put (@RequestBody Movies movies){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(movies));
	}
	
	@DeleteMapping("/{movieId}") //DELETAR DADOS
	public void delete(@PathVariable long movieId) {
		repository.deleteById(movieId);
	}
	
}
