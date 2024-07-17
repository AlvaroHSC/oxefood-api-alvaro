package br.com.ifpe.oxefood.api.categoriaproduto;

import java.util.List;

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

import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categoriaproduto")
@CrossOrigin
public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping
    public ResponseEntity<CategoriaProduto> save(@RequestBody @Valid CategoriaProdutoRequest request) {

        CategoriaProduto categoriaProdutoNovo = request.build();
        CategoriaProduto categoriaProduto = categoriaProdutoService.save(categoriaProdutoNovo);
        return new ResponseEntity<CategoriaProduto>(categoriaProduto, HttpStatus.CREATED);
    }

    // @Operation(
    //     summary = "Serviço responsável por requisitar uma promoção no sistema.", 
    //     description = "Exemplo de descrição de um endpoint responsável por requisitar uma promoção no sistema."
    // )

    @GetMapping
    public List<CategoriaProduto> listarTodos() {
        return categoriaProdutoService.listaTodos();
    }

    @GetMapping("/{id}")
    public CategoriaProduto obterPorID(@PathVariable Long id) {
        return categoriaProdutoService.obterPorID(id);
    }

    // @Operation(
    //     summary = "Serviço responsável por atualizar uma promoção no sistema.", 
    //     description = "Exemplo de descrição de um endpoint responsável por atualizar uma promoção no sistema."
    // )

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody CategoriaProdutoRequest request) {

        categoriaProdutoService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    // @Operation(
    //     summary = "Serviço responsável por deletar um promoção no sistema.", 
    //     description = "Exemplo de descrição de um endpoint responsável por deletar uma promoção no sistema."
    // )

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        categoriaProdutoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
