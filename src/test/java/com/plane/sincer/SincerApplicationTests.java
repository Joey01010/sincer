package com.plane.sincer;

import com.plane.sincer.entity.ProductList;
import com.plane.sincer.entity.Role;
import com.plane.sincer.entity.User;
import com.plane.sincer.service.DeptService;
import com.plane.sincer.service.ProductListService;
import com.plane.sincer.service.RoleService;
import com.plane.sincer.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SincerApplicationTests {

	@Autowired
	private ProductListService productListService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private DeptService deptService;

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
	@Test
	void getDept(){
		System.out.println(deptService.getById(34));
	}

	@Test
	void getDeptList(){
		deptService.list().forEach(System.out::println );
	}

	@Test
	void addRole(){
		Role role = new Role();
		role.setRoleName("管理员");
		role.setPerAddr(Arrays.asList("*").toString());
		roleService.save(role);
	}

	@Test
	void addUser(){

	}

	@Test
	void getUser(){

	}

	@Test
	void getAllUser(){
		List<User> list = userService.list();
		list.forEach(System.out::println);
	}
}
