package webstationapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webstationapi.DTO.PackDTO;
import webstationapi.Service.PackService;

@RestController
@RequestMapping(path = "/pack")
@EnableAutoConfiguration
public class PackController {
	
	@Autowired
	private PackService packService;
	
	@GetMapping("/")
	public List<PackDTO> getAllPacks() {
		return packService.getAllPacks();
	}

}
