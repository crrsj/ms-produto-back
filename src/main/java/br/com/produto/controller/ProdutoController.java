package br.com.produto.controller;

import br.com.produto.entity.Produto;
import br.com.produto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    @Operation(summary = "Endpoint responsável pelo cadastro de produtos.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Produto>salvarProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(produto));
    }

    @GetMapping
    @Operation(summary = "Endpoint responsável pela busca de produtos.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<Produto>>listarProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint responsável pela busca de produtos pelo id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Produto>buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Endpoint responsável pela atualização de produtos pelo id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Produto>atualizarProdutos(@PathVariable Long id,@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizarProduto(id,produto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint responsável por excluir produtos pelo id.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>excluirProduto(@PathVariable Long id){
        produtoService.excluirProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
