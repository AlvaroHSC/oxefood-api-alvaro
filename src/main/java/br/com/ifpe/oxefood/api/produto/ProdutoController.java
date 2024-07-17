package br.com.ifpe.oxefood.api.produto;

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

import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProdutoService;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
   private CategoriaProdutoService categoriaProdutoService;


    @Operation(
        summary = "Serviço responsável por salvar um produto no sistema.", 
        description = "Exemplo de descrição de um endpoint responsável por salvar um produto no sistema."
    )

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoRequest request) {

        Produto produtoNovo = request.build();
        produtoNovo.setCategoria(categoriaProdutoService.obterPorID(request.getIdCategoria()));
        Produto produto = produtoService.save(produtoNovo);
        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }

    @Operation(
        summary = "Serviço responsável por requisitar um produto no sistema.", 
        description = "Exemplo de descrição de um endpoint responsável por requisitar um produto no sistema."
    )

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listaTodos();
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable Long id) {
        return produtoService.obterPorID(id);
    }

    @Operation(
        summary = "Serviço responsável por atualizar um produto no sistema.", 
        description = "Exemplo de descrição de um endpoint responsável por atualizar um produto no sistema."
    )

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {

        Produto produto = request.build();
        produto.setCategoria(categoriaProdutoService.obterPorID(request.getIdCategoria()));
        produtoService.update(id, produto);
 
        return ResponseEntity.ok().build();
    }

    @Operation(
        summary = "Serviço responsável por deletar um produto no sistema.", 
        description = "Exemplo de descrição de um endpoint responsável por deletar um produto no sistema."
    )

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
