package webstationapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webstationapi.Entity.Pack;
import webstationapi.Service.PackService;

@RestController
@RequestMapping(path = "/pack")
@EnableAutoConfiguration
public class PackController {
	
	@Autowired
	private PackService packService;
	
	@GetMapping("/")
	public List<Pack> getAllPacks() {
		return packService.getAllPacks();
	}

}
