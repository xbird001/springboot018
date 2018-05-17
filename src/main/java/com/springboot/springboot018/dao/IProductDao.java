package com.springboot.springboot018.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springboot.springboot018.pojo.Product;

@Mapper
public interface IProductDao {
	
	@Insert("INSERT INTO T_PRODUCT (PRODUCT_ID,PRODUCT_NAME,PRODUCT_TYPE,PRODUCT_PRICE) VALUES(#{productId},#{productName},#{productType},#{productPrice})")
	int addProduct(Product product);
	
	@Delete("DELETE FROM T_PRODUCT T WHERE T.PRODUCT_ID IN (#{productId})")
	int deleteProduct(String productId);
	
	@Update("UPDATE T_PRODUCT T SET T.PRODUCT_NAME = #{productName}, T.PRODUCT_PRICE = #{productPrice}, T.PRODUCT_TYPE = #{productType} WHERE T.PRODUCT_ID = #{productId}")
	int updateProduct(Product product);
	
	@Select("SELECT T.PRODUCT_ID,T.PRODUCT_NAME,T.PRODUCT_PRICE,T.PRODUCT_TYPE FROM T_PRODUCT T WHERE T.PRODUCT_ID = #{productId}")
	Map<String,Object> queryProductById(String productId);
	
	@Select("SELECT T.PRODUCT_ID,T.PRODUCT_NAME,T.PRODUCT_PRICE,T.PRODUCT_TYPE FROM T_PRODUCT T")
	List<Map<String,Object>> queryProduct();

}
