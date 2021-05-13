package com.productmanager.controller

import com.productmanager.model.Product
import com.productmanager.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun list(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(productService.all().toList())
    }

    @GetMapping("/{id}")
    fun find(@PathVariable("id") id: Long): ResponseEntity<Product>{
        return ResponseEntity.ok(productService.findById(id))
    }

    @PostMapping
    fun create(@Valid @RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity.ok(productService.save(product))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @Valid @RequestBody product: Product): ResponseEntity<Product> {
        if (productService.existsById(id))
            return ResponseEntity.ok(productService.alter(id, product))

        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Unit> {
        if (productService.existsById(id))
            return ResponseEntity.ok(productService.deleteById(id))

        return ResponseEntity.notFound().build()
    }
}