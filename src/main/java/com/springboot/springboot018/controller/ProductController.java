package com.springboot.springboot018.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.springboot018.pojo.Product;
import com.springboot.springboot018.service.IProductService;
import com.springboot.springboot018.web.Response;
import com.springboot.springboot018.web.Response.Code;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService iProductService;
	
	@PostMapping(value="/product/save")
	public Response<Product> saveProduct(@ModelAttribute(value="product") Product product) {
		int i = iProductService.addProduct(product);
		Response<Product> res = new Response<Product>();
		if(i>0) {
			res.setCode(Code.Success);
		} else {
			res.setCode(Code.Fail);
		}
		return res;
	}
	
	@DeleteMapping("/product/{id}")
	public Response<Product> deleteProduct(@PathVariable(value="id") String productIds) {
		int i = iProductService.deleteProduct(Arrays.asList(productIds.split(",")));
		Response<Product> res = new Response<Product>();
		if(i>0) {
			res.setCode(Code.Success);
		} else {
			res.setCode(Code.Fail);
		}
		return res;
	}
	
	@PostMapping("/product/update")
	public Response<Product> updateProduct(@ModelAttribute(name="product") Product product) {
		int i = iProductService.updateProduct(product);
		Response<Product> res = new Response<Product>();
		if(i>0) {
			res.setCode(Code.Success);
		} else {
			res.setCode(Code.Fail);
		}
		return res;
	}
	
	@GetMapping("/product")
	public Response<Map<String,Object>> queryProductAll() {
		List<Map<String, Object>>  rs = iProductService.queryProduct();
		return new Response<Map<String,Object>>().setCode(Code.Success).setT(rs);
	}
	
	@GetMapping("/product/{id}")
	public Response<Map<String,Object>> queryProductById(@PathVariable(value="id") String productId) {
		Map<String, Object> productMap = iProductService.queryProductById(productId);
		return new Response<Map<String,Object>>().setCode(Code.Success).setT(Arrays.asList(productMap));
	}
	
}
