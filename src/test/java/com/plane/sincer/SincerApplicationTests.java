package com.plane.sincer;

import com.plane.sincer.entity.Dept;
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

import java.util.Date;
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
	void addUser(){
		User user = new User();
		user.setUserName("phoebe");
		user.setPassWord("123456");
		user.setCreateTime(new Date());
		Dept dept = new Dept();
		dept.setDeptName("生产部");
		deptService.save(dept);
		user.setDeptId(dept.getId());
		Role role = new Role();
		role.setName("机修人员");
		roleService.save(role);
		user.setRoleId(role.getId());
		userService.save(user);
	}

	@Test
	void getUser(){
		User user = userService.getUserByName("admin");
		System.out.println(user);
	}

	@Test
	void getAllUser(){
		List<User> list = userService.list();
		list.forEach(System.out::println);
	}
}
