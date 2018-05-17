package com.springboot.springboot018.service;

import java.util.List;
import java.util.Map;
import com.springboot.springboot018.pojo.Product;

public interface IProductService {
	/**
	 * 保存产品
	 * @param product
	 * @return
	 */
	int addProduct(Product product);
	/**
	 * 删除产品
	 * @param productList
	 * @return
	 */
	int deleteProduct(List<String> productId);
	/**
	 * 跟新产品
	 * @param product
	 * @return
	 */
	int updateProduct(Product product);
	/**
	 * 根据ID查询产品
	 * @param productId
	 * @return
	 */
	Map<String,Object> queryProductById(String productId);
	/**
	 * 查询产品
	 * @return
	 */
	List<Map<String,Object>> queryProduct();

}
