package com.plane.sincer;

import com.plane.sincer.entity.ProductList;
import com.plane.sincer.service.ProductListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SincerApplicationTests {

	@Autowired
	private ProductListService productListService;

	@Test
	void contextLoads() {
		ProductList productList = new ProductList();
		productList.setPdLine("A线");
		productList.setType("2VG");
		productList.setPdCode("60212-TVA-A001-H1");
		productList.setPdName("STAY R,FENDER");
		productList.setSpec("M6四角螺母");
		productList.setCt(4.0);
		productList.setCount(1);
		productList.setProcessNo("1/1");
		productList.setAssist(1);
		productList.setMcCode("A-HD-13");
		productListService.save(productList);
	}

	@Test
	void importProductList(){
		productListService.importProductListByLocal("BOM.xlsx");
	}
}
