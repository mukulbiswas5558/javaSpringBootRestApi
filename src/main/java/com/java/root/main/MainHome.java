package com.java.root.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.root.services.UserService;
import com.java.root.entities.Category;
import com.java.root.payloads.UserDto;



@RestController
@RequestMapping("/api/v1/")
public class MainHome {
	@Autowired
	private UserService userService;
	@GetMapping("/main")
	public String getAllPost(
			) {

		return "hello response";
	}
	@GetMapping("/mains")
	public Map<String, String> sayHello() {
		HashMap<String, String> map = new HashMap<>();
		map.put("key", "value");
		map.put("foo", "bar");
		map.put("aa", "bb");
		return map;
	}

	@GetMapping("/mains/{postId}")
	public ResponseEntity<ArrayList<String>> getPostById(@PathVariable Integer postId) {
		ArrayList<String> cars = new ArrayList<String>();
		cars.add("Volvo"+postId);
		cars.add("BMW"+postId);
		cars.add("Ford"+postId);
		cars.add("Mazda"+postId);

		return new ResponseEntity<ArrayList<String>>(cars, HttpStatus.OK);

	}
	@GetMapping("/geta")
	public ResponseEntity<List<Category>> getAllUsers() {
		List<Category> categories = this.userService.getAllUsers();
		return ResponseEntity.ok(categories);
	}

}
