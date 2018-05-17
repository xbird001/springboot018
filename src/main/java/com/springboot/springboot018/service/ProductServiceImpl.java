package com.springboot.springboot018.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.springboot018.dao.IProductDao;
import com.springboot.springboot018.pojo.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao iProductDao;
	
	@Transactional
	@Override
	public int addProduct(Product product) {
		product.setProductId(UUID.randomUUID().toString().replaceAll("-", ""));
		return iProductDao.addProduct(product);
	}
	
	@Transactional
	@Override
	public int deleteProduct(List<String> ids) {
		StringBuilder sb = new StringBuilder();
		for (String id : ids) {
			sb.append(id).append(",");
		}
		if(sb.length() > 0) {
			sb.deleteCharAt(sb.length()-1);
		}
		return iProductDao.deleteProduct(sb.toString());
	}
	
	@Transactional
	@Override
	public int updateProduct(Product product) {
		return iProductDao.updateProduct(product);
	}
	
	@Override
	public Map<String,Object> queryProductById(String productId) {
		return iProductDao.queryProductById(productId);
	}
	
	@Override
	public List<Map<String,Object>> queryProduct() {
		return iProductDao.queryProduct();
	}

	public IProductDao getiProductDao() {
		return iProductDao;
	}

	public void setiProductDao(IProductDao iProductDao) {
		this.iProductDao = iProductDao;
	}
	
	
	
}
