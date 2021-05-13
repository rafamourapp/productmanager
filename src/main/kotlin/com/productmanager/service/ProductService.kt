package com.productmanager.service

import com.productmanager.model.Product
import com.productmanager.repositorie.ProductRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun all(): List<Product>{ return productRepository.findAll().toList() }

    fun findById(id: Long): Product { return productRepository.findById(id).orElseThrow{ EntityNotFoundException() } }

    fun existsById(id: Long): Boolean { return productRepository.existsById(id) }

    fun deleteById(id: Long) { return productRepository.deleteById(id) }

    fun save(product: Product): Product { return productRepository.save(product) }

    fun alter(id: Long, product: Product): Product {
        val safeProduct = product.copy(id = id)
        return save(safeProduct)
    }
}